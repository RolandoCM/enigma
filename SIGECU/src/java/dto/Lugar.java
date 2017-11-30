/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Memo
 */
public class Lugar {
    
    private int idLugar;
    private String nombreLugar;
    private String descripcionLugar;
    private int idCiudad;
    private String ciudadLugar;

    public String getCiudadLugar() {
        return ciudadLugar;
    }

    public void setCiudadLugar(String ciudadLugar) {
        this.ciudadLugar = ciudadLugar;
    }
    

    /**
     * @return the idLugar
     */
    public int getIdLugar() {
        return idLugar;
    }

    /**
     * @param idLugar the idLugar to set
     */
    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    /**
     * @return the nombreLugar
     */
    public String getNombreLugar() {
        return nombreLugar;
    }

    /**
     * @param nombreLugar the nombreLugar to set
     */
    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }

    /**
     * @return the descripcionLugar
     */
    public String getDescripcionLugar() {
        return descripcionLugar;
    }

    /**
     * @param descripcionLugar the descripcionLugar to set
     */
    public void setDescripcionLugar(String descripcionLugar) {
        this.descripcionLugar = descripcionLugar;
    }

    /**
     * @return the idCiudad
     */
    public int getIdCiudad() {
        return idCiudad;
    }

    /**
     * @param idCiudad the idCiudad to set
     */
    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }
    
    
    
    
}
