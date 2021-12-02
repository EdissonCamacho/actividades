package dominio;

public class UsuarioTarea {

    private int idUsuarioTarea;
    private int idUsuario;
    private int idTarea;
    private String fecha;
    private String actividad;
    private String descripcion;
    private int estado;
    private String nombre;
    private String apellido;
    private String telefono;

    public UsuarioTarea(int idUsuarioTarea, int idUsuario, int idTarea) {
        this.idUsuarioTarea = idUsuarioTarea;
        this.idUsuario = idUsuario;
        this.idTarea = idTarea;
    }

    public UsuarioTarea(int idUsuarioTarea) {
        this.idUsuarioTarea = idUsuarioTarea;
    }

    public UsuarioTarea(int idUsuario, int idTarea) {
        this.idUsuario = idUsuario;
        this.idTarea = idTarea;
    }

    public UsuarioTarea(int idUsuarioTarea, int idUsuario, int idTarea, String fecha, String actividad, String descripcion, int estado, String nombre, String apellido, String telefono) {
        this.idUsuarioTarea = idUsuarioTarea;
        this.idUsuario = idUsuario;
        this.idTarea = idTarea;
        this.fecha = fecha;
        this.actividad = actividad;
        this.descripcion = descripcion;
        this.estado = estado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public UsuarioTarea(int idTarea, String fecha, String actividad, String descripcion, int estado) {
        this.idTarea = idTarea;
        this.fecha = fecha;
        this.actividad = actividad;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    
    

    public UsuarioTarea(int idUsuarioTarea, String nombre, String apellido) {
        this.idUsuarioTarea = idUsuarioTarea;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    

    public int getIdUsuarioTarea() {
        return idUsuarioTarea;
    }

    public void setIdUsuarioTarea(int idUsuarioTarea) {
        this.idUsuarioTarea = idUsuarioTarea;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
    
    
    
    
    
    
    

    
    
    

}
