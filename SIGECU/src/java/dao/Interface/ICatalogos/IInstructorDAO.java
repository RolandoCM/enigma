/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interface.Instructor;

import dto.curso;
import dto.instructor;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author alma
 */
public interface IInstructorDAO {
    public void crearInstructor(instructor instructor) throws BusinessException;
    public List<instructor> listarInstructor() throws BusinessException; 
    public void actualizarInstructor(instructor instructor) throws BusinessException;
    public instructor buscarInstructorDAO(int iInstructor) throws BusinessException;
    public String cancelarInstructor(int idInstructor) throws BusinessException; 
}
