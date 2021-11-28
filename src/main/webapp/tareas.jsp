


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="WEB-INF/similares/navbar.jsp"/>

<br>
<br>
<div class="container">
    <jsp:include page="WEB-INF/modales/modalInsertarTarea.jsp"/>
    
    <jsp:include page="WEB-INF/modales/modificarTarea.jsp"></jsp:include>

    




    <br>
    <br>
    <br>
    <div class="row">
        <div class="col-md-9">


            <table id="tablaTarea" class="table table-dark table-striped">
                <thead>
                    <tr>
                        <th>Fecha</th>
                        <th>Actividad</th>
                        <th>Descripcion</th>
                        <th>Estado</th>
                        <th>Accion</th>
                    </tr>


                </thead>
                <tbody>
                    <c:forEach var="tarea" items="${tareas}" varStatus="status" >







                        <tr>
                            <td>${tarea.fecha}</td>
                            <td>${tarea.actividad}</td>
                            <td>${tarea.descripcion}</td>
                            <td><c:choose>
                                    <c:when test="${tarea.estado==1}">
                                        Activo

                                    </c:when>    
                                    <c:otherwise>
                                        Inactivo

                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td><a id="btnModificarTarea" fecha='${tarea.fecha}' actividad='${tarea.actividad}' descripcion='${tarea.descripcion}' estado='${tarea.estado}' idActividad='${tarea.idTarea}' data-bs-toggle="modal" data-bs-target="#modificarModalTarea" class="btn btn-primary">
                                    <i class="fa-regular fa-folder-bookmark"></i>Modificar</a>
                                <a href="${pageContext.request.contextPath}/ServletTareas?accion=eliminarTarea&idTarea=${tarea.idTarea}"   class="btn btn-danger">
                                    <i class="fa-light fa-xmark"></i> Eliminar</a>
                                    
                                    <a href="${pageContext.request.contextPath}/ServletTareas?accion=asignar&idTarea=${tarea.idTarea}&nombreTarea=${tarea.actividad}&estado=${tarea.estado}"   class="btn btn-info"> Asignar
                                    </a>                                 
                        </tr>

                    </c:forEach>

                </tbody>
            </table>
        </div>
    </div>

</div>

</div>

</div>



