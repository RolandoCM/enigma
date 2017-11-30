/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Implements.Pais;

import dao.Implements.Pais.PaisDAO;
import dao.Interface.IPais.IPaisDAO;
import dto.Pais;
import exception.BusinessException;
import java.util.ArrayList;
import java.util.List;
import service.Interface.IPais.IPaisService;

/**
 *
 * @author Dell
 */
public class PaisService implements IPaisService{
    
     @Override
     public void insertar(Pais pa) throws  BusinessException{
         try
        {
            IPaisDAO paisDAO = new PaisDAO();
            paisDAO.insertar(pa);
        }
        catch (BusinessException e)
        {
            throw e;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            BusinessException be = new BusinessException();
            be.setIdException("201");
            be.setMensaje("Error en la capa de negocio, conexion en crear Evento");
            throw be;
        } 
     }
     
     public List<Pais> listarPaises() throws BusinessException{
          try
        {
            IPaisDAO paisDAO = new PaisDAO();
            List<Pais> datosPais = new ArrayList<>();
            datosPais = paisDAO.listarPaises();         
            return datosPais; 
        }
        catch (BusinessException e) {
            throw e;  
	}
        catch (Exception ex)
        {
            ex.printStackTrace();
            BusinessException be = new BusinessException();
            be.setIdException("201");
            be.setMensaje("Error en la capa de negocio, conexion a listar eventos");
            throw be;
        } 
     }
}
