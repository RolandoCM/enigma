/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dto.MensajesDTO;
import dto.Pago;
import dto.PreInscripcionEvento;
import exception.BusinessException;
import extras.Convierte;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.Implements.PagoPreInscripcion.PagoService;
import service.Implements.PreInscripcion.PreInscripcionService;
import service.Interface.IPreInscripcion.IPreInscripcionService;
import service.Interface.PagoPreInscripcion.IPagoService;

/**
 *
 * @author zoro
 */
@WebServlet(name = "ServletPagoEvento", urlPatterns = {"/ServletPagoEvento"})
public class ServletPagoEvento extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
         MensajesDTO msjDTO = new MensajesDTO();
        try
        {
            PreInscripcionEvento preInscripcion = new PreInscripcionEvento();
            
            preInscripcion.setIdEvento(request.getParameter("idEvento"));
            preInscripcion.setUsuario(request.getParameter("nombreUsuario"));
            preInscripcion.setNombreEvento(request.getParameter("nombreEvento"));
            preInscripcion.setConfirmadoPago("0");
            preInscripcion.setActivoInscrito("1");
            
            Pago pago= new Pago();
            pago.setFormaPago(request.getParameter("formaPago"));
           // pago.setMonto(Convierte.aDouble(request.getParameter("montoEvento")));
            

            IPreInscripcionService preInscribir = new PreInscripcionService();
            boolean preInscripcionConfirmada =preInscribir.registroPreInscripcion(preInscripcion);
            
            if(preInscripcionConfirmada)
            {
                IPagoService pagoPreInscripcion = new PagoService();
            }
             
        } catch (BusinessException ex) {
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
            RequestDispatcher dp = request.getRequestDispatcher("vistas/alumno/pago.jsp");
            dp.forward(request, response);
        }
        
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
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
