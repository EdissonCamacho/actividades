<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="WEB-INF/similares/navbar.jsp"></jsp:include>
    <br>
    <br>

    <br>
    <div class="container">
        <center>  <h1> ${nombreActividad}</h1> </center>
    <br>
    <br>

    



<br>
<br>


<jsp:include page="WEB-INF/modales/usuarioActividadModalInsert.jsp"/>
<br>
<br>






<div class="row">

    <div class="col-md-3">

        <div class="card text-white bg-primary mb-3" style="max-width: 18rem;">

            <div class="card-body">
                <h5 class="card-title">N° Asignaciones</h5>
                <p class="card-text">${cantidadUsuarios}</p>
            </div>

        </div>


        <c:choose>

            <c:when test="${estado=='1'}">
                <div class="card text-white bg-success mb-3" style="max-width: 18rem;">

                    <div class="card-body">
                        <h5 class="card-title">Estado</h5>
                        <p class="card-text">Actividad Activa </p>
                    </div>
                </div>


            </c:when>    
            <c:otherwise>


                <div class="card text-white bg-danger mb-3" style="max-width: 18rem;">

                    <div class="card-body">
                        <h5 class="card-title">Estado</h5>
                        <p class="card-text">Inactiva </p>
                    </div>
                </div>


            </c:otherwise>
        </c:choose>







    </div>
    <div class="col-md-9">

        <table class="table">
            <thead>
                <tr>

                    <th >Usuario</th>
                    <th >Accion</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="usuariosA" items="${usuariosAsignados}" varStatus="status" >

                    <tr>
                        <td>${usuariosA.nombre} ${usuariosA.apellido}  </td>
                        <td><a href="${pageContext.request.contextPath}/ServletTareas?accion=eliminarAsignacion&idAsignacion=${usuariosA.idUsuarioTarea}" class="btn btn-danger">Quitar</a><td>
                    </tr>



                </c:forEach>

            </tbody>
        </table>

    </div>

</div>
</div>
            
            