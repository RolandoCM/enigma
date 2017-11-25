/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interface.Curso;

import dao.Interface.Evento.*;
import dto.Evento;
import dto.Curso;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author alma
 */
public interface ICursoDashboardDAO {

    /**
     *
     * @return
     * @throws BusinessException
     */
    public List<Curso> dashCursoDAO() throws BusinessException;
}
