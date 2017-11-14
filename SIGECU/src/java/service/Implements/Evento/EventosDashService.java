/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Implements.Evento;

import dao.Implements.Evento.EventosDashboardDAO;
import dao.Interface.Evento.IEventosDashboardDAO;
import dto.Evento;
import exception.BusinessException;
import java.util.List;
import service.Interface.Evento.IPreInscripcionService;

/**
 *
 * @author jose-
 */
public class EventosDashService implements IPreInscripcionService  {

    @Override
    public List<Evento> dashEvento() throws BusinessException {
        try
        {
            IEventosDashboardDAO eventosDash = new EventosDashboardDAO();
            List<Evento> evento = eventosDash.dashEventoDAO();
            return evento;
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
            throw be;
        } 
    }

    
}
