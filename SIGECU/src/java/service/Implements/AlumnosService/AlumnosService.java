/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Implements.AlumnosService;

import dao.Implements.AlumnosDAO.AlumnosDAO;
import dao.Interface.IAlumnosDAO.IAlumnosDAO;
import dto.Curso;
import dto.Pago;
import exception.BusinessException;
import java.util.List;
import service.Interface.IAlumnosService.IAlumnosService;

/**
 *
 * @author zoro
 */
public class AlumnosService implements IAlumnosService{

    @Override
    public List<Curso> listarCursosAlumno(String alumno) throws BusinessException {
        try
        {
            List<Curso> listaCursos;
            IAlumnosDAO alumnoCursos  = new AlumnosDAO();
            
            int idAlumnno = alumnoCursos.buscarAlumno(alumno);
            listaCursos = alumnoCursos.listarCursosAlumno(idAlumnno);
            return listaCursos;
        }catch(BusinessException e){
            throw e;
        }catch(Exception ex){
            
            ex.printStackTrace();
            BusinessException mens=new BusinessException();
            mens.setIdException("1");
            mens.setMensaje("Error al registrar el pago");
            throw mens;
        }
    }

    @Override
    public List<Pago> listarPagosPendiente(String alumno) throws BusinessException {
        try
        {
            List<Pago> listaPagosPendientes;
            IAlumnosDAO alumnoCursos  = new AlumnosDAO();
            
            int idAlumnno = alumnoCursos.buscarAlumno(alumno);
            listaPagosPendientes = alumnoCursos.listaPagosPendientes(idAlumnno);
            return listaPagosPendientes;
        }catch(BusinessException e){
            throw e;
        }catch(Exception ex){
            
            ex.printStackTrace();
            BusinessException mens=new BusinessException();
            mens.setIdException("1");
            mens.setMensaje("Error al registrar el pago");
            throw mens;
        }
    }
}
