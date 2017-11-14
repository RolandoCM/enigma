/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Interface.IPreInscripcion;

import dto.identiPreIns;
import dto.preInscripcion;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author Anel
 */
public interface IPreInscripcionService {
    public List<preInscripcion> preQry();

    public void registroPreInscripcion(preInscripcion prein) throws BusinessException;

    public String getMensaje();
    
    public List<identiPreIns> consulPre() throws BusinessException;
}
