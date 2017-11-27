/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interface.PagoPreInscripcion;

import dto.Cheque;
import dto.Pago;
import dto.Tarjeta;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author Anayeli Ramírez
 */
public interface IPagoDAO {
    public void registrarPago(Pago pago);
    public List<Pago> historialPagosR();
    public List<Pago> mostrarDatos();
    public void tarjetaCredito(Tarjeta Tarjeta);
    public void cheque(Cheque cheque);
    public Pago tipoPago(Pago pago) throws BusinessException;
    public Pago buscarIdHistorialPago(Pago pago) throws BusinessException;
    public Pago buscarIdUsuario(Pago pago) throws BusinessException;
    
}
