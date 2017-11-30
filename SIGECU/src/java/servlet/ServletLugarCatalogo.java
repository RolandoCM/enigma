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
import extras.Convierte;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.Implements.CatalogosService.LugarService;
import service.Interface.ICatalogosService.ILugarService;

/**
 *
 * @author zoro
 */
@WebServlet(name = "ServletLugarCatalogo", urlPatterns = {"/vistas/administrador/ServletLugarCatalogo"})
public class ServletLugarCatalogo extends HttpServlet {
    private String direccionar="";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try
        {
            ILugarService lugarService = new LugarService();
            String accion = request.getParameter("accion");
            
            switch(accion)
            {
                case "LL":
                    listarLugar(request, response, lugarService);
                    break;
                case "CL":
                    crearLugar(request, response, lugarService);
                    break;
                case "BC":
                    buscarCiudad(request, response, lugarService);
                    break;
                default:break;
            }
        }catch(Exception e)
        {
            
        }
         RequestDispatcher despachador = request.getRequestDispatcher(direccionar);
            despachador.forward(request, response);
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

    private void listarLugar(HttpServletRequest request, HttpServletResponse response, ILugarService lugarService) {
        MensajesDTO msjDTO = new MensajesDTO();
        try {
            List<Lugar> listaLugar = lugarService.listarLugar();
            request.setAttribute("listaLugar", listaLugar); 
            /*msjDTO.setId("000");
            msjDTO.setMensaje("Ejecuxion OK");
            request.setAttribute("msj", msjDTO);*/
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
        }
        finally{
            direccionar = "ListarLugar.jsp";
        }
    }

    private void crearLugar(HttpServletRequest request, HttpServletResponse response, ILugarService lugarService) {
        MensajesDTO msjDTO = new MensajesDTO();
        try {
            
            Lugar lugar = new Lugar();
            lugar.setNombreLugar(request.getParameter("nombreLugar"));
            lugar.setDescripcionLugar(request.getParameter("descripcionLugar"));
            lugar.setIdCiudad(Convierte.aInteger(request.getParameter("idCiudad")));
            
            lugarService.crearLugar(lugar);
            /*msjDTO.setId("000");
            msjDTO.setMensaje("Ejecuxion OK");
            request.setAttribute("msj", msjDTO);*/
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
        }
        finally{
            direccionar = "ServletLugarCatalogo?accion=LL";
        }
    }

    private void buscarCiudad(HttpServletRequest request, HttpServletResponse response, ILugarService lugarService) {
        MensajesDTO msjDTO = new MensajesDTO();
        try {
            List<Ciudad> listaCiudad = lugarService.buscarCiudad();
            request.setAttribute("listaCiudad", listaCiudad); 
            msjDTO.setId("000");
            msjDTO.setMensaje("Ejecuxion OK");
            request.setAttribute("msj", msjDTO);
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
        }
        finally{
            direccionar = "CrearLugar.jsp";
        }
    }

}
