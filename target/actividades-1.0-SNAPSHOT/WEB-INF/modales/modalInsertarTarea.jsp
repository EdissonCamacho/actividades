<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#ingresarTarea">
    <i class="fas fa-plus"></i> Registrar Tarea
</button>

<div class="modal fade" id="ingresarTarea" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Registrar Tarea</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">

                <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertarTarea" method="POST">
                    <div class="mb-3">
                        <label for="fecha" class="form-label">Fecha:</label>
                        <input type="date" class="form-control" name="fecha" >
                    </div>
                    <div class="mb-3">
                        <label for="actividad" class="form-label">Nombre Actividad</label>
                        <input type="text" class="form-control" name="actividad" >
                    </div>

                    <div class="mb-3">
                        <label for="descripcion" class="form-label">Descripcion</label>
                        <input type="textarea" class="form-control" name="descripcion" >
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