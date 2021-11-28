package web;

import datos.ClienteDao;

import dominio.Tarea;
import dominio.Usuarios;
import dominio.UsuarioTarea;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletTareas")

public class ServletTareas extends HttpServlet {

    public String idTareaA = "";
    public String actividadA = "";
    public String estadoA= "";

    public String accion = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        accion = request.getParameter("accion");

        if (accion != null || accion == "") {

            switch (accion) {

                case "cargarTareas":
                    this.cargarTareas(request, response);

                case "eliminarTarea":

                    this.eliminarTarea(request, response);

                    break;

                case "asignar":
                    
                    this.asignarActividad(request, response);

                    break;
                    
                case "eliminarAsignacion":
                    
                    this.eliminarAsignacion(request, response);
                    
                    break;

            }

        }

    }

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        accion = request.getParameter("accion");

        if (accion != null || accion == "") {

            switch (accion) {
                case "insertarTarea":

                    this.insertarTarea(request, response);

                    break;

                case "modificarTarea":

                    this.modificarTarea(request, response);

                    break;
                    
                case "asignarTarea":
                    this.asignarTareaUsuario(request, response);
                    
                    break;
                    

            }

        }

    }
    
     public void asignarTareaUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         String usuario=request.getParameter("usuarioAsignar");
         String idTarea=request.getParameter("idActividadAsignada");
         int idUsuario=Integer.parseInt(usuario);
         
         HttpSession sesion = request.getSession();
         
         int id=Integer.parseInt(idTarea);
         
         UsuarioTarea user = new UsuarioTarea(idUsuario,id);
         
         int rows = new ClienteDao().insertarAsignacion(user);
         
         
         this.recargarAsignacion(request, response);
         
         
         
         
         
       

    }
     
     public void eliminarAsignacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         String idAsignacion = request.getParameter("idAsignacion");
         
         int id=Integer.parseInt(idAsignacion);
         
         UsuarioTarea tarea = new UsuarioTarea(id);
         
         int rows= new ClienteDao().eliminarAsignacion(tarea);
         
         this.recargarAsignacion(request, response);
         
         
        
        
         
         
         
         
         
       

    }

    
    
    
    
    
    

    public void asignarActividad(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        idTareaA = request.getParameter("idTarea");
        actividadA = request.getParameter("nombreTarea");
        estadoA= request.getParameter("estado");
        
        
        int idTarea = Integer.parseInt(idTareaA);

        Tarea tarea = new ClienteDao().buscarTareaId(new Tarea(idTarea));
        List<Usuarios> usuarios = new ClienteDao().listarUsuario();
        

        List<UsuarioTarea> userTarea = new ClienteDao().listarTareasUsuario(new Tarea(idTarea));
        int cantidadUsuarios = userTarea.size();
        HttpSession sesion= request.getSession();
        sesion.setAttribute("idTarea", idTarea);
        sesion.setAttribute("nombreActividad", actividadA);
        sesion.setAttribute("estado", estadoA);
        
        
        
        request.setAttribute("usuarios", usuarios);
        request.setAttribute("cantidadUsuarios", cantidadUsuarios);
        request.setAttribute("infoTarea", tarea);
        request.setAttribute("usuariosAsignados", userTarea);
        
        String jspEditar = "asignar.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
        
        
        
        
        
        

    }
    
    
     public void recargarAsignacion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        
        int idTarea = Integer.parseInt(idTareaA);

        Tarea tarea = new ClienteDao().buscarTareaId(new Tarea(idTarea));
        List<Usuarios> usuarios = new ClienteDao().listarUsuario();
        

        List<UsuarioTarea> userTarea = new ClienteDao().listarTareasUsuario(new Tarea(idTarea));
        int cantidadUsuarios = userTarea.size();
        HttpSession sesion= request.getSession();
        sesion.setAttribute("idTarea", idTarea);
        sesion.setAttribute("nombreActividad", actividadA);
        sesion.setAttribute("estado", estadoA);
        
        
        
        request.setAttribute("usuarios", usuarios);
        request.setAttribute("cantidadUsuarios", cantidadUsuarios);
        request.setAttribute("infoTarea", tarea);
        request.setAttribute("usuariosAsignados", userTarea);
        
        String jspEditar = "asignar.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
        
        
        
        
        
        

    }

    public void insertarTarea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fecha = request.getParameter("fecha");
        String actividad = request.getParameter("actividad");
        String descripcion = request.getParameter("descripcion");
        String estado = request.getParameter("estado");
        int estadoActual = Integer.parseInt(estado);

        Tarea tarea = new Tarea(fecha, actividad, descripcion, estadoActual);

        int rows = new ClienteDao().insertarTarea(tarea);

        this.cargarTareas(request, response);

    }

    public void modificarTarea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fecha = request.getParameter("fecha");
        String actividad = request.getParameter("actividad");
        String descripcion = request.getParameter("descripcion");
        String estado = request.getParameter("estado");
        String idTarea = request.getParameter("idTarea");
        int estadoActual = Integer.parseInt(estado);
        int id = Integer.parseInt(idTarea);

        Tarea tarea = new Tarea(id, fecha, actividad, descripcion, estadoActual);

        int rows = new ClienteDao().modificarTarea(tarea);

        this.cargarTareas(request, response);

    }

    public void cargarTareas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Tarea> tareas = new ClienteDao().listarTareas();
        HttpSession sesion = request.getSession();
        request.setAttribute("tareas", tareas);

        String jspEditar = "tareas.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);

    }

    public void eliminarTarea(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String idTarea = request.getParameter("idTarea");

        int id = Integer.parseInt(idTarea);

        Tarea tarea = new Tarea(id);

        int rows = new ClienteDao().eliminarTarea(tarea);

        this.cargarTareas(request, response);

    }

}
