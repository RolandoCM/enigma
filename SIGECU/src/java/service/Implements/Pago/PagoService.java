/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Implements.Pago;

import service.Implements.Evento.*;
import dao.Implements.Evento.EventoDAO;
import dao.Implements.Pago.PagoDAO;
import dao.Interface.Evento.IEventoDAO;
import dao.Interface.Pago.IPagoDAO;
import dto.Cheque;
import dto.Evento;
import dto.IdentificadoresEvento;
import dto.Pago;
import dto.Tarjeta;
import exception.BusinessException;
import java.util.ArrayList;
import java.util.List;
import service.Interface.Pago.IPagoService;

/**
 *
 * @author Anayeli
 */
public class PagoService implements IPagoService{
    
    
    @Override
    public void insertarPago(Pago pago) throws BusinessException{
        try{
            IPagoDAO pagoDAO= new PagoDAO();
            pagoDAO.registrarPago(pago);
        }catch(Exception ex){
            
            ex.printStackTrace();
            BusinessException mens=new BusinessException();
            mens.setIdException("1");
            mens.setMensaje("Error al registrar el pago");
            throw mens;
        }
    }
    
    public List<Pago> historialPagos() throws  BusinessException{
        try{
            IPagoDAO pagoDAO=new PagoDAO();
            List<Pago> historialDePagos=new ArrayList<>();
            historialDePagos=pagoDAO.historialPagosR();
            return historialDePagos;
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
