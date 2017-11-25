/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Interface.ICatalogosService;

import dto.instructor;
import exception.BusinessException;


public interface ICrearInstructorService {
    public void nuevoInstructor(instructor instructor) throws BusinessException;
}
