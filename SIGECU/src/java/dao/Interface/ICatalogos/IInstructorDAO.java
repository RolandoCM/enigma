/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interface.ICatalogos;

import dto.Curso;
import dto.Especialidad;
import dto.Instructor;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author alma
 */
public interface IInstructorDAO {
    public void crearInstructor(Instructor instructor) throws BusinessException;
    public List<Instructor> listarInstructor() throws BusinessException; 
    public List<Especialidad> buscarEspecialidad() throws BusinessException;
}
