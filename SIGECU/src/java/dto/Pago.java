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
    private int idEvento;
    private int idUsuario;
    private int idTipoPago;
    private int idHistorial;
    private String nombreAlumno;
    private double precio;

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }
    

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }
    

    public int getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(int idTipoPago) {
        this.idTipoPago = idTipoPago;
    }
    

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public void setIdUsuario(int idUsuario) {
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
