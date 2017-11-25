/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interface.ICatalogos;

import dto.instructor;
import exception.BusinessException;

/**
 *
 * @author zoro
 */
public interface ICrearInstructorDAO {
    
    public void nuevoInstructor(instructor instructor) throws BusinessException;
    
}
