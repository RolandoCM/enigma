/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interface.Curso;

import dao.Interface.Evento.*;
import dto.Evento;
import dto.IdentificadoresEvento;
import dto.Curso;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author alma
 */
public interface ICursoDAO {
    public void crearCurso(Curso curso) throws BusinessException;
    public List<Curso> listarCurso() throws BusinessException; 
    public void actualizarCurso(Curso curso) throws BusinessException;
    public Curso buscarCursoDAO(int iCcurso) throws BusinessException;
    public String cancelarCurso(int idCurso) throws BusinessException; 
}
