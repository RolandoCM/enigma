/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import extras.Convierte;
import dao.Implements.Pago.PagoDAO;
import dto.Cheque;
import dto.MensajesDTO;
import dto.Pago;
import dto.Tarjeta;
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
import service.Implements.Pago.PagoService;
import service.Interface.Pago.IPagoService;


/**
 *
 * @author Anayeli Ramírez
 */
<<<<<<< HEAD
@WebServlet({ "/Pagos", "/vistas/eventos/Pagos" })  
=======
 @WebServlet({ "/Pago", "/vistas/comercial/Pago"})    
>>>>>>> 9c515f436935e5b14578083a1b90d37b70971d67
public class ServletPago extends HttpServlet {
    
    private String direccionar = null;
    @Override
    protected void service (HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException
    {
        try {
            String accion = request.getParameter("accion");
            
            IPagoService pago=new  PagoService();
           switch(accion){
               //registrar un pago
               case "RP":
               registrarPago(pago, request, response);
               break;
               case "HP":
               historialPagosR(pago, request, response);
               break;
               case "TC":
               tarjetaCredito(pago, request, response); 
               break;
               case"CK":
                cheque(pago, request, response);
                break;
           }
                        
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher despachador = request.getRequestDispatcher(direccionar);
            despachador.forward(request, response);
           
    } 
    private void historialPagosR(IPagoService pago, HttpServletRequest request, HttpServletResponse response){
        MensajesDTO msj=new MensajesDTO();
        try{
            List<Pago> historial= pago.historialPagos();
            request.setAttribute("historialPago", historial);
            msj.setId("0");
            msj.setMensaje("Ejecucion correcta");
            request.setAttribute("msj", msj);           
            
        }catch (BusinessException ex){
            msj.setId(ex.getIdException());
            msj.setMensaje(ex.getMensaje());
            request.setAttribute("msj", msj);
        }catch(Exception e){
            e.printStackTrace();
            msj.setId("1");
            msj.setMensaje("Error en la llamada de recursos");
            request.setAttribute("msj", msj);
        }
        finally{
            direccionar = "listadoPagos.jsp";
        }
    }
    
    private void registrarPago(IPagoService pagoService, HttpServletRequest request, HttpServletResponse response){
        MensajesDTO msj= new MensajesDTO();
        try{
            Pago pago=new Pago();
            String mensaje= verificar(request, pago);
            if(mensaje==null){
                int monto=Convierte.aInteger(request.getParameter("monto"));
                int f_idFactura=Convierte.aInteger(request.getParameter("f_idfactura"));
                int status=Convierte.aInteger(request.getParameter("status"));
                pago.setFechaPago(request.getParameter("fechaPago"));
                pago.setFormaPago(request.getParameter("formaPago"));
                pago.setTipo(request.getParameter("tipo"));
                pago.setMonto(monto);
                pago.setF_idPago(f_idFactura);
                pago.setStatus(status);
                
                pagoService.insertarPago(pago);
               
            }else{
              request.setAttribute("pagoService", pagoService);
        }
    } catch (BusinessException ex) {
            msj.setId(ex.getIdException());
            msj.setMensaje(ex.getMensaje());
            request.setAttribute("msj", msj);
            
        }catch(Exception e){
            e.printStackTrace();
            msj.setId("1");
            msj.setMensaje("Error");
            request.setAttribute("mensajeCrear", msj);
        }
        finally{
            direccionar = "pago.jsp";
        }   
    
    }
      private void tarjetaCredito(IPagoService pagoService, HttpServletRequest request, HttpServletResponse response){
        MensajesDTO msj= new MensajesDTO();
        try{
            
         Tarjeta tarjeta=new Tarjeta();
            Pago pago=new Pago();
            String mensaje= verificar(request, pago);
            if(mensaje==null){
            int numeroTarjeta=Convierte.aInteger(request.getParameter("numero_tarjeta"));
            tarjeta.setNumeroTarjeta(numeroTarjeta);
            tarjeta.setTitularTarjeta(request.getParameter("titularTarjeta"));
            tarjeta.setFechaExpiracion(request.getParameter("fecha_expiracion"));
            int codigo=Convierte.aInteger(request.getParameter("codigo_seguridad"));
            tarjeta.setCodigo(codigo);
            pagoService.tarjetaCredito(tarjeta);
               
            }else{
              request.setAttribute("pagoService", pagoService);
        }
    } catch (BusinessException ex) {
            msj.setId(ex.getIdException());
            msj.setMensaje(ex.getMensaje());
            request.setAttribute("msj", msj);
            
        }catch(Exception e){
            e.printStackTrace();
            msj.setId("1");
            msj.setMensaje("Error");
            request.setAttribute("mensajeCrear", msj);
        }
        finally{
            direccionar = "pago.jsp";
        } 
      }
       private void cheque(IPagoService pagoService, HttpServletRequest request, HttpServletResponse response){
        MensajesDTO msj= new MensajesDTO();
        try{
            Cheque cheque=new Cheque();        
            Pago pago=new Pago();
            String mensaje= verificar(request, pago);
            if(mensaje==null){
            int numeroSeguridad=Convierte.aInteger(request.getParameter("numero_seguridad"));
            cheque.setNumeroSeguridad(numeroSeguridad);
            int cantidad=Convierte.aInteger(request.getParameter("cantidad"));
            cheque.setCantidad(cantidad);
           pagoService.cheque(cheque);
               
            }else{
              request.setAttribute("pagoService", pagoService);
        }
    } catch (BusinessException ex) {
            msj.setId(ex.getIdException());
            msj.setMensaje(ex.getMensaje());
            request.setAttribute("msj", msj);
            
        }catch(Exception e){
            e.printStackTrace();
            msj.setId("1");
            msj.setMensaje("Error");
            request.setAttribute("mensajeCrear", msj);
        }
        finally{
            direccionar = "pago.jsp";
        } 
      }
     private String verificar(HttpServletRequest request, Pago pago)
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
}
