/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Implements.Evento;

import dao.Implements.Evento.EventoDAO;
import dao.Interface.Evento.IEventoDAO;
import dto.Evento;
import exception.BusinessException;
import java.util.ArrayList;
import java.util.List;
import service.Interface.Evento.IServiceEvento;

/**
 *
 * @author rolando
 */
public class ServiceEvento implements IServiceEvento{

    @Override
    public void crearEvento(Evento evento) throws BusinessException {
        try
        {
            IEventoDAO eventoDAO = new EventoDAO();
            eventoDAO.crearEvento(evento);
        }
        catch (BusinessException e)
        {
            throw e;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            BusinessException be = new BusinessException();
            be.setIdException("201");
            be.setMensaje("Error en la capa de negocio, conexion en crear Evento");
        } 
    }

    @Override
    public List<Evento> listarEventoConfirmado() throws BusinessException {
         
        try
        {
            IEventoDAO eventoDAO = new EventoDAO();
            List<Evento> eventosConfirmados = new ArrayList<>();
            eventosConfirmados = eventoDAO.listarEventoCondirmado();         
            return eventosConfirmados; 
        }
        catch (BusinessException e) {
            throw e;
	}
        catch (Exception ex)
        {
            ex.printStackTrace();
            BusinessException be = new BusinessException();
            be.setIdException("201");
            be.setMensaje("Error en la capa de negocio, conexion a listar eventos");
            throw be;
        }
    }

    @Override
    public void actualizarEventoConfirmado(Evento evento) throws BusinessException{
        try
        {
            IEventoDAO eventoDAO = new EventoDAO();
            eventoDAO.actualizarEventoConfirmado(evento);
        }catch(BusinessException e)
        {
            throw e;
        }catch(Exception e)
        {
            e.printStackTrace();
            BusinessException be = new BusinessException();
            be.setIdException("201");
            be.setMensaje("Erroe es  la capa de negocio, conexion a actualizar Evento");
            throw be;
        }
    }

    @Override
    public String cancelarEventoConfirmado(int idEvento) throws BusinessException{
        try
        {
            EventoDAO eventoDAO = new EventoDAO();
            String estado = eventoDAO.cancelarEventoConfirmado(idEvento);
            return estado;
        }catch(BusinessException e)
        {
            throw e;
        }catch(Exception e)
        {
            e.printStackTrace();
            BusinessException be = new BusinessException();
            be.setIdException("201");
            be.setMensaje("Error en la capa de negocio, conecion a cancelar Evento Confirmado");
            throw be;
        }
    }

    @Override
    public Evento detallesEvento(int idEvento) throws BusinessException{
        try
        {
            IEventoDAO eventoDAO = new EventoDAO();
            Evento evento = new Evento();
            evento = eventoDAO.detallesEvento(idEvento);
            
            return evento;
        }catch(BusinessException e)
        {
            throw e;
        }catch(Exception e)
        {
            e.printStackTrace();
            BusinessException be = new BusinessException();
            be.setIdException("201");
            be.setMensaje("Erroe eb la capa de negocio, conexion a detalles de Evento");
            throw be;
            
        }
    }
    
}
