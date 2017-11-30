/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Implements.PagoPreInscripcion;


import dao.Implements.PagoPreIncripcion.PagoDAO;
import dao.Interface.PagoPreInscripcion.IPagoDAO;
import dto.Evento;
import dto.Pago;
import exception.BusinessException;
import java.util.List;
import service.Interface.PagoPreInscripcion.IPagoService;
import service.email.Email;

/**
 *
 * @author Anayeli
 */
public class PagoService implements IPagoService{
    
    
    @Override
    public void registrarPago(Pago pago) throws BusinessException{
        try{
            IPagoDAO pagoDAO= new PagoDAO();
            Pago pagoDatosCompletos;
            /*buscar id del tipo de pago*/
            pagoDatosCompletos =pagoDAO.tipoPago(pago);
            /*buscar id de historial de pagos*/
            pagoDatosCompletos=pagoDAO.buscarIdUsuario(pagoDatosCompletos); //buscar id de usuario
            
            pagoDatosCompletos = pagoDAO.buscarIdHistorialPago(pagoDatosCompletos);
            
            pagoDAO.registrarPago(pagoDatosCompletos);
        }catch(Exception ex){
            
            ex.printStackTrace();
            BusinessException mens=new BusinessException();
            mens.setIdException("1");
            mens.setMensaje("Error al registrar el pago");
            throw mens;
        }
    }
    
    @Override
    public List<Pago> historialPagos( String alumno) throws  BusinessException{
        try{
            IPagoDAO pagoDAO=new PagoDAO();
            List<Pago> historialDePagos;
            Pago pagoAlumno =new Pago();
            pagoAlumno.setQuienPago(alumno);
            Pago pagosAlumno = pagoDAO.buscarIdUsuario(pagoAlumno);
            
            historialDePagos=pagoDAO.historialPagos(pagosAlumno.getIdUsuario());
            
            return historialDePagos;
        }catch(BusinessException e)
        {
            throw e;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            BusinessException be = new BusinessException();
            be.setIdException("2");
            be.setMensaje("Error para listar el historial");
            throw be;
        }
    }



    @Override
    public List<Pago> seguimientoPagos(int idEvento) throws BusinessException {
        try{
            IPagoDAO pagoDAO=new PagoDAO();
            List<Pago> seguirPagos;
            seguirPagos = pagoDAO.seguimientoPagos(idEvento);
            return seguirPagos;
        }catch(BusinessException e)
        {
            throw e;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            BusinessException be = new BusinessException();
            be.setIdException("2");
            be.setMensaje("Error para listar el historial");
            throw be;
        }
    }

    @Override
    public void confirmarPagos(int idHistorial, int idUsuario) throws BusinessException {
        try{
            IPagoDAO pagoDAO=new PagoDAO();
             boolean confirmado = pagoDAO.confirmarPago(idHistorial);
             
             if(confirmado==true)
             {
                 String correo = pagoDAO.correo(idUsuario);
                 String body = "<meta charset=\"utf-8\">\n" +
                    "<p>Usted a realizado el pago del curso</p>\n" +
                    "<a href=\"http://localhost:8084/SIGECU/vistas/alumno/listadoPagos.jsp\"><button >Confirmar Resepción</button></a>";
                 Email.send(correo, "Confirmo pago a curso", body, "html");
                 Email.send("sigecu0@gmail.com", "Pago completo", "El alumno x a realizado su pago");
             }
             
        }catch(BusinessException e)
        {
            throw e;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            BusinessException be = new BusinessException();
            be.setIdException("2");
            be.setMensaje("Error para listar el historial");
            throw be;
        }
    }

    @Override
    public List<Evento> cargarEvento() throws BusinessException {
       try{
            IPagoDAO pagoDAO=new PagoDAO();
            List<Evento> eventos;
            eventos = pagoDAO.cargarEvento();
            return eventos;
        }catch(BusinessException e)
        {
            throw e;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            BusinessException be = new BusinessException();
            be.setIdException("2");
            be.setMensaje("Error para listar el historial");
            throw be;
        }
    }

    @Override
    public List<Pago> seguimientoPagos() throws BusinessException {
       try{
            IPagoDAO pagoDAO=new PagoDAO();
            List<Pago> seguirPagos;
            seguirPagos = pagoDAO.seguimientoPagos();
            return seguirPagos;
        }catch(BusinessException e)
        {
            throw e;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            BusinessException be = new BusinessException();
            be.setIdException("2");
            be.setMensaje("Error para listar el historial");
            throw be;
        }
    }

}
