/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Implements.PagoPreInscripcion;

import service.Implements.Evento.*;
import dao.Implements.Evento.EventoDAO;
import dao.Implements.PagoPreIncripcion.PagoDAO;
import dao.Interface.Evento.IEventoDAO;
import dao.Interface.PagoPreInscripcion.IPagoDAO;
import dto.Cheque;
import dto.Evento;
import dto.IdentificadoresEvento;
import dto.Pago;
import dto.Tarjeta;
import exception.BusinessException;
import java.util.ArrayList;
import java.util.List;
import service.Interface.PagoPreInscripcion.IPagoService;

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
    public List<Pago> mostrarDatos() throws BusinessException {
        try{
            IPagoDAO pagoDAO=new PagoDAO();
            List<Pago> mostrarDatos=new ArrayList<>();
            mostrarDatos=pagoDAO.mostrarDatos();
            return mostrarDatos;
        }
        catch(Exception ex){
            ex.printStackTrace();
            BusinessException be=new BusinessException();
            be.setIdException("2");
            be.setMensaje("Error al listar los datos");
            throw be;
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
    public void tarjetaCredito(Tarjeta tarjeta) throws BusinessException {
         try{
            IPagoDAO pagoDAO= new PagoDAO();
            pagoDAO.tarjetaCredito(tarjeta);
        }catch(Exception ex){
            
            ex.printStackTrace();
            BusinessException mens=new BusinessException();
            mens.setIdException("1");
            mens.setMensaje("Error al registrar el pago");
            throw mens;
        }
    }

    @Override
    public void cheque(Cheque cheque) throws BusinessException {
         try{
            IPagoDAO pagoDAO= new PagoDAO();
            pagoDAO.cheque(cheque);
        }catch(Exception ex){
            
            ex.printStackTrace();
            BusinessException mens=new BusinessException();
            mens.setIdException("1");
            mens.setMensaje("Error al registrar el pago");
            throw mens;
        }
    }

}
