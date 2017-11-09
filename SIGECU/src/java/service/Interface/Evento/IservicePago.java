/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Interface.Evento;

import dto.Pago;
import java.util.List;

/**
 *
 * @author Anayeli Ramírez
 */
public interface IservicePago {
    public void registrarPago(Pago pago);
    public List<Pago> listarPagoPendienteE();
    public String getMensaje();
    
}
