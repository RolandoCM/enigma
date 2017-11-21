/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interface.Iperfil;
import dto.preInscripcion;
import exception.BusinessException;
import java.util.List;
/**
 *
 * @author JorgeLuna
 */
public interface IPerfil {
    public List<preInscripcion> listaDatosPerfil() throws BusinessException;
}
