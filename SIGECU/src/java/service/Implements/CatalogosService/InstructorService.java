/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service.Implements.CatalogosService;
import dao.Implements.CatalogosDAO.InstructorDAO;
import dao.Interface.ICatalogos.IInstructorDAO;
import dto.Especialidad;
import dto.Instructor;
import exception.BusinessException;
import java.util.List;
import service.Interface.ICatalogosService.IInstructorService;

/**
 *
 * @author alma
 */
public class InstructorService implements IInstructorService{

    @Override
    public void crearInstructor(Instructor instructor) throws BusinessException {
        try
        {
            IInstructorDAO instructorDAO = new InstructorDAO();
            instructorDAO.crearInstructor(instructor);
        }catch(BusinessException e){
            throw e;
        }
        catch(Exception e){
            BusinessException be = new BusinessException();
            be.setIdException("2001");
            be.setMensaje("Error en la capa de negocio");
            throw be;
        }
        
    }

    @Override
    public List<Instructor> listarInstructor() throws BusinessException {
        
        try
        {
            IInstructorDAO instructorDAO = new InstructorDAO();
            List<Instructor> instructor = instructorDAO.listarInstructor();
            return instructor;
        }catch(BusinessException e){
            throw e;
        }
        catch(Exception e){
            BusinessException be = new BusinessException();
            be.setIdException("2001");
            be.setMensaje("Error en la capa de negocio");
            throw be;
        }
    }

    @Override
    public List<Especialidad> buscarEspecialidad() throws BusinessException {
        try
        {
            IInstructorDAO instructorDAO = new InstructorDAO();
            List<Especialidad> especialidad= instructorDAO.buscarEspecialidad();
            return especialidad;
        }catch(BusinessException e){
            throw e;
        }
        catch(Exception e){
            BusinessException be = new BusinessException();
            be.setIdException("2001");
            be.setMensaje("Error en la capa de negocio");
            throw be;
        }
    }
    
}
