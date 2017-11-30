/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Implements.CatalogosService;

import dao.Implements.CatalogosDAO.LugarDAO;
import dao.Interface.ICatalogos.ILugarDAO;
import dto.Ciudad;
import dto.Lugar;
import exception.BusinessException;
import java.util.List;
import service.Interface.ICatalogosService.ILugarService;

/**
 *
 * @author zoro
 */
public class LugarService implements ILugarService{

    @Override
    public List<Lugar> listarLugar() throws BusinessException {
        try
        {
            ILugarDAO lugarDAO = new LugarDAO();
            List<Lugar> lugar = lugarDAO.listarLugar();
            return lugar;
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
    public void crearLugar(Lugar lugar) throws BusinessException {
        try
        {
            ILugarDAO lugarDAO = new LugarDAO();
            lugarDAO.crearLugar(lugar);
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
    public List<Ciudad> buscarCiudad() throws BusinessException {
        try
        {
            ILugarDAO lugarDAO = new LugarDAO();
            List<Ciudad> ciudad = lugarDAO.buscarCiudad();
            
            return ciudad;
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
