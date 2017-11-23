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
public class Cheque {
    private int numeroSeguridad;
    private int cantidad;

    public Cheque() {
    }
    

    public int getNumeroSeguridad() {
        return numeroSeguridad;
    }

    public void setNumeroSeguridad(int numeroSeguridad) {
        this.numeroSeguridad = numeroSeguridad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
