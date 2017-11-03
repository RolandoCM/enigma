/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dto.Evento;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.Implements.Evento.ServiceEvento;
import service.Interface.Evento.IServiceEvento;

/**
 *
 * @author rolando
 */
@WebServlet({ "/Eventos", "/pages/eventos/Eventos" })
public class ServletEvento extends HttpServlet{
    private String direccionar = null;
    protected void service (HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException
    {
        try {
            String accion = request.getParameter("accion");
            
            
            IServiceEvento evento = new ServiceEvento();
            
            switch(accion)
            {
                // LISTAR EVENTOS CONFIRMADOS
                case "LEC":
                    listarEventosConfirmados(evento, request, response);
                    break;
                    //CREAR EVENTOS 
                case "CE":
                    crearEvento(evento, request, response);
                    break;
                    //ACTUALIZAR EVENTOS
                case "AE":
                    actualizarEventoConfirmado(evento, request, response);
                    break;
                    //CANCELAR EVENTO
                case "CAE":
                    cancelarEventoConfirmado(evento, request, response);
                    break;
                    //DETALLES EVENTO
                case "DE":
                    detallesEvento(evento, request, response);
                    break;
                default:
                    break;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher despachador = request.getRequestDispatcher(direccionar);
            despachador.forward(request, response);
    }
    private void listarEventosConfirmados(IServiceEvento evento, HttpServletRequest request, HttpServletResponse response) 
    {
        List<Evento> listaEventos = evento.listarEventoConfirmado();
 
        request.setAttribute("listaEvento", listaEventos);

        direccionar = "listarEventosConfirmados.jsp";
    }

    private void crearEvento(IServiceEvento eventoService, HttpServletRequest request, HttpServletResponse response)  {
        Evento evento = new Evento();
        
        eventoService.crearEvento(evento);
        
    }

    private void actualizarEventoConfirmado(IServiceEvento eventoService, HttpServletRequest request, HttpServletResponse response) {
        
    }

    private void cancelarEventoConfirmado(IServiceEvento eventoService, HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void detallesEvento(IServiceEvento eventoService, HttpServletRequest request, HttpServletResponse response)  {
        int idEvento= Integer.parseInt(request.getParameter("id"));
        Evento evento = eventoService.detallesEvento(idEvento);

        direccionar = "detallesEvento.jsp";
    }
    private String verificar(HttpServletRequest request, Evento evento)
    {
        String mensaje="";
        
        return mensaje;
    }
}
