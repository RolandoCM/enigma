/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interface.IInstructor;

import dto.Instructor;
import exception.BusinessException;

/**
 *
 * @author JorgeLuna
 */
public interface IInstructorDAO {
    public void nuevoInstructor(Instructor instructor) throws BusinessException;
    
}
