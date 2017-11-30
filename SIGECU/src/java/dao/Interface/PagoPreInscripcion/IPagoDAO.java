/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interface.PagoPreInscripcion;

import dto.Cheque;
import dto.Evento;
import dto.Pago;
import dto.Tarjeta;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author Anayeli Ramírez
 */
public interface IPagoDAO {
    public void registrarPago(Pago pago)throws BusinessException;
    public List<Pago> historialPagos(int idAlumno)throws BusinessException;
    public Pago tipoPago(Pago pago) throws BusinessException;
    public Pago buscarIdHistorialPago(Pago pago) throws BusinessException;
    public Pago buscarIdUsuario(Pago pago) throws BusinessException;
    
    /*Metodos pertenecientes a comercial*/
    public List<Pago> seguimientoPagos(int idEvento) throws BusinessException;
    public List<Evento> cargarEvento()throws BusinessException;
    public List<Pago> seguimientoPagos() throws BusinessException;
    public boolean confirmarPago(int idhistorial) throws BusinessException;
    public String correo(int idUsuario) throws BusinessException;
    
}
