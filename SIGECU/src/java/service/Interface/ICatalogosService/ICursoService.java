/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Interface.ICatalogosService;

import dto.Curso;
import dto.Especialidad;
import dto.Instructor;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author alma
 */
public interface ICursoService {
    public void crearCurso(Curso curso) throws BusinessException;
    public List<Curso> listarCursos() throws BusinessException;
    public List<Especialidad> buscarEspecialidad() throws BusinessException;
}
