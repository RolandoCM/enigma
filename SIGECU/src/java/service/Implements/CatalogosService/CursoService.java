/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Implements.CatalogosService;


import dao.Implements.CatalogosDAO.CursoDAO;
import dao.Interface.ICatalogos.ICursoDAO;
import dto.Curso;
import dto.Especialidad;
import exception.BusinessException;
import java.util.List;
import service.Interface.ICatalogosService.ICursoService;

/**
 *
 * @author alma
 */
public class CursoService implements ICursoService{

    @Override
    public void crearCurso(Curso curso) throws BusinessException {
        try
        {
            ICursoDAO cursoDAO = new CursoDAO();
            cursoDAO.crearCurso(curso);
        }catch(BusinessException e){
            throw e;
        }
        catch(Exception e){
            BusinessException be = new BusinessException();
            be.setIdException("2001");
            be.setMensaje("Error en la capa de negocio");
            throw be;
        }
    }

    @Override
    public List<Curso> listarCursos() throws BusinessException {
        try
        {
            ICursoDAO cursoDAO = new CursoDAO();
            List<Curso> cursos = cursoDAO.listarCurso();
            return cursos;
        }catch(BusinessException e){
            throw e;
        }
        catch(Exception e){
            BusinessException be = new BusinessException();
            be.setIdException("2001");
            be.setMensaje("Error en la capa de negocio");
            throw be;
        }
    }

    @Override
    public List<Especialidad> buscarEspecialidad() throws BusinessException {
        
        try
        {
            ICursoDAO cursoDAO = new CursoDAO();
            List<Especialidad> especialidad= cursoDAO.buscarEspecialidad();
            return especialidad;
        }catch(BusinessException e){
            throw e;
        }
        catch(Exception e){
            BusinessException be = new BusinessException();
            be.setIdException("2001");
            be.setMensaje("Error en la capa de negocio");
            throw be;
        }
    }
}
