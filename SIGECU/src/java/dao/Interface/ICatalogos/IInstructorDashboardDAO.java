/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interface.Instructor;

import dto.Instructor;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author alma
 */
public interface IInstructorDashboardDAO {

    /**
     *
     * @return
     * @throws BusinessException
     */
    public List<Instructor> dashInstructorDAO() throws BusinessException;
}
