/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dto.Evento;
import dto.MensajesDTO;
import dto.Pago;
import exception.BusinessException;
import extras.Convierte;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.Implements.PagoPreInscripcion.PagoService;
import service.Interface.PagoPreInscripcion.IPagoService;

/**
 *
 * @author zoro
 */
@WebServlet(name = "ServletSeguimientoPagos", urlPatterns = {"/vistas/comercial/ServletSeguimientoPagos"})
public class ServletSeguimientoPagos extends HttpServlet {
    private String direccionar ="";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        IPagoService pagos = new PagoService();
        try
        {
            switch(accion)
            {
                case "BE":
                    buscarEvento(pagos, request, response);
                    break;
                case "LE":
                    listarPagosPendientes(pagos, request, response);
                    break;
                case "CE":
                    confirmarPago(pagos, request, response);
                    break;
                default:
                    break;
            }
            
        }catch(Exception e){
            
        }finally
        {
            RequestDispatcher dp = request.getRequestDispatcher(direccionar);
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

    private void buscarEvento(IPagoService pagos, HttpServletRequest request, HttpServletResponse response) {
       MensajesDTO msjDTO = new MensajesDTO();
       try
        {
            List<Evento> eventos = pagos.cargarEvento();
            request.setAttribute("eventos", eventos);
            int idEvento = Convierte.aInteger(request.getParameter("idEvento"));
            List<Pago> seguirPagos = pagos.seguimientoPagos(idEvento);
            request.setAttribute("pagos", seguirPagos);
            
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
        }
       finally{
           direccionar="seguimientoPagos.jsp";
       }
    }

    private void confirmarPago(IPagoService pagos, HttpServletRequest request, HttpServletResponse response) {
        MensajesDTO msjDTO = new MensajesDTO();
       try
        {
            int idHistorial = Convierte.aInteger(request.getParameter("idHistorial"));
            int idUsuario = Convierte.aInteger(request.getParameter("idUsuario"));
            pagos.confirmarPagos(idHistorial, idUsuario);
            //request.setAttribute();
            
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
        }
       finally{
           direccionar="ServletSeguimientoPagos?accion=LE";
       }
    }

    private void listarPagosPendientes(IPagoService pagos, HttpServletRequest request, HttpServletResponse response) {
       MensajesDTO msjDTO = new MensajesDTO();
       try
        {
            List<Evento> eventos = pagos.cargarEvento();
            List<Pago> seguirPagos = pagos.seguimientoPagos();
            request.setAttribute("pagos", seguirPagos);
            request.setAttribute("eventos", eventos);
            
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
        }
       finally{
           direccionar="seguimientoPagos.jsp";
       }
    }
    

}
