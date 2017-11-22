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
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.Implements.Evento.EventosDashService;
import service.Interface.Evento.IPreInscripcionService;

/**
 *
 * @author jose-
 */
@WebServlet({ "/dashInscripcion", "/vistas/comercial/dashInscripcion"})
public class ServletEventosDash extends HttpServlet {
   private String direccionar = null;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse resp) 
            throws ServletException, IOException {
        try{
            IPreInscripcionService preInscripcion = new EventosDashService();
            String accion = request.getParameter("accion");
            switch(accion){
                //listar evento
                case "RG":
                   buscarEventoDAO(preInscripcion, request, resp);
                   break;
                default:
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        RequestDispatcher despachador = request.getRequestDispatcher(direccionar);
            despachador.forward(request, resp); 
    }
    
    
    private void buscarEventoDAO(IPreInscripcionService evento, HttpServletRequest request, HttpServletResponse response){
        MensajesDTO msjDTO= new MensajesDTO();
        try
        {
            List<Evento> dashEvento = null;
            IPreInscripcionService preInscripcion = new EventosDashService();
            dashEvento = preInscripcion.dashEvento();
            //calcularColor(dashEvento);
            request.setAttribute("dashEvento", dashEvento);
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
        finally
        {
            direccionar="graficaCursos.jsp";
        }    
    }
    
    private String[] calcularColor(String fechaInicion, String fechaTermino)
    {
        String array[] = new String [2];
        
        return null;
    }
  
   
}
