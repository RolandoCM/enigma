/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Implements.PreInscripcion;

import dao.Implements.PreInscripcion.PreInscripcionDAO;
import dao.Interface.IPreInscripciones.IPreInscripcionDAO;
import dto.identiPreIns;
import dto.preInscripcion;
import exception.BusinessException;
import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;
import service.email.Email;
import service.Interface.IPreInscripcion.IPreInscripcionService;

/**
 *
 * @author Anel
 */
public class PreInscripcionService implements IPreInscripcionService {

    private String mensaje;
    @Override
    public List<preInscripcion> preQry() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    @Override
    public void registroPreInscripcion(preInscripcion preIn) throws BusinessException {
        try
        {
            IPreInscripcionDAO preIns = new PreInscripcionDAO();
            boolean enviarEmail = preIns.nuevaPreInscripcion(preIn);
            if(enviarEmail)
            {
                String registro = preIn.getNombre()+"   "+preIn.getApellido()+"     "+
                preIn.getTelefono()+"   "+preIn.getEmail()+"\n";
                try {
                    Email.send("sigecu0@gmail.com", "Nueva Inscripcion", registro );
                } catch (MessagingException ex) {
                    ex.printStackTrace();
                    BusinessException be = new BusinessException();
                    be.setIdException("201");
                    be.setMensaje("Error en la capa de negocio, no se envio el correo");
                    throw be;
                }
            }
        }catch (BusinessException e)
        {
            throw e;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            BusinessException be = new BusinessException();
            be.setIdException("201");
            be.setMensaje("Error en la capa de negocio, conexion en crear Evento");
            throw be;
        }
        
    }
    @Override
    public String getMensaje() {
		return mensaje;
	}

    public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	} 
    
    @Override
    public List<identiPreIns> consulPre() throws BusinessException {
        List<identiPreIns> empresaPreIns = new ArrayList<>();
        
        IPreInscripcionDAO preIns = new PreInscripcionDAO();
        empresaPreIns = preIns.consultaPreIns();
        
        return empresaPreIns;
    }
    
}
