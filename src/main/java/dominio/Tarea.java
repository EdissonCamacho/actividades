package dominio;

import java.util.Date;

public class Tarea {
    private int idTarea;
    private String fecha;
    private String actividad;
    private String descripcion;
    private int estado;

    public Tarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public Tarea(String fecha, String actividad, String descripcion, int estado) {
        this.fecha = fecha;
        this.actividad = actividad;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Tarea(int idTarea, String fecha, String actividad, String descripcion, int estado) {
        this.idTarea = idTarea;
        this.fecha = fecha;
        this.actividad = actividad;
        this.descripcion = descripcion;
        this.estado = estado;
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
    
    
    
    public String valores(){
        String ValoresTotales=this.idTarea+" "+this.fecha+" "+this.actividad+" "+this.estado;
        return ValoresTotales;
        
    }
    
}
