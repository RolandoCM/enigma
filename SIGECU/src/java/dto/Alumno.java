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
public class Alumno {
    private int idAlumno;
    private String nombreal;
    private String aParterno;
    private String aMaterno;
    private String telefono; 
    private String email;
    private String carrera;
    private String notbook;
    private String status;

    public Alumno() {
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombreal() {
        return nombreal;
    }

    public void setNombreal(String nombreal) {
        this.nombreal = nombreal;
    }

   
    public String getaParterno() {
        return aParterno;
    }

    public void setaParterno(String aParterno) {
        this.aParterno = aParterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
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

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getNotbook() {
        return notbook;
    }

    public void setNotbook(String notbook) {
        this.notbook = notbook;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
