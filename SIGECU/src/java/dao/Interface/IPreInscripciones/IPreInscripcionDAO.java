/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interface.IPreInscripciones;

import dto.Evento;
import dto.identiPreIns;
import dto.PreInscripcionEvento;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author Anel
 */
public interface IPreInscripcionDAO {
    public boolean nuevaPreInscripcion(PreInscripcionEvento preInscripcion) throws BusinessException;
    public PreInscripcionEvento datosPreInscripcion(PreInscripcionEvento preInscripcion) throws BusinessException;
    public void generarHistorialDePagos(PreInscripcionEvento preInscripcion) throws BusinessException;
    
}
