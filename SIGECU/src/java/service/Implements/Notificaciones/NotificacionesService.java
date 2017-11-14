/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Implements.Notificaciones;

import dao.Implements.Notificaciones.NotificacionesDAO;
import dao.Interface.INotificaciones.INotificacionesDAO;
import dto.Evento;
import exception.BusinessException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import service.Interface.INotificaciones.INotificacionesService;
import service.email.Email;

/**
 *
 * @author rolando
 */
public class NotificacionesService implements INotificacionesService {

    @Override
    public void notificacionEmailComercial() throws BusinessException {
        
        try {
            List<Evento> evento;
            String eventos="";
            INotificacionesDAO notificarEmail = new NotificacionesDAO();
            evento = notificarEmail.notificarEmailComercial();
            for (Evento evento1 : evento) {
                eventos+=evento1.getNombre()+"  "+ evento1.getNombreCiudad()+"  "+
                        evento1.getNombrePais()+"   "+ evento1.getFecha()+"\n";
            }
            Email.send("jose-ramirez03@live.com.mx", "Eventos comercial", eventos);
        } catch (MessagingException ex) {
             BusinessException be = new BusinessException();
             be.setIdException("301");
             be.setMensaje("Error en la capa de negocio, envio de email");
             throw be;
        }
        
        
    }
    
}
