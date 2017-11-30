/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interface.IPais;

import dto.Ciudad;
import dto.Pais;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface IPaisDAO {
     public void insertar(Pais pa) throws  BusinessException;
     public List<Pais> listarPaises() throws BusinessException;
           public void insertarCiudad(Ciudad ci) throws  BusinessException;
 public List<Pais> listarCiudades() throws BusinessException;
}
