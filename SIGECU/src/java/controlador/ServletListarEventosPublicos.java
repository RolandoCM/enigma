/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dto.Evento;
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
import service.Implements.Evento.EventoService;
import service.Interface.Evento.IEventoService;

/**
 *
 * @author zoro
 */
@WebServlet(name = "/ServletListarEventosPublicos", urlPatterns = {"/ServletListarEventosPublicos"})
public class ServletListarEventosPublicos extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            listarEventosPublicos(request, response);
        }catch(Exception e)
        {
            
        }
        finally
        {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/vistas/publico/listarEventosPublicos.jsp");
            rd.forward(request, response);
        }
    }
    //Metodo para listar eventos para el Interesado
    private void listarEventosPublicos(HttpServletRequest request, HttpServletResponse response) {
        
        MensajesDTO msjDTO = new MensajesDTO();
        try
        {
            IEventoService evento = new EventoService();
            List<Evento> listarPublicos = evento.listarEventosPublicos();
            request.setAttribute("listarPublicos", listarPublicos);
            //msjDTO.setId("000");
            //msjDTO.setMensaje("Ejecuxion Ok");
            request.setAttribute("msj", msjDTO);
            
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
    }

}
