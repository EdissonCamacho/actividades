<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>

    <c:when test="${estado=='1'}">
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalAsignarActividad">
            <i class="fas fa-plus fa-spin"></i> Asigne La Actividad
        </button>


    </c:when>    
    <c:otherwise>


        <button type="button" class="btn btn-danger disabled" data-bs-toggle="modal" data-bs-target="#modalAsignarActividad">
            <i class="fas fa-plus"></i> Asigne La Actividad
        </button>



    </c:otherwise>
</c:choose>




<div class="modal fade" id="modalAsignarActividad" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Asignar</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">

                <form action="${pageContext.request.contextPath}/ServletTareas?accion=asignarTarea" method="POST">
                    <div class="mb-3">
                        <label for="usuario" class="form-label">Usuario</label>
                        <select name="usuarioAsignar" class="form-control">
                            <c:forEach var="usuario" items="${usuarios}" varStatus="status" >

                                <option value="${usuario.idUsuario}">${usuario.nombre} ${usuario.apellido} </option>
                            </c:forEach>



                        </select>

                        <input type="hidden" class="form-control" name="idActividadAsignada" value="${idTarea}" >
                    </div>


            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button class="btn btn-primary" type="submit">Guardar</button>
            </div>
            </form>
        </div>
    </div>
</div>
