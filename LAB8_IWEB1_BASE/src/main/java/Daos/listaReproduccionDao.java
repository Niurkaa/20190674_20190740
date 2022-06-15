package Daos;

import Beans.Cancion;
import Beans.listaReproduccion;

import java.sql.*;
import java.util.ArrayList;

public class listaReproduccionDao {

    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";


    public ArrayList<listaReproduccion> obtenerListaReproduccion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<listaReproduccion> listaReproduccion = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT idfavoritas,nombre_favorita,banda_favorita,listaReproduccion_idlista FROM lab6sw1.listaReproduccion ;")) {

            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String banda = rs.getString(3);

                listaReproduccion.add(new listaReproduccion(id, nombre));
            }

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listaReproduccion;

    }
    public void anadirFavoritos(int idCancion) {
        String sql = "update cancion set listaReproduccion_idlista = 1 where idcancion = ?;";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setInt(1, idCancion);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Hubo un error en la conexión!");
            e.printStackTrace();
        }


    }


    public static ArrayList<Cancion> listarfavoritos() {
        ArrayList<Cancion> listaFavoritos= new ArrayList<>();
        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/centro1";

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


