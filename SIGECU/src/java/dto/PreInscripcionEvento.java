/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author zoro
 */
public class PreInscripcionEvento {
    private String idEvento;
    private String nombreEvento;
    private String usuario;
    private String idUsuario;
    private String activoInscrito;
    private String confirmadoPago;
    private String nombreAlumno;
    private String fechaInicio;

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    /**
     * @return the idEvento
     */
    public String getIdEvento() {
        return idEvento;
    }

    /**
     * @param idEvento the idEvento to set
     */
    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    /**
     * @return the nombreEvento
     */
    public String getNombreEvento() {
        return nombreEvento;
    }

    /**
     * @param nombreEvento the nombreEvento to set
     */
    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the idUsuario
     */
    public String getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the activoInscrito
     */
    public String getActivoInscrito() {
        return activoInscrito;
    }

    /**
     * @param activoInscrito the activoInscrito to set
     */
    public void setActivoInscrito(String activoInscrito) {
        this.activoInscrito = activoInscrito;
    }

    /**
     * @return the confirmadoPago
     */
    public String getConfirmadoPago() {
        return confirmadoPago;
    }

    /**
     * @param confirmadoPago the confirmadoPago to set
     */
    public void setConfirmadoPago(String confirmadoPago) {
        this.confirmadoPago = confirmadoPago;
    }
    
    
    
}
