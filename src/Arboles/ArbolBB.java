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

    // Método para Mostrar en Preorden
    public void RecorridoPreorden(Nodo R) {
        if (R != null) {
            System.out.println(R.getId() + " " + R.getNombre() + " " + R.getEdad() + " " + R.getNota() + "\n");
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


    public void Insertar(String Id, String Nombre, int Edad, float Nota) {
        // Se inicializan dos nodos, p para recorrer el árbol y ant para mantener el nodo anterior
        Nodo p = raiz, ant = null;
        // Variable booleana para verificar si la identificación ya existe en el árbol
        boolean sw = false;

        // Se recorre el árbol mientras p no sea nulo y la variable sw sea falsa
        while (p != null && !sw) {
            ant = p; // Se actualiza el nodo anterior con el nodo actual

            // Si la identificación a insertar es mayor que la del nodo actual, se mueve a la derecha
            if (Id.compareTo(p.getId()) > 0) {
                p = p.getLd();
            }
            // Si la identificación a insertar es menor que la del nodo actual, se mueve a la izquierda
            else if (Id.compareTo(p.getId()) < 0) {
                p = p.getLi();
            }
            // Si la identificación a insertar es igual a la del nodo actual, se marca sw como verdadero y se sale del bucle
            else {
                sw = true;
            }
        }

        // Si sw es verdadero, significa que la identificación ya existe en el árbol, se muestra un mensaje de error
        if (sw) {
            JOptionPane.showMessageDialog(null, "La Identificación ya existe");
        }
        // Si sw es falso, se crea un nuevo nodo con los datos proporcionados y se inserta en el árbol
        else {
            p = new Nodo(Id, Nombre, Edad, Nota);

            // Si la raíz del árbol es nula, el nuevo nodo se convierte en la raíz
            if (raiz == null) {
                raiz = p;
            }
            // Si la raíz no es nula, se compara la identificación con la del nodo anterior
            // Si es menor, se inserta a la izquierda del nodo anterior, de lo contrario, se inserta a la derecha
            else {
                if (Id.compareTo(ant.getId()) < 0) {
                    ant.setLi(p);
                } else {
                    ant.setLd(p);
                }
            }
        }
    }


    /* Buscar Nodo*/

    public void BuscarNodo(String Id) {
        // Se inicializan dos nodos, p para recorrer el árbol y ant para mantener el nodo anterior
        Nodo p = raiz, ant = null;
        // Variable booleana para verificar si la identificación ya existe en el árbol
        boolean sw = false;

        // Se recorre el árbol mientras p no sea nulo y la variable sw sea falsa
        while (p != null && !sw) {
            ant = p; // Se actualiza el nodo anterior con el nodo actual

            // Si la identificación a insertar es mayor que la del nodo actual, se mueve a la derecha
            if (Id.compareTo(p.getId()) > 0) {
                p = p.getLd();
            }
            // Si la identificación a insertar es menor que la del nodo actual, se mueve a la izquierda
            else if (Id.compareTo(p.getId()) < 0) {
                p = p.getLi();
            }
            // Si la identificación a insertar es igual a la del nodo actual, se marca sw como verdadero y se sale del bucle
            else {
                sw = true;
            }
        }

        // Si sw es verdadero, significa que la identificación ya existe en el árbol, se muestra un mensaje de error
        if (sw) {
            JOptionPane.showMessageDialog(null, "Encontrado");


        }
        // Si sw es falso, se crea un nuevo nodo con los datos proporcionados y se inserta en el árbol
        else {
            JOptionPane.showMessageDialog(null, "El iD No existe");
        }
    }


}
