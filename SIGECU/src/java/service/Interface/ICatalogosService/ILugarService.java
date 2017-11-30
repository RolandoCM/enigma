/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Interface.ICatalogosService;

import dto.Ciudad;
import dto.Lugar;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author zoro
 */
public interface ILugarService {
    public List<Lugar> listarLugar() throws BusinessException;
    public void crearLugar (Lugar lugar) throws BusinessException;
    public List<Ciudad> buscarCiudad() throws BusinessException;
    
}
