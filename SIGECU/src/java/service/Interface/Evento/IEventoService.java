/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Interface.Evento;

import dto.Ciudad;
import dto.Evento;
import dto.IdentificadoresEvento;
import dto.Lugar;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author rolando
 */
public interface IEventoService {
    public List<List<IdentificadoresEvento>> consultaDatosCrearEvento() throws BusinessException;
    public void crearEvento(Evento evento) throws BusinessException;
    public List<Evento> listarEventoConfirmado() throws BusinessException; 
    public void actualizarEventoConfirmado(Evento evento) throws BusinessException;
    public Evento buscarEvento(int idEvento) throws BusinessException;
    public String cancelarEventoConfirmado(int idEvento) throws BusinessException ; // por confirmar regreso de dato
    public String confirmarEvento(int idEvento) throws BusinessException ;
    public Evento detallesEvento(int idEvento) throws BusinessException;
    public List<Evento> listarEventosPublicos() throws BusinessException;
    public List<Ciudad> cargarCiudades(int idPais) throws BusinessException;
    public List<Lugar> cargarLugares(int idCiudad) throws BusinessException;
    
}
