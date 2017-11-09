/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Interface.Evento;

import dto.identiPreIns;
import dto.preInscripcion;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author Anel
 */
public interface servPreInscr {
    public List<preInscripcion> preQry();

    public void alumnosIns(preInscripcion prein);

    public String getMensaje();
    
    public List<identiPreIns> consulPre() throws BusinessException;
}
