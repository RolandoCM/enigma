/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interface.Evento;

import dto.Pago;
import java.util.List;

/**
 *
 * @author Anayeli Ramírez
 */
public interface IPagoDAO {
    public void registrarPago(Pago pago);
    public List<Pago> listarPagoPendienteE();
    
}
