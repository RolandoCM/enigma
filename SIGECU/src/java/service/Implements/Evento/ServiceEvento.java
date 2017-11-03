/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Implements.Evento;

import dao.Implements.Evento.EventoDAO;
import dao.Interface.Evento.IEventoDAO;
import dto.Evento;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import service.Interface.Evento.IServiceEvento;

/**
 *
 * @author rolando
 */
public class ServiceEvento implements IServiceEvento{

    @Override
    public void crearEvento(Evento evento) {
        
    }

    @Override
    public List<Evento> listarEventoConfirmado() {
        try
        {
            IEventoDAO evento = new EventoDAO();
            List<Evento> eventosConfirmados = new ArrayList<>();
            eventosConfirmados = evento.listarEventoCondirmado();
            
            Evento event = new Evento();
            event.setNombre("rolando");
            eventosConfirmados.add(event);
            return eventosConfirmados; 
        }
        catch (Exception e) {
            e.printStackTrace();
	}
        return null;
    }

    @Override
    public void actualizarEventoConfirmado(Evento evento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String cancelarEventoConfirmado(Evento evento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Evento detallesEvento(int idEvento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
