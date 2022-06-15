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







}


