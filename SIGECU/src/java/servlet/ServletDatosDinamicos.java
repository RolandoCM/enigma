/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dto.Ciudad;
import dto.Lugar;
import dto.MensajesDTO;
import exception.BusinessException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.Implements.Evento.EventoService;
import service.Interface.Evento.IEventoService;

/**
 *
 * @author Memo
 */
@WebServlet({"/DatosDinamicos", "/vistas/comercial/DatosDinamicos"})
public class ServletDatosDinamicos extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        IEventoService eventoService = new EventoService();
        String accion = request.getParameter("accion");
        switch(accion)
        {
            case "CC":
                cargarCiudad(eventoService, request, response);
                break;
            case "CL":
                cargarLugar(eventoService, request, response);
                break;
            default:
                
                break;
        }
        
        
    }

    private String cargarCiudad (IEventoService eventoService, HttpServletRequest request, HttpServletResponse response) throws IOException  {
        MensajesDTO msjDTO = new MensajesDTO();
        String ciudadPorPais ="";
        try
        {
            int idPais= Integer.parseInt(request.getParameter("id"));
            List<Ciudad> listaCiudad = eventoService.cargarCiudades(idPais);
                        
                ciudadPorPais+="<option selected= disabled value=''> <-- Seleccionar una Ciudad --> </option>";
                        
            for (Ciudad ciudad : listaCiudad)
            {
                ciudadPorPais+="<option id='" + ciudad.getIdCiudad()+ "' value='" +ciudad.getIdCiudad()+ "'> "+ciudad.getNombreCiudad()+"</option>";
            }
            
            request.setAttribute("ciudades", ciudadPorPais);
            
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(ciudadPorPais);
            
        } catch (BusinessException ex) {
            msjDTO.setId(ex.getIdException());
            msjDTO.setMensaje(ex.getMensaje());
            request.setAttribute("msj", msjDTO);
        }catch(NumberFormatException e)
        {
            e.printStackTrace();
            msjDTO.setId("301");
            msjDTO.setMensaje("Error en la llamada de recursos");
            request.setAttribute("msj", msjDTO);
        }
        return ciudadPorPais;
        
    }//
    
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

    private String cargarLugar(IEventoService eventoService, HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        MensajesDTO msjDTO = new MensajesDTO();
        String lugarPorCiudad ="";
        try
        {
            int idCiudad= Integer.parseInt(request.getParameter("id"));
            List<Lugar> listaLugar = eventoService.cargarLugares(idCiudad);
                        
                lugarPorCiudad+="<option selected= disabled value=''> <-- Seleccionar un Lugar --> </option>";
                        
            for (Lugar lugar : listaLugar)
            {
                lugarPorCiudad+="<option id='" + lugar.getIdLugar()+ "' value='" +lugar.getIdLugar()+ "'> "+lugar.getNombreLugar()+"</option>";
            }
            
            request.setAttribute("lugares", lugarPorCiudad);
            
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(lugarPorCiudad);
            
        } catch (BusinessException ex) {
            msjDTO.setId(ex.getIdException());
            msjDTO.setMensaje(ex.getMensaje());
            request.setAttribute("msj", msjDTO);
        }catch(NumberFormatException e)
        {
            e.printStackTrace();
            msjDTO.setId("301");
            msjDTO.setMensaje("Error en la llamada de recursos");
            request.setAttribute("msj", msjDTO);
        }
        return lugarPorCiudad;
        
    }//

}
