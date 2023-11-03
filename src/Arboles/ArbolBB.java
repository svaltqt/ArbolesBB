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
        Nodo p = raiz, ant = null;
        boolean sw = false;

        while (p != null && !sw) {
            ant = p;
            if (Id.compareTo(p.getId()) > 0) {
                p = p.getLd();
            } else if (Id.compareTo(p.getId()) < 0) {
                p = p.getLi();
            } else {
                sw = true;
            }
        }

        if (sw) {
            JOptionPane.showMessageDialog(null, "La Identificación ya existe");
        } else {
            p = new Nodo(Id, Nombre, Edad, Nota);

            if (raiz == null) {
                raiz = p;
            } else {
                if (Id.compareTo(ant.getId()) < 0) {
                    ant.setLi(p);
                } else {
                    ant.setLd(p);
                }
            }
        }
    }
}
