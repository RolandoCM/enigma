/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Dell
 */
public class Perfil extends Usuario {
    
     private Integer idper;
    private String nombreper;
    private String apellidop;
        private String apellidom;

    private String telefono;
    private String email;
    private Integer idEmpresa;
    private String carrera;
    private String confirmar;

    public Perfil() {
    }

    public Integer getIdper() {
        return idper;
    }

    public void setIdper(Integer idper) {
        this.idper = idper;
    }

    

    public String getNombreper() {
        return nombreper;
    }

    public void setNombreper(String nombreper) {
        this.nombreper = nombreper;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
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
    
    
    
}
