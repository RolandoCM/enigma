/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dto.Evento;
import dto.IdentificadoresEvento;
import dto.Instructor;
import dto.MensajesDTO;
import exception.BusinessException;
import extras.Convierte;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet({ "/Eventos", "/vistas/eventos/Eventos" })
public class ServletEvento extends HttpServlet{
    private String direccionar = null;
    @Override
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
                    cargarDatosEvento(evento, request, response);
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
                case "LEW":
                    listarEventosWeb(evento,request, response);
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
        MensajesDTO msjDTO = new MensajesDTO();
        try {
            List<Evento> listaEventos = evento.listarEventoConfirmado();
            request.setAttribute("listaEvento", listaEventos); 
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
            direccionar = "listarEventosConfirmados.jsp";
        }
    }
    private void cargarDatosEvento(IServiceEvento eventoService, HttpServletRequest request, HttpServletResponse response) {
        List<List<IdentificadoresEvento>> datosParaEvento;
        MensajesDTO msjDTO = new MensajesDTO();
        try {
            datosParaEvento = eventoService.consultaDatosCrearEvento();
            request.setAttribute("datosParaEvento", datosParaEvento);
            msjDTO.setId("000");
            msjDTO.setMensaje("Exceute OK");
            request.setAttribute("mensaje", msjDTO);
            //eventoService.crearEvento(evento);
        } catch (BusinessException ex) {
            msjDTO.setId(ex.getIdException());
            msjDTO.setMensaje(ex.getMensaje());
            request.setAttribute("mensaje", msjDTO);
        }catch(Exception e){
            e.printStackTrace();
            msjDTO.setId("301");
            msjDTO.setMensaje("Error en la llamada a recursos");
            request.setAttribute("mensaje", msjDTO);
        }
        finally{
            direccionar = "crearEvento.jsp";
        }
    }
    private void crearEvento(IServiceEvento eventoService, HttpServletRequest request, HttpServletResponse response)  {
        MensajesDTO msjDTO = new MensajesDTO();
        try {
            Evento evento = new Evento();
            Instructor instructor = new Instructor();
            String mensaje= verificar(request, evento);
            if(mensaje==null)
            {
                msjDTO.setId("000");
            msjDTO.setMensaje("Exceute OK");
            request.setAttribute("mensajeCrear", msjDTO);
//            request.setAttribute("mensajeDebug", request.getParameter("nombreEvento")+ " "+ request.getParameter("fechaEvento")+
//                    " "+request.getParameter("descripcionEvento")+" "+request.getParameter("programaEvento")+
//                    " "+request.getParameter("lugarEvento")+
//                    " "+request.getParameter("instructorEvento")+" "+request.getParameter("ciudadEvento")+
//                    " "+request.getParameter("capacidadEvento")+" "+request.getParameter("tipoEvento")+
//                    " "+request.getParameter("statusEvento")+ " "+request.getParameter("costoEvento")+
//                    " "+request.getParameter("templateEvento")+" "+request.getParameter("promocionEvento"));
            int capacidadEvento = Convierte.aInteger(request.getParameter("capacidadEvento"));
            double costoEvento = Convierte.aDouble(request.getParameter("costoEvento"));

            
            evento.setNombre(request.getParameter("nombreEvento"));
            evento.setFecha(request.getParameter("fechaEvento"));
            evento.setDescripcion(request.getParameter("descripcionEvento"));
            evento.setPrograma(request.getParameter("programaEvento"));
            
            instructor.setId(request.getParameter("instructorEvento"));
            evento.setInstructor(instructor);
            
            evento.setLugar(request.getParameter("lugarEvento"));
            evento.setCiudad(request.getParameter("ciudadEvento"));
            evento.setCapacidad(capacidadEvento);
            evento.setTipo(request.getParameter("tipoEvento"));
            evento.setStatus(request.getParameter("statusEvento"));
            evento.setCosto(costoEvento);
            evento.setTemplete(request.getParameter("templateEvento"));
            evento.setPromocion(request.getParameter("promocionEvento"));
            eventoService.crearEvento(evento);
            }
            else
            {
                request.setAttribute("eventoService", eventoService);
            }
            
        } catch (BusinessException ex) {
            msjDTO.setId(ex.getIdException());
            msjDTO.setMensaje(ex.getMensaje());
            request.setAttribute("mensajeCrear", msjDTO);
        }catch(Exception e){
            e.printStackTrace();
            msjDTO.setId("301");
            msjDTO.setMensaje("Error en la llamada a recursos");
            request.setAttribute("mensajeCrear", msjDTO);
        }
        finally{
            direccionar = "crearEvento.jsp";
        }
        
    }

    private void actualizarEventoConfirmado(IServiceEvento eventoService, HttpServletRequest request, HttpServletResponse response) {
        Integer id = Convierte.aInteger(request.getParameter("idEvento"));
        List<Evento> evento = new ArrayList<>();
        
        if(id!=null)
        {
            request.setAttribute("msj", request.getParameter("idEvento"));
            //evento = eventoService.actualizarEventoConfirmado();
        }
        else
        {
            
        }
        direccionar = "listarEvento.jsp";
    }

    private void cancelarEventoConfirmado(IServiceEvento eventoService, HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void detallesEvento(IServiceEvento eventoService, HttpServletRequest request, HttpServletResponse response)  {
        MensajesDTO msjDTO = new MensajesDTO();
        try
        {
            int idEvento= Integer.parseInt(request.getParameter("id"));
            Evento evento = eventoService.detallesEvento(idEvento);
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
        }finally
        {
            direccionar = "detallesEvento.jsp";
        }
    }
    private String verificar(HttpServletRequest request, Evento evento)
    {
        String mensaje=".";
        String nombre = request.getParameter("nombreEvento");
        
        if(nombre==null ||nombre.length() ==0)
            mensaje = "verifique el nombre es correcto";
        
        if(mensaje.equals("."))
            mensaje = null;
        else
            mensaje=".";
        return mensaje;
    }

    private void listarEventosWeb(IServiceEvento evento, HttpServletRequest request, HttpServletResponse response) {
//        try
//        {
//            
//        }catch(BusinessException ex)
//        {
//            
//        }
    }
    
}
