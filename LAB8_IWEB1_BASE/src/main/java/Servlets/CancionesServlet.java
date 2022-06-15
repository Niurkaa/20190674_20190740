package Servlets;

import Beans.Cancion;
import Beans.Tour;
import Daos.CancionesDao;
import Daos.TourDao;
import Daos.listaReproduccionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CancionesServlet", value = "/listaCanciones")
public class CancionesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("id") == null ? "listar" : request.getParameter("id");
        CancionesDao cancionesDao = new CancionesDao();
        String action2 = request.getParameter("anadirfav") == null ? "0" : request.getParameter("anadirfav");
        System.out.println("favoritos "+ action2);
        System.out.println("accion"+ action);
        if(action.equals("listar")){
            ArrayList<Cancion> listaCanciones = cancionesDao.obtenerListaCanciones();
            request.setAttribute("lista1","hola");
            request.setAttribute("listaCancionesBanda",listaCanciones);
            int action3 = Integer.parseInt(action2);
            if(action3!=0){
                listaReproduccionDao listareproduccion = new listaReproduccionDao();
                listareproduccion.anadirFavoritos(action3);
            }

            RequestDispatcher view =request.getRequestDispatcher("listaCanciones.jsp");
            view.forward(request,response);

        }



        else {
                ArrayList<Cancion> listaCancionesBanda = cancionesDao.obtenerListaCancionesBanda(action);
                request.setAttribute("lista1", "banda");
                request.setAttribute("listaCancionesBanda", listaCancionesBanda);
                int action3 = Integer.parseInt(action2);
                if(action3!=0){
                listaReproduccionDao listareproduccion = new listaReproduccionDao();
                listareproduccion.anadirFavoritos(action3);
                }
                RequestDispatcher view = request.getRequestDispatcher("listaCanciones.jsp");
                view.forward(request, response);


        }








    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }






}
