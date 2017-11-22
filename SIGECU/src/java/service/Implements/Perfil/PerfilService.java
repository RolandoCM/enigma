/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Implements.Perfil;

import dao.Implements.Evento.EventoDAO;
import dao.Implements.Perfil.PerfilDAO;
import dto.preInscripcion;
import exception.BusinessException;
import java.util.ArrayList;
import java.util.List;
import dao.Interface.Iperfil.IPerfilDAO;
import service.Interface.Perfil.IPerfilService;


/**
 *
 * @author Dell
 */
public class PerfilService implements IPerfilService{
    
     public List<preInscripcion> listaDatosPerfil() throws BusinessException{
          try
        {
            IPerfilDAO perfilDAO = new PerfilDAO();
            List<preInscripcion> datosPerfil = new ArrayList<>();
            datosPerfil = perfilDAO.listaDatosPerfil();         
            return datosPerfil; 
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
