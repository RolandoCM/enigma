/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Interface;

import dto.Evento;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author jose-
 */
public interface IServicePreInscripcion {
   public List<Evento> dashEvento() throws BusinessException; 
}
