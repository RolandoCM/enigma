/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Implements.Instructor;

import dto.curso;
import dto.instructor;
import exception.BusinessException;
import java.util.List;
import service.Interface.Curso.ICursoService;
import service.Interface.Instructor.IInstructorService;

/**
 *
 * @author alma
 */
public class InstructorDashService implements IInstructorService{

    @Override
    public void crearInstructor(instructor instructor) throws BusinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<instructor> listarInstructor() throws BusinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public curso buscarInstructor(int idinstructor) throws BusinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminarInstructor(int idinstructor) throws BusinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMensaje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
