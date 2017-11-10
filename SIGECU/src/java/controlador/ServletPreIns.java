/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import auxiliares.Convierte;
import dao.Implements.Evento.preInsDAO;
import dao.Interface.Evento.IPreInscripcionDAO;
import dto.IdentificadoresEvento;
import dto.MensajesDTO;
import dto.identiPreIns;
import dto.preInscripcion;
import exception.BusinessException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.Implements.Evento.PreInscripcionService;
import service.Interface.Evento.servPreInscr;

/**
 *
 * @author Anel
 */
@WebServlet({ "/preInscripcion", "/vistas/eventos/preInscripcion" })
public class ServletPreIns extends HttpServlet {
    private String direccionar=null;

    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String accion = request.getParameter("accion");
		String mensaje = null;
		
		
		servPreInscr service = new PreInscripcionService();
		switch (accion) {
                    
            
		
		case "LE":
                    //lista = service.consulPre();
                    DatosPre(service, request, response);
                    break;
			//request.setAttribute("lista", lista);
//			if (lista != null) {
//                        
//                        } else {
//                            mensaje = service.getMensaje();
//                        }
//                            direccionar = "/vistas/preinscripcion/registro.jsp";
//			
//			break;
			
		case "INS":
			preInscripcion prein = new preInscripcion();
            mensaje = verificar(request, prein);
                    System.out.println("Entro aqui");
            if (mensaje == null) {
            	service.alumnosIns(prein);
                mensaje = service.getMensaje();
                
                if (mensaje != null) {
                    request.setAttribute("prein", prein);
                    direccionar = "registro.jsp";
                } else {
                	direccionar = "preInscripcion?accion=LE";
                }
                
            } else {
                request.setAttribute("prein", prein);
                direccionar = "preInscripcion?accion=LE";
            }
			break;
			
		default:
			mensaje = "Accion no reconicida";
			break;
		}
		
		if (mensaje != null) {
			String msg = "<div class=\"col-md-5 col-md-offset-3\" style=\"text-align: center\">";
			msg += "<div class=\"alert alert-danger\">";
			msg += "<button class=\"close\" data-dismiss=\"alert\"><span>&times;</span></button>";
			msg += "<strong>Alerta!!</strong><br/>";
			msg += mensaje;
			msg += "</div></div>";
			request.setAttribute("mensaje", msg);
		}
		
		RequestDispatcher despachador = request.getRequestDispatcher(direccionar);
		despachador.forward(request, response);
				
	}
        
    
        
        
        
       /*Metodo para cargar los datos de los eventos necesarios para hacer el registro
     * de un nuevo evento, los datos cargados son ciudad, pais, instructor, templete
    * promociones*/
    private void DatosPre(servPreInscr preInsService, HttpServletRequest request, HttpServletResponse response) {
        List<identiPreIns> datoPre;
        MensajesDTO msjDTO = new MensajesDTO();
        try {
            datoPre = preInsService.consulPre();
            request.setAttribute("datoPre", datoPre);
            msjDTO.setId("000");
            msjDTO.setMensaje("Exceute OK");
            request.setAttribute("msj", msjDTO);
            //eventoService.crearEvento(evento);
        } catch (BusinessException ex) {
            msjDTO.setId(ex.getIdException());
            msjDTO.setMensaje(ex.getMensaje());
            request.setAttribute("msj", msjDTO);
        }catch(Exception e){
            e.printStackTrace();
            msjDTO.setId("301");
            msjDTO.setMensaje("Error en la llamada a recursos");
            request.setAttribute("msj", msjDTO);
        }
        finally{
            direccionar = "registro.jsp";
        }
    }//cargarDatosEvento
    
    
    
    
    
    
    
    
	private String verificar(HttpServletRequest request, preInscripcion prein) {
	        
	        
	        String mensaje = "<ul>";
	//        System.out.println("tamano " + mensaje.length());
	        Integer idpreIns = Convierte.aInteger(request.getParameter("idpre_inscripcion"));
	        String nombre = request.getParameter("nombre");	        
	        String apellido = request.getParameter("apellido");
	        String telefono = request.getParameter("telefono");
                String email = request.getParameter("email");
                String carrera = request.getParameter("carrera");
                String confirmar = request.getParameter("confirmar");
                String empresa = request.getParameter("empresa");
	        
	        if ((nombre == null) || (nombre.trim().length() == 0)) {
	            mensaje += "<li>Verifique que halla ingresado correctamente el nombre</li>";
	        }
	        if ((apellido == null) || (apellido.trim().length() == 0)) {
	            mensaje += "<li>Verifique que halla ingresado correctamente el apellido</li>";
	        }
	        if ((telefono == null) || (telefono.trim().length() == 0)) {
	            mensaje += "<li>Verifique que halla ingresado correctamente el telefono</li>";
	        }
	        if ((email == null) || (email.trim().length() == 0)) {
	            mensaje += "<li>Verifique que halla ingresado correctamente el email</li>";
	        }
                if ((carrera == null) || (carrera.trim().length() == 0)) {
	            mensaje += "<li>Verifique que halla ingresado correctamente la carrera</li>";
	        }
                if ((confirmar == null) || (confirmar.trim().length() == 0)) {
	            mensaje += "<li>Verifique que halla ingresado correctamente confirmado</li>";
	        }
                
	        
	        prein.setIdpreIns(idpreIns);
	        prein.setNombre(nombre);
	        prein.setApellido(apellido);
	        prein.setTelefono(telefono);
                prein.setEmail(email);
                prein.setCarrera(carrera);
                prein.setConfirmar(confirmar);
	        prein.setIdEmpresa(Integer.parseInt(empresa));
                
	        if (mensaje.equals("<ul>")) {
	            mensaje = null;
	        } else {
	            mensaje += "</ul>";
	        }
	
	        return mensaje;
	    }

}
