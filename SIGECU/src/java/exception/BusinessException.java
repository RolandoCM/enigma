/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author rolando
 */
public class BusinessException extends Exception{
    private String idException;
    private String mensaje;

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setIdException(String idException) {
        this.idException = idException;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getIdException() {
        return idException;
    }
}
