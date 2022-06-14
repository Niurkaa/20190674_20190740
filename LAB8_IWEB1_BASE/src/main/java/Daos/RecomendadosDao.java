package Daos;

import Beans.Banda;
import Beans.Cancion;

import java.sql.*;
import java.util.ArrayList;

public class RecomendadosDao {

    public static ArrayList<Cancion> listarRecomendados() {
        ArrayList<Cancion> listarRecomendados= new ArrayList<>();
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
             ResultSet rs = stmt.executeQuery("select idcancion,nombre_cancion,banda from cancion ca inner join reproduccion re on re.cancion_idcancion = ca.idcancion group by cancion_idcancion having count(*) >2 order by count(*) desc;");) {

            while (rs.next()) {

                Cancion cancion = new Cancion(rs.getInt(1),rs.getString(2),rs.getString(3));

                listarRecomendados.add(cancion);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listarRecomendados;
    }



}
