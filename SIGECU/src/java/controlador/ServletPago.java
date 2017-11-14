/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import extras.Convierte;
import dao.Implements.PreInscripcion.PagoDAO;
import dto.Pago;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.Interface.IPreInscripcion.IPagoService;

/**
 *
 * @author Anayeli Ramírez
 */
 @WebServlet({ "/Pago", "/vistas/eventos/Pago"})    
public class ServletPago extends HttpServlet {
    
  private static final long serialVersionaUID= 1L;
  
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String accion = request.getParameter("accion");
		String mensaje = null;
		String direccionar = null;
                
                PagoDAO service=new PagoDAO();
		
		switch (accion) {
		
		case "QRY":
			List<Pago> lista = service.listarPagoPendienteE();
			
			if (lista != null) {
                request.setAttribute("lista", lista);
            } else {
                mensaje = service.getMensaje();
            }
            direccionar = "pago.jsp";
			
			break;
			
		case "INS":
                    Pago realizarPago=new Pago();
                    mensaje= verificar (request, realizarPago);
                    System.out.println("Entro aqui");
                     if (mensaje == null) {
                        service.registrarPago(realizarPago);
                          mensaje = service.getMensaje();
                                         
                if (mensaje != null) {
                    request.setAttribute("realizarPago", realizarPago);
                    direccionar = "pago.jsp";
                } else {
                	direccionar = "Pago?accion=QRY";
                }
                
            } else {
                request.setAttribute("realizarPago", realizarPago);
                direccionar = "pago.jsp";
            }
			break;
			
		default:
			mensaje = "Actividad reconocida";
			
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
	
	private String verificar(HttpServletRequest request, Pago pagos) {
	        
	        
	        String mensaje = "<ul>";
	
                Integer idPago=Convierte.aInteger(request.getParameter("idpagos"));
                Integer f_idfactura=Convierte.aInteger(request.getParameter("f_idfactura"));
                String tipo=request.getParameter("tipo");
                Integer status=Convierte.aInteger(request.getParameter("status"));
                String confirmar = "si";
	        
               if((tipo== null)|| (tipo.trim().length()==0)){
                   mensaje +="<li> Verifique que halla ingresado correctamente la fecha</li>";
               }
              
                if ((confirmar == null) || (confirmar.trim().length() == 0)) {
	            mensaje += "<li>Verifique que halla ingresado correctamente </li>";
	        }
                
                pagos.setIdPago(idPago);
                pagos.setF_idPago(f_idfactura);
                pagos.setTipo(tipo);
                pagos.setStatus(status);
	        pagos.setConfirmar(confirmar);
                
	        
	        if (mensaje.equals("<ul>")) {
	            mensaje = null;
	        } else {
	            mensaje += "</ul>";
	        }
	
	        return mensaje;
	    }

                     }
