
package datos;

import dominio.Tarea;
import dominio.UsuarioTarea;
import dominio.Usuarios;
import java.sql.*;
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
    
    
    
    
}
