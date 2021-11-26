package dominio;

public class UsuarioTarea {

    private int idUsuarioTarea;
    private int idUsuario;
    private int idTarea;

    public UsuarioTarea(int idUsuarioTarea) {
        this.idUsuarioTarea = idUsuarioTarea;
    }

    public UsuarioTarea(int idUsuario, int idTarea) {
        this.idUsuario = idUsuario;
        this.idTarea = idTarea;
    }

    public UsuarioTarea(int idUsuarioTarea, int idUsuario, int idTarea) {
        this.idUsuarioTarea = idUsuarioTarea;
        this.idUsuario = idUsuario;
        this.idTarea = idTarea;
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
    
    public String valores(){
        String ValoresTotales=this.idTarea+" "+this.idUsuario+" "+ this.idUsuarioTarea;
        return ValoresTotales;
        
    }
    
    

}
