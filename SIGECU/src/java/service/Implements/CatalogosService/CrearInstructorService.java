/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Implements.CatalogosService;

import dao.Implements.CatalogosDAO.CrearInstructorDAO;
import dao.Interface.ICatalogos.ICrearInstructorDAO;
import dto.Instructor;
import exception.BusinessException;
import service.Interface.ICatalogosService.ICrearInstructorService;

/**
 *
 * @author zoro
 */
public class CrearInstructorService implements ICrearInstructorService{

    @Override
    public void nuevoInstructor(Instructor instructor) throws BusinessException {
        try
        {
            ICrearInstructorDAO nuevoInstructor = new CrearInstructorDAO();
            
            nuevoInstructor.nuevoInstructor(instructor);
            
        }catch (BusinessException e)
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
