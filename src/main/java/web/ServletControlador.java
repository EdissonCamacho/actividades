package web;

import datos.ClienteDao;
import dominio.Usuarios;
import dominio.Tarea;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")

public class ServletControlador extends HttpServlet {
    
    String accion = "";
    
    @Override
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        accion = request.getParameter("accion");
        
        if (accion != null || accion == "") {
            
            switch (accion) {
                case "eliminarUsuario":
                    this.eliminarUsuarios(request, response);
                    break;
                
                case "cargarUsuarios":
                    this.cargarUsuarios(request, response);
                    
                    break;
                
               
                case "buscarClienteMod":
                    this.buscarCliente(request, response);
                    break;
                
            }
            
        }
        
    }
    
    @Override
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        accion = request.getParameter("accion");
        
        if (accion != null || accion == "") {
            
            switch (accion) {
                case "insertarUsuario":
                    this.insertarUsuario(request, response);
                    break;
                
                case "modificarUsuario":
                    this.modUsuario(request, response);
                    
                    break;
                
            }
            
        }
        
    }
    
   
    
    public void buscarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String id = request.getParameter("idUsuario");
        
        int idUsuario = Integer.parseInt(id);
        
        Usuarios cliente = new Usuarios(idUsuario);
        
        Usuarios resultado = new ClienteDao().buscarDatosId(cliente);
        
        request.setAttribute("usuarioModifica", resultado);
        String jspEditar = "/WEN-INF/modales/modificar.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
        
    }
    
    public void insertarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String documento = request.getParameter("documento");
        String contraseña = request.getParameter("contraseña");
        
        Usuarios usuario = new Usuarios(nombre, apellido, telefono,documento,contraseña);
        
        int registrosModificdos = new ClienteDao().insertarUsuario(usuario);
        this.cargarUsuarios(request, response);
        
    }
    
    public void modUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String id = request.getParameter("idUsuario");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String documento = request.getParameter("documento");
        String contraseña = request.getParameter("contraseña");
        
        int idUsuario = Integer.parseInt(id);
        Usuarios usuario = new Usuarios(idUsuario, nombre, apellido, telefono,documento,contraseña);
        int resultado = new ClienteDao().modificarUsuario(usuario);
        this.cargarUsuarios(request, response);
        
    }
    
    public void eliminarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String id = request.getParameter("idUsuario");
        
        int idUsuario = Integer.parseInt(id);
        
        Usuarios usuario = new Usuarios(idUsuario);
        int registrosModificdos = new ClienteDao().elimimarUsuario(usuario);
        this.cargarUsuarios(request, response);
        
    }
    
    public void cargarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Usuarios> usuarios = new ClienteDao().listarUsuario();
        
       
        request.setAttribute("usuarios", usuarios);
        
        String jspEditar = "usuarios.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
        
    }
    
}
