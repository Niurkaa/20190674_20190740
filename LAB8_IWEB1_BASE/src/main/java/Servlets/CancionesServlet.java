package Servlets;

import Beans.Cancion;
import Beans.Tour;
import Daos.CancionesDao;
import Daos.TourDao;

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
        System.out.println(action);
        CancionesDao cancionesDao = new CancionesDao();

        if(action.equals("listar")){
            ArrayList<Cancion> listaCanciones = cancionesDao.obtenerListaCanciones();
            request.setAttribute("lista1","hola");
            request.setAttribute("listaCancionesBanda",listaCanciones);
            RequestDispatcher view =request.getRequestDispatcher("listaCanciones.jsp");
            view.forward(request,response);

        }
        else{
            ArrayList<Cancion> listaCancionesBanda = cancionesDao.obtenerListaCancionesBanda(action);
            System.out.println(listaCancionesBanda.size());
            request.setAttribute("lista1","banda");

            request.setAttribute("listaCancionesBanda",listaCancionesBanda);

            RequestDispatcher view =request.getRequestDispatcher("listaCanciones.jsp");
            view.forward(request,response);
        }





    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
