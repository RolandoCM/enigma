/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interface.Instructor;

import dto.instructor;
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
    public List<instructor> dashInstructorDAO() throws BusinessException;
}
