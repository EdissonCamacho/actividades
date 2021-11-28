
package datos;

import dominio.Tarea;
import dominio.UsuarioTarea;
import dominio.Usuarios;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;



public class ClienteDao {
    
    // metodos
    
    
    public List<Usuarios> listarUsuario(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuarios usuario = null;
        List<Usuarios> listaUsuarios = new ArrayList<>();
        
        try {
            conn=Conexion.getConnection();
            stmt=conn.prepareStatement("Select * from usuario");
            rs=stmt.executeQuery();
            while(rs.next()){
                int idUsuario=rs.getInt("idUsuario");
                String nombre = rs.getString("nombre");
                String apellido=rs.getString("apellido");
                String telefono=rs.getString("telefono");
                usuario=new Usuarios(idUsuario,nombre,apellido,telefono);
                listaUsuarios.add(usuario);
                
                
                
            };
            
            
            
        } catch (SQLException ex) {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
            
        }
        return listaUsuarios;
        
        
    }
    
     public List<Tarea> listarTareas(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tarea tarea = null;
        List<Tarea> listaTarea = new ArrayList<>();
        
        try {
            conn=Conexion.getConnection();
            stmt=conn.prepareStatement("Select * from actividad");
            rs=stmt.executeQuery();
            while(rs.next()){
                int idActividad=rs.getInt("idTarea");
                String fecha = new SimpleDateFormat("yyyy/MM/dd").format(rs.getDate("fecha"));
                
                String nactividad=rs.getString("actividad");
                String descripcion=rs.getString("descripcion");
                int estado=rs.getInt("estado");
              
               tarea= new Tarea(idActividad,fecha,nactividad,descripcion,estado);
               listaTarea.add(tarea);
               
               
                
                
                
            };
            
            
            
        } catch (SQLException ex) {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
            
        }
        return listaTarea;
        
        
    }
     
     public List<UsuarioTarea> listarTareasUsuario(Tarea tarea){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UsuarioTarea userTarea = null;
        List<UsuarioTarea> listaTarea = new ArrayList<>();
        
        try {
            conn=Conexion.getConnection();
            stmt=conn.prepareStatement("SELECT * FROM usuarioactividad inner join actividad on actividad.idTarea=usuarioactividad.idActividad inner join usuario on usuario.idUsuario=usuarioactividad.idUsuario where actividad.idTarea=?");
            stmt.setInt(1,tarea.getIdTarea());
            rs=stmt.executeQuery();
            while(rs.next()){
                
                 String nombre = rs.getString("nombre");
                 String apellido=rs.getString("apellido");
                 int idUsuarioTarea=rs.getInt("idUsuarioTarea");
                
              
               userTarea= new UsuarioTarea(idUsuarioTarea,nombre,apellido);
               
               listaTarea.add(userTarea);
               
               
                
                
                
            };
            
            
            
        } catch (SQLException ex) {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
            
        }
        return listaTarea;
        
        
    }
    
    public int insertarUsuario(Usuarios usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("INSERT INTO usuario(nombre,apellido,telefono) values(?,?,?)");
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getTelefono());
           

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
        
        
    }
    
    public int insertarAsignacion(UsuarioTarea usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("INSERT INTO usuarioActividad(idUsuario,idActividad) values(?,?)");
            stmt.setInt(1, usuario.getIdUsuario());
            stmt.setInt(2, usuario.getIdTarea());
            
           

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
        
        
    }
    
    
    
    public int insertarTarea(Tarea tarea){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("INSERT INTO actividad(fecha,actividad,descripcion,estado) values(?,?,?,?)");
            stmt.setString(1, tarea.getFecha());
            stmt.setString(2, tarea.getActividad());
            stmt.setString(3, tarea.getDescripcion());
            stmt.setInt(4, tarea.getEstado());
            
           

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
        
        
    }
    
    public int modificarUsuario(Usuarios usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("UPDATE usuario SET nombre=?,apellido=?,telefono=? WHERE idUsuario=?");
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getTelefono());
            stmt.setInt(4, usuario.getIdUsuario());
           

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
        
        
    }
    
    public int modificarTarea(Tarea tarea){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("UPDATE actividad SET fecha=?,actividad=?,descripcion=?,estado=? WHERE idTarea=?");
            stmt.setString(1, tarea.getFecha());
            stmt.setString(2, tarea.getActividad());
            stmt.setString(3, tarea.getDescripcion());
            stmt.setInt(4, tarea.getEstado());
            stmt.setInt(5, tarea.getIdTarea());
            
           

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
        
        
    }
    
    
    
    public int elimimarUsuario(Usuarios usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("Delete from usuario where idUsuario=?");
            stmt.setInt(1, usuario.getIdUsuario());
            
           

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
        
    }
    
     public int eliminarAsignacion(UsuarioTarea usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("Delete from usuarioactividad where idUsuarioTarea=?");
            stmt.setInt(1,usuario.getIdUsuarioTarea());
            
            
           

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
        
    }
    
    
    public int eliminarTarea(Tarea tarea){
          Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("Delete from actividad where idTarea=?");
            stmt.setInt(1, tarea.getIdTarea());
            
            
           

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
        
        
    }
    
    public Usuarios buscarDatosId(Usuarios usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM usuario where idUsuario=?");
            stmt.setInt(1, usuario.getIdUsuario());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto
            String idUsuario = rs.getString("idUsuario");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String telefono = rs.getString("telefono");
          

            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setTelefono(telefono);
            

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuario;
    }
    
     public Tarea buscarTareaId(Tarea tarea) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM actividad where idTarea=?");
            stmt.setInt(1, tarea.getIdTarea());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto
            int idTarea = rs.getInt("idFecha");
            String fecha = rs.getString("fecha");
            String actividad = rs.getString("actividad");
            String descripcion = rs.getString("descripcion");
            int estado =rs.getInt("idEstado");
            
            tarea.setIdTarea(idTarea);
            tarea.setFecha(fecha);
            tarea.setActividad(actividad);
            tarea.setDescripcion(descripcion);
            tarea.setEstado(estado);
            
            
          

           
            

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return tarea;
    }
    
    
    
    
    
}
