<%--
  Created by IntelliJ IDEA.
  User: Niurka
  Date: 14/06/2022
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Beans.listaReproduccion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.listaReproduccion>" scope="request" id="listaReproduccion"/>
<html>
<jsp:include page="/static/head.jsp">
    <jsp:param name="title" value="Lista de Canciones Favoritas"/>
</jsp:include>
<body>
<div class='container'>
    <jsp:include page="/includes/navbar.jsp">
        <jsp:param name="page" value="favoritas"/>
    </jsp:include>
    <div class="pb-5 pt-4 px-3 titlecolor">
        <div class="col-lg-6">
            <h1 class='text-light'>Lista de Canciones Favoritas</h1>
        </div>
    </div>
    <div class="tabla">
        <table class="table table-dark table-transparent table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>CANCION</th>
                <th>BANDA</th>

            </tr>
            </thead>
            <%
                for (listaReproduccion favoritas : listaReproduccion) {
            %>

            <tbody>
            <tr>
                <td><%=favoritas.getIdlista()%>
                </td>
                <td><%=favoritas.getNombre()%>
                </td>

            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>

</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>
