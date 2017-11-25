/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Interface.Curso;

import dto.Curso;
import dto.Instructor;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author alma
 */
public interface ICursoService {
    public void crearCurso(Curso curso) throws BusinessException;
    public List<Curso> listarEventoConfirmado() throws BusinessException; 
    public Curso buscarCurso(int idCurso) throws BusinessException;
    public String eliminarCurso(int idcurso) throws BusinessException ; 
    public Curso detallesCurso(int idCurso) throws BusinessException;
    public List<Curso> listarCursos() throws BusinessException;
    public String getMensaje();

    public void crearInstructor(Instructor ins);
    
}
