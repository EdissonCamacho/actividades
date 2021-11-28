<div class="modal fade" id="modificarModalTarea" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modificar Tarea</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">

                <form action="${pageContext.request.contextPath}/ServletTareas?accion=modificarTarea" method="POST">
                    <div class="mb-3">
                        <label for="fecha" class="form-label">Fecha:  <div id="valorFecha"></div> </label><br><!-- comment -->
                        <input type="date" class="form-control" id="fechaValor" name="fecha">
                    </div>
                    <div class="mb-3">
                        <label for="actividad" class="form-label">Nombre Actividad</label>
                        <input type="text" class="form-control" id="nombreActividad" name="actividad" >
                    </div>
                    
                    

                    <div class="mb-3">
                        <label for="descripcion" class="form-label">Descripcion</label>
                        <input type="textarea" class="form-control" id="descripcion" name="descripcion" >
                        <input type="hidden" class="form-control" id="idTarea" name="idTarea" >
                    </div>
                    
                    <div class="mb-3">
                        <label for="estado" class="form-label">Estado</label>
                        <select name="estado" id="estado" class="form-control">
                            <option value="1">Activo</option>
                            <option value="2">Inactivo</option>
                        </select>
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