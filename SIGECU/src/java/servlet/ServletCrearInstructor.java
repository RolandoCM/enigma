/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dto.instructor;
import exception.BusinessException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.Interface.ICatalogosService.ICrearInstructorService;

/**
 *
 * @author zoro
 */
@WebServlet(name = "/ServletCreatInstructor", urlPatterns = {"/ServletCreatInstructor"})
public class ServletCrearInstructor extends HttpServlet {

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
//        try
//        {
//            instructor instructor = new instructor();
//            
//            instructor.setNombre(request.getParameter("nombre"));
//            instructor.setPaterno(request.getParameter("paterno"));
//            instructor.setMaterno(request.getParameter("materno"));
//            instructor.setCarrera(request.getParameter("carrera"));
//            instructor.setEspecialidad(request.getParameter("especialidad"));
//            instructor.setEmail(request.getParameter("email"));
//            instructor.setTelefono(request.getParameter("telefono"));
//            instructor.setDireccion(request.getParameter("direccion"));
//
//        finally
//        {
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/vistas/publico/listarEventosPublicos.jsp");
//            rd.forward(request, response);
//        }
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
        doPost(request, response);
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
