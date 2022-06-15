package Daos;

import Beans.Banda;
import Beans.Cancion;

import java.sql.*;
import java.util.ArrayList;

public class CancionesDao {

    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1";


    public ArrayList<Cancion> obtenerListaCanciones() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Cancion> listaCanciones = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT idcancion,nombre_cancion,banda,listaReproduccion_idlista FROM lab6sw1.cancion order by banda ;")) {

            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String banda = rs.getString(3);
                int listareproduccion = rs.getInt(4);

                listaCanciones.add(new Cancion(id, nombre, banda));
            }

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listaCanciones;

    }

    public ArrayList<Cancion> obtenerListaCancionesBanda(String filter) {

        ArrayList<Cancion> listaCancionesBanda = new ArrayList<>();

        String sql = "select * from cancion where banda = ?";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, filter);

            try (ResultSet rs = pstmt.executeQuery();) {

                while (rs.next()) {
                    Cancion cancion = new Cancion();
                    cancion.setIdCancion(rs.getInt(1));
                    cancion.setNombre_cancion(rs.getString(2));
                    cancion.setBanda(rs.getString(3));
                    cancion.setListaReproduccion(rs.getInt(4));
                    listaCancionesBanda.add(cancion);

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCancionesBanda;
    }

    public static ArrayList<Cancion> listarfavoritos() {
        ArrayList<Cancion> listaFavoritos= new ArrayList<>();
        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/lab6sw1";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("select idcancion,nombre_cancion,banda,listaReproduccion_idlista from cancion where listaReproduccion_idlista = 1;");) {

            while (rs.next()) {
                Cancion cancion = new Cancion();
                cancion.setIdCancion(rs.getInt(1));
                cancion.setNombre_cancion(rs.getString(2));
                cancion.setBanda(rs.getString(3));
                cancion.setListaReproduccion(rs.getInt(4));

                listaFavoritos.add(cancion);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaFavoritos;
    }


}
