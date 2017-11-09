/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Implements;

import dao.Implements.PreInscripcionDAO;
import dao.Interface.IPreInscripcionDAO;
import dto.Evento;
import exception.BusinessException;
import java.util.List;
import service.Interface.IServicePreInscripcion;

/**
 *
 * @author jose-
 */
public class ServicePreInscripcion implements IServicePreInscripcion  {

    @Override
    public List<Evento> dashEvento() throws BusinessException {
        try
        {
            IPreInscripcionDAO preInscripcion = new PreInscripcionDAO();
            List<Evento> evento = preInscripcion.dashEventoDAO();
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
