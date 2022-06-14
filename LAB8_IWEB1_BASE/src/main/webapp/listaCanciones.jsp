<%--
  Created by IntelliJ IDEA.
  User: Niurka
  Date: 14/06/2022
  Time: 00:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Beans.Cancion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.Cancion>" scope="request" id="listaCancionesBanda"/>
<jsp:useBean type="java.lang.String" scope="request" id="lista1"/>
<html>
<jsp:include page="/static/head.jsp">
    <jsp:param name="title" value="Lista de Canciones"/>
</jsp:include>
<body>
<div class='container'>
    <jsp:include page="/includes/navbar.jsp">
        <jsp:param name="page" value="canciones"/>
    </jsp:include>
    <%if(lista1.equals("banda")){%>
    <div class="pb-5 pt-4 px-3 titlecolor">
        <div class="col-lg-6">
            <h1 class='text-light'>Lista de Canciones Por Banda</h1>
        </div>
        <a class="btn btn-warning" href="<%=request.getContextPath()%>/listaCanciones">Mostrar todas las canciones</a>
    </div>
    <%} else{%>

    <div class="pb-5 pt-4 px-3 titlecolor">
        <div class="col-lg-6">
            <h1 class='text-light'>Lista de Canciones por Banda
                <a class="btn btn-warning" href="">Mostrar todas las canciones</a> </h1>


        </div>
    </div>
    <%}%>



    <div class="tabla">
        <table class="table table-dark table-transparent table-hover">
            <thead>
            <th>ID</th>
            <th>CANCIÓN</th>
            <th>BANDA</th>
            </thead>
            <%
                for (Cancion cancion : listaCancionesBanda) {
            %>
            <tr>
                <td><%=cancion.getIdCancion()%>
                </td>
                <td><%=cancion.getNombre_cancion()%>
                </td>
                <td><%=cancion.getBanda()%>
                </td>

            </tr>
            <%}
            %>
        </table>
    </div>


</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>
