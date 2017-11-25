/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Interface.Instructor;

import service.Interface.Curso.*;
import dto.Curso;
import dto.Instructor;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author alma
 */
public interface IInstructorService {
    public void crearInstructor(Instructor instructor) throws BusinessException;
    public List<Instructor> listarInstructor() throws BusinessException; 
    public Curso buscarInstructor(int idinstructor) throws BusinessException;
    public String eliminarInstructor(int idinstructor) throws BusinessException;
    public String getMensaje();

    
}
