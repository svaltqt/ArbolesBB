package Arboles;

public class Nodo {

    private int id;
    private String nombre;
    private int edad;
    private float nota;
    private Nodo li;
    private Nodo ld;

// Método Constructor

    public Nodo(int id, String nombre, int edad, float nota) {

        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.nota = nota;
        li=null;
        ld=null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {

        this.edad = edad;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Nodo getLi() {
        return li;
    }

    public void setLi(Nodo li) {
        this.li = li;
    }

    public Nodo getLd() {
        return ld;
    }

    public void setLd(Nodo ld) {
        this.ld = ld;
    }

}
