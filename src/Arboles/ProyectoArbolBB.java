package Arboles;
import javax.swing.JOptionPane;

public class ProyectoArbolBB {

    public static void main(String[] args) {
        String Id, Nombre;
        int Edad, opcion;
        float Nota;
        String menu = "MENÚ\n"
                + "1- Insertar\n"
                + "2- Mostrar en PreOrden\n"
                + "3- Mostrar en InOrden\n"
                + "4- Mostrar en PostOrden\n"
                + "5- Verificar iD\n"
                + "6- Mostrar Altura del arbol\n"
                + "7- Actualizar\n"
                + "0- Salir\n"
                + "Digite Opción";

        ArbolBB abb = new ArbolBB();

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                case 1:
                    Id = JOptionPane.showInputDialog("Ingrese el Id");
                    Nombre = JOptionPane.showInputDialog("Ingrese el Nombre");
                    Edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad"));
                    Nota = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la nota"));
                    abb.Insertar(Id, Nombre, Edad, Nota);
                    break;
                case 2:
                    if (abb.getRaiz() == null) {
                        System.out.println("Arbol vacio");
                    } else {
                        System.out.println("Mostrar en Preorden:");
                        abb.RecorridoPreorden(abb.getRaiz());
                    }
                    break;
                case 3:
                    if (abb.getRaiz() == null) {
                        System.out.println("Arbol vacio");
                    } else {
                        System.out.println("Mostrar en Inorden");
                        abb.RecorridoInorden(abb.getRaiz());
                    }
                    break;
                case 4:
                    if (abb.getRaiz() == null) {
                        System.out.println("Arbol vacio");
                    } else {
                        System.out.println("Mostrar en Postorden");
                        abb.RecorridoPosorden(abb.getRaiz());
                    }
                    break;
                case 5:
                    Id = JOptionPane.showInputDialog("Ingrese el Id");
                    abb.BuscarNodo(Id);
                    break;
                case 6:
                    // Altura del Arbol
                    break;
                case 7:
                    // Actualizar Elemento;
                    break;
                case 0:
                    System.exit(0);
            }

        } while (true);
    }
}
