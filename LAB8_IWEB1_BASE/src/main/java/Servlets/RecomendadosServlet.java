package Servlets;

import Beans.Cancion;
import Daos.CancionesDao;
import Daos.RecomendadosDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RecomendadosServlet",urlPatterns = {"/listaRecomendados"})
public class RecomendadosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecomendadosDao recomendadosDao = new RecomendadosDao();
        ArrayList<Cancion> listaRecomendados = recomendadosDao.listarRecomendados();

        request.setAttribute("listaRecomendados",listaRecomendados);

        RequestDispatcher view =request.getRequestDispatcher("listaRecomendados.jsp");
        view.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
