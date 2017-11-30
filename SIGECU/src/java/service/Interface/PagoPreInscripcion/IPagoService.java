/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Interface.PagoPreInscripcion;
import dto.Cheque;
import dto.Evento;
import dto.Pago;
import dto.Tarjeta;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author Anayeli
 */
public interface IPagoService {
    /*Metodos pertenecen a alumno o o preinscrito*/
    public void registrarPago(Pago pago) throws BusinessException;
    public List<Pago> historialPagos(String alumno) throws BusinessException;
  
    
    /*Metodos pertenecen a comercial*/
    public List<Pago> seguimientoPagos(int idEvento) throws BusinessException;
    public void confirmarPagos(int idHistorial, int idUsuario) throws BusinessException;
    public List<Evento> cargarEvento()throws BusinessException;
    public List<Pago> seguimientoPagos() throws BusinessException;
    
}
