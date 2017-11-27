/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Interface.IPreInscripcion;

import dto.Pago;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author Anayeli Ramírez
 */
public interface IPagoService {
    public void registrarPago(Pago pago) throws BusinessException;
    public List<Pago> listarPagoPendienteE() throws BusinessException;
    
}
