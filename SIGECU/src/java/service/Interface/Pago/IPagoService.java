/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Interface.Pago;
import dto.Cheque;
import dto.Pago;
import dto.Tarjeta;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author Anayeli
 */
public interface IPagoService {
    public void insertarPago(Pago pago) throws BusinessException;
    public List<Pago> historialPagos() throws BusinessException;
     public void tarjetaCredito(Tarjeta tarjeta) throws BusinessException;
      public void cheque(Cheque cheque) throws BusinessException;
    
}
