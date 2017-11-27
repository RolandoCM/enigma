package service.Implements.Instructor;


import dao.Implements.Instructor.CrearInstructorDAO;
import dao.Interface.IInstructor.IInstructorDAO;
import dto.Instructor;
import exception.BusinessException;
import service.Interface.Instructor.IInstructorServiceb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JorgeLuna
 */
public class InstructorService implements IInstructorServiceb{
    
   
    @Override
    public void nuevoInstructor(Instructor instructor) throws BusinessException {
 try
        {
            IInstructorDAO instruDAO = new CrearInstructorDAO();
            instruDAO.nuevoInstructor(instructor);
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
        }     }
}
