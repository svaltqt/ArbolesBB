package Arboles;

import javax.swing.JOptionPane;

public class ArbolBB {

    private Nodo raiz;

    // Método Constructor
    public ArbolBB() {
        raiz = null;
    }

    // Método para obtener la raíz
    public Nodo getRaiz() {
        return raiz;
    }

    // Método corto para imprimir
    static void print(Object obj) {
        System.out.println(obj);
    }

    // Método para Mostrar en Preorden
    public void RecorridoPreorden(Nodo R) {
        if (R != null) {
            System.out.println(
                    "ID: " + R.getId() +
                            ", Nombre: " + R.getNombre() +
                            ", Edad: " + R.getEdad() +
                            ", Nota: " + R.getNota()
            );
            RecorridoPreorden(R.getLi());
            RecorridoPreorden(R.getLd());
        }
    }

    // Método para Mostrar en Inorden
    public void RecorridoInorden(Nodo R) {
        if (R != null) {
            RecorridoInorden(R.getLi());
            System.out.println(R.getId() + " " + R.getNombre() + " " + R.getEdad() + " " + R.getNota() + "\n");
            RecorridoInorden(R.getLd());
        }
    }

    // Método para Mostrar en Posorden
    public void RecorridoPosorden(Nodo R) {
        if (R != null) {
            RecorridoPosorden(R.getLi());
            RecorridoPosorden(R.getLd());
            System.out.println(R.getId() + " " + R.getNombre() + " " + R.getEdad() + " " + R.getNota() + "\n");
        }
    }

    public void Insertar(int Id, String Nombre, int Edad, float Nota) {
        Nodo nuevoNodo = new Nodo(Id, Nombre, Edad, Nota);

        // Se inicializan dos nodos, p para recorrer el árbol y ant para mantener el nodo anterior
        Nodo p = raiz, ant = null;

        // Se recorre el árbol mientras p no sea nulo
        while (p != null) {
            ant = p; // Se actualiza el nodo anterior con el nodo actual

            // Si la identificación a insertar es mayor que la del nodo actual, se mueve a la derecha
            if (Id > p.getId()) {
                p = p.getLd();
            }
            // Si la identificación a insertar es menor o igual que la del nodo actual, se mueve a la izquierda
            else {
                p = p.getLi();
            }
        }

        // El nuevo nodo se inserta en la posición adecuada (ya sea a la izquierda o a la derecha)
        if (raiz == null) {
            // Si el árbol está vacío, el nuevo nodo se convierte en la raíz
            raiz = nuevoNodo;
        } else {
            System.out.println("Valor de ID: " + Id + "\n Valor de Anterior ID: " + ant.getId());
            if (Id < ant.getId()) {
                ant.setLi(nuevoNodo);
                System.out.println(Id + " Insertado a la izquierda de " + ant.getId());
            } else {
                ant.setLd(nuevoNodo);
                System.out.println(Id + " Insertado a la derecha de " + ant.getId());
            }
        }
    }

    /* Buscar Nodo*/

    public void BuscarNodo(int Id) {
        Nodo p = raiz;
        boolean sw = false;
        while (p != null && !sw) {
            if (Id > p.getId()) {
                p = p.getLd();
            } else if (Id < p.getId()) {
                p = p.getLi();
            } else {
                sw = true;
            }
        }
        if (sw) {
            JOptionPane.showMessageDialog(null, "Ya existe el ID");
        } else {
            JOptionPane.showMessageDialog(null, "El ID No existe");
        }
    }
}
