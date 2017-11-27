/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Implements.PreInscripcion;

import dao.Implements.PreInscripcion.PreInscripcionDAO;
import dao.Interface.IPreInscripciones.IPreInscripcionDAO;
import dto.identiPreIns;
import dto.PreInscripcionEvento;
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

    @Override
    public boolean registroPreInscripcion(PreInscripcionEvento preinscripcion) throws BusinessException {
        try
        {
            IPreInscripcionDAO preIns = new PreInscripcionDAO();
            PreInscripcionEvento datosCompletos =preIns.datosPreInscripcion(preinscripcion); 
            boolean preInscripcionConfirmada = preIns.nuevaPreInscripcion(datosCompletos);
            preIns.generarHistorialDePagos(datosCompletos);
            if(preInscripcionConfirmada)
            {
                String registro="Id Evento\tNombre Evento\tNombre pre-inscrito\n";
                        registro+=datosCompletos.getIdEvento()+"\t"+datosCompletos.getNombreEvento()+"\t"+
                        datosCompletos.getNombreAlumno();
                try {
                    Email.send("sigecu0@gmail.com", "Nueva PreIscripcion", registro );
                } catch (MessagingException ex) {
                    ex.printStackTrace();
                    BusinessException be = new BusinessException();
                    be.setIdException("201");
                    be.setMensaje("Error en la capa de negocio, no se envio el correo");
                    throw be;
                }
            }
            return preInscripcionConfirmada;
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
    public void generarHistorialDePago(PreInscripcionEvento preInscripcion) throws BusinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
