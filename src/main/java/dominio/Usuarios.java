
package dominio;


public class Usuarios {
    
    private int  idUsuario;
    private String nombre;
    private String apellido;
    private String telefono;
    private String documento;
    private String contraseña;

    public Usuarios() {
    }

    public Usuarios(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuarios(String nombre, String apellido, String telefono, String documento, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.documento = documento;
        this.contraseña = contraseña;
    }

    public Usuarios(int idUsuario, String nombre, String apellido, String telefono, String documento, String contraseña) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.documento = documento;
        this.contraseña = contraseña;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

 

  
    

  
    
    
}
