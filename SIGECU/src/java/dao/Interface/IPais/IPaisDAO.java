/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interface.IPais;

import dto.Pais;
import exception.BusinessException;

/**
 *
 * @author Dell
 */
public interface IPaisDAO {
     public void insertar(Pais pa) throws  BusinessException;
}
