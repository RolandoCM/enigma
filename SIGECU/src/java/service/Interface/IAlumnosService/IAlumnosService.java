/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Interface.IAlumnosService;

import dto.Curso;
import dto.Pago;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author zoro
 */
public interface IAlumnosService {
    public List<Curso> listarCursosAlumno(String alumno) throws BusinessException;
    public List<Pago> listarPagosPendiente (String alumno) throws BusinessException;
}
