/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Interface.Curso;

import dto.curso;
import dto.instructor;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author alma
 */
public interface ICursoService {
    public void crearCurso(curso curso) throws BusinessException;
    public List<curso> listarEventoConfirmado() throws BusinessException; 
    public curso buscarCurso(int idCurso) throws BusinessException;
    public String eliminarCurso(int idcurso) throws BusinessException ; 
    public curso detallesCurso(int idCurso) throws BusinessException;
    public List<curso> listarCursos() throws BusinessException;
    public String getMensaje();

    public void crearInstructor(instructor ins);
    
}
