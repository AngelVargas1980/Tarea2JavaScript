/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ServletPackages;

import Clases.Alumno;
import Clases.AlumnoController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/** * @author Angel Vargas */

@WebServlet(name = "MiServlet", urlPatterns = {"/miurl"})
public class MiServlet extends HttpServlet {
    Alumno alumno;
    AlumnoController registroAlumno;
    Alumno[] alumnosRegistrados;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try ( PrintWriter out = response.getWriter()) {
            alumno=new Alumno(
                request.getParameter("codigo"),
                request.getParameter("nombre"),
                request.getParameter("correo"),
                request.getParameter("direccion"),
                request.getParameter("telefono")
            ); 
            
            if(registroAlumno==null){
                 registroAlumno=new AlumnoController();
            }
           
            registroAlumno.guardarAlumno(alumno);//almacenarlo en el array
            alumnosRegistrados= registroAlumno.getAlumnos();
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MiServlet</title>");  
            out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\" integrity=\"sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N\" crossorigin=\"anonymous\">");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct\" crossorigin=\"anonymous\"></script>");
            /*out.println(" style=\"background-color: #AED6F1 \"  ");*/
            out.println("</head>");            
            out.println("<body >");
            out.println("<img src=\"logoMiumg3.png\">");  
            out.println ("<img src=\"cabecera.jpg\">");
            out.println("<div class='container'>");
            out.println("<br><h1 align=\"center\" style=\"color:black\">GRACIAS POR REGISTRARSE!</h1><br>");   
            out.println("<form name='nombreForm'>");
            out.println("<div class='container-lg d-flex'> <a href='index.html' class=\"btn btn-success ml-auto\">Registrar Nuevo</a></div><br>"); /*Boton de regresar a pagina principal*/
            out.println("<table class=\"table table-hover table-striped\">");   
            out.println("<thead><tr> <th scope=\"col\">CODIGO CLIENTE</th> <th scope=\"col\">NOMBRE DEL CLIENTE</th>\n" +
                                "<th scope=\"col\">CORREO DEL CLIENTE</th> <th scope=\"col\">DIRECCION</th>\n" +
                                "<th scope=\"col\">TELEFONO</th> <th scope=\"col\">ACCION</th> </tr></thead>");
                                  
            out.println("<tbody>");
            for (int i = 0; i < alumnosRegistrados.length; i++){
                    if(!alumnosRegistrados[i].getCodigo().isEmpty()){
                       out.println("<tr><td>" + alumnosRegistrados[i].getCodigo()+ "</td>");
                       out.println("<td>" + alumnosRegistrados[i].getNombre() + "</td>");
                       out.println("<td>" + alumnosRegistrados[i].getCorreo()+ "</td>");
                       out.println("<td>" + alumnosRegistrados[i].getDireccion()+ "</td>");
                       out.println("<td>" + alumnosRegistrados[i].getTelefono()+ "</td>");
                       out.println("<td>"
                               + "<button type=\"button\" class=\"btn btn-warning\"></i>Editar</button> "
                               + "<button type=\"button\" class=\"btn btn-danger\"  value=\"Borrar formulario\"   >Eliminar</button>"
                               + "</td></tr>");
                       
                    }
                }
            
                  
            
            out.println("<h1>Servlet MiServlet at " + request.getContextPath() + "</h1>");
            out.println("</tbody></table>");
            out.println("</div>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

