/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interface.IAlumnosDAO;

import dto.Curso;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author zoro
 */
public interface IAlumnosDAO {
    public List<Curso> listarCursosAlumno(int idAlumno) throws BusinessException;
    public int buscarAlumno(String alumno) throws BusinessException;
}
