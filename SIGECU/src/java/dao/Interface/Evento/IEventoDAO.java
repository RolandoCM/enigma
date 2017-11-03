/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interface.Evento;

import dto.Evento;
import exception.BusinessException;
import java.util.List;

/**
 *
 * @author rolando
 */
public interface IEventoDAO {
    public void crearEvento(Evento evento) throws BusinessException;
    public List<Evento> listarEventoCondirmado() throws BusinessException; 
    public void actualizarEventoConfirmado(Evento evento) throws BusinessException;
    public String cancelarEventoConfirmado(int idEvento) throws BusinessException; // por confirmar regreso de dato
    public Evento detallesEvento(int idEvento) throws BusinessException;
    
    
}