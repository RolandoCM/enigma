/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Interface.IPreInscripcion;

import dto.identiPreIns;
import dto.PreInscripcionEvento;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author Anel
 */
public interface IPreInscripcionService {

    public void generarHistorialDePago(PreInscripcionEvento preInscripcion) throws BusinessException;
    public boolean registroPreInscripcion(PreInscripcionEvento preInscripcion) throws BusinessException;
}
