



<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="WEB-INF/similares/navbar.jsp"/>

<br>
<br>
<div class="container">
    <jsp:include page="WEB-INF/modales/modalInsertarRegistro.jsp"/>
    
</div>

    

<br>
<jsp:include page="WEB-INF/modales/modificar.jsp"/>
<br>
<div class="container">

   

    <br>
    <br>
    <div class="row">
        <div class="col-md-9">


            <table id="tablaUsuario" class="table table-dark table-striped">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Telefono</th>
                        <th>Acciones</th>
                    </tr>


                </thead>
                <tbody>
                    <c:forEach var="usuario" items="${usuarios}" varStatus="status" >





                        <tr>
                            <td>${usuario.nombre}</td>
                            <td>${usuario.apellido}</td>
                            <td>${usuario.telefono}</td>
                            <td><a id="btnModificar" nombre='${usuario.nombre}' apellido='${usuario.apellido}' telefono='${usuario.telefono}' idUsuario='${usuario.idUsuario}'  documento="${usuario.documento}" data-bs-toggle="modal" data-bs-target="#modUsuario" class="btn btn-primary">
                                    Modificar </a>
                                <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminarUsuario&idUsuario=${usuario.idUsuario}"   class="btn btn-danger">
                                    Eliminar</a>
                        </tr>

                    </c:forEach>

                </tbody>
            </table>
        </div>
    </div>

</div>





