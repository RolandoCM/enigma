/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.List;

/**
 *
 * @author Anel
 */
public class preInscripcion extends Usuario{

    private Integer idpreIns;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private Integer idEmpresa;
    private String carrera;
    private String confirmar;
    
    
    
    public preInscripcion() {
    }    
    
    

    public Integer getIdpreIns() {
        return idpreIns;
    }

    public void setIdpreIns(Integer idpreIns) {
        this.idpreIns = idpreIns;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getConfirmar() {
        return confirmar;
    }

    public void setConfirmar(String confirmar) {
        this.confirmar = confirmar;
    }
    private Integer idpre_inscripcion;

    public void setIdpre_inscripcion(Integer idpre_inscripcion) {
        this.idpre_inscripcion = idpre_inscripcion;
    }

    public Integer getIdpre_inscripcion() {
        return idpre_inscripcion;
    }
   

    
}
