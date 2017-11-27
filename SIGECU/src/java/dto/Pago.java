/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Anayeli Ramírez
 */
public class Pago {
    private String tipo;
    private int status;
    private Integer idPago;
    private String confirmar;
    private double monto;
    private String formaPago;
    private String fechaPago;
    private String quienPago;
    private String quePago;
    private String idEvento;
    private String idUsuario;
    private String idTipoPago;
    private String idHistorial;
    private String nombreAlumno;

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }
    

    public String getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(String idHistorial) {
        this.idHistorial = idHistorial;
    }
    

    public String getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(String idTipoPago) {
        this.idTipoPago = idTipoPago;
    }
    

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the idPago
     */
    public Integer getIdPago() {
        return idPago;
    }

    /**
     * @param idPago the idPago to set
     */
    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    /**
     * @return the confirmar
     */
    public String getConfirmar() {
        return confirmar;
    }

    /**
     * @param confirmar the confirmar to set
     */
    public void setConfirmar(String confirmar) {
        this.confirmar = confirmar;
    }

    /**
     * @return the monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * @return the formaPago
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * @param formaPago the formaPago to set
     */
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    /**
     * @return the fechaPago
     */
    public String getFechaPago() {
        return fechaPago;
    }

    /**
     * @param fechaPago the fechaPago to set
     */
    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    /**
     * @return the quienPago
     */
    public String getQuienPago() {
        return quienPago;
    }

    /**
     * @param quienPago the quienPago to set
     */
    public void setQuienPago(String quienPago) {
        this.quienPago = quienPago;
    }

    /**
     * @return the quePago
     */
    public String getQuePago() {
        return quePago;
    }

    /**
     * @param quePago the quePago to set
     */
    public void setQuePago(String quePago) {
        this.quePago = quePago;
    }
    
    
    
}
