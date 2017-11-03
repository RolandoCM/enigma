/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Interface.Evento;

import dto.Evento;
import java.util.List;

/**
 *
 * @author rolando
 */
public interface IServiceEvento {
    public void crearEvento(Evento evento) ;
    public List<Evento> listarEventoConfirmado() ; 
    public void actualizarEventoConfirmado(Evento evento) ;
    public String cancelarEventoConfirmado(Evento evento) ; // por confirmar regreso de dato
    public Evento detallesEvento(int idEvento) ;
    
}
