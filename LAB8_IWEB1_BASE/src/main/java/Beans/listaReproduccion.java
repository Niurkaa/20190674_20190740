package Beans;

public class listaReproduccion {
    private int idlista;
    private String nombre;

    public listaReproduccion(int idlista, String nombre) {
        this.idlista = idlista;
        this.nombre=nombre;

    }

    public int getIdlista() {
        return idlista;
    }

    public void setIdlista(int idlista) {
        this.idlista = idlista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
