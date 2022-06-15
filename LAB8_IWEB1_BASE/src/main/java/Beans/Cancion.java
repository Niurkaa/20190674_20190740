package Beans;

public class Cancion {
    private int idCancion;
    private String nombre_cancion;
    private String banda;
    private int listaReproduccion;

    public int getListaReproduccion() {
        return listaReproduccion;
    }

    public void setListaReproduccion(int listaReproduccion) {
        this.listaReproduccion = listaReproduccion;
    }

    public Cancion(int idCancion, String nombre_cancion, String banda ) {
        this.idCancion = idCancion;
        this.nombre_cancion=nombre_cancion;
        this.banda= banda;
    }
    public Cancion() {

    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombre_cancion() {
        return nombre_cancion;
    }

    public void setNombre_cancion(String nombre_cancion) {
        this.nombre_cancion = nombre_cancion;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }
}
