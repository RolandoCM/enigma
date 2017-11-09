/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interface.Evento;

import dto.identiPreIns;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author Anel
 */
public interface IPreInscripcionDAO {
    public List<identiPreIns> consultaPreIns() throws BusinessException;
    
}
