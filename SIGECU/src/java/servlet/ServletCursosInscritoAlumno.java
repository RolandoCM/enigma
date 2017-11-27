/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dto.Curso;
import dto.MensajesDTO;
import exception.BusinessException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.Implements.AlumnosService.AlumnosService;
import service.Interface.IAlumnosService.IAlumnosService;

/**
 *
 * @author zoro
 */
@WebServlet(name = "ServletCursosInscritoAlumno", urlPatterns = {"/vistas/alumno/ServletCursosInscritoAlumno"})
public class ServletCursosInscritoAlumno extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MensajesDTO msjDTO = new MensajesDTO();
        response.setContentType("text/html;charset=UTF-8");
        try
        {
            IAlumnosService alumnosCursos = new AlumnosService();
            List<Curso> cursos= alumnosCursos.listarCursosAlumno(request.getParameter("alumno"));
            msjDTO.setMensaje(request.getParameter("alumno"));
            //request.setAttribute("msj", msjDTO);
            request.setAttribute("cursos", cursos);
        }catch (BusinessException ex) {
            msjDTO.setId(ex.getIdException());
            msjDTO.setMensaje(ex.getMensaje());
            request.setAttribute("msj", msjDTO);
        }catch(Exception e)
        {
            e.printStackTrace();
            msjDTO.setId("301");
            msjDTO.setMensaje("Error en la llamada de recursos");
            request.setAttribute("msj", msjDTO);
        }finally
        {
            RequestDispatcher dp = request.getRequestDispatcher("misCursosActivo.jsp");
            dp.forward(request, response);
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
