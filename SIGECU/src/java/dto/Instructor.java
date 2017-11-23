/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import extras.Convierte;

/**
 *
 * @author rolando
 */
public class Instructor extends Usuario {
   String mensaje = "<ul>";
   private String id;
	Integer idinstructor;
	String iNombre;	        
	String iMaterno;
	String iPaterno;
        String carrera;
        String especialidad;
        String iEmail;
        String iTelefono;
        String iDireccion;

    public Instructor() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getIdinstructor() {
        return idinstructor;
    }

    public void setIdinstructor(Integer idinstructor) {
        this.idinstructor = idinstructor;
    }

    public String getiNombre() {
        return iNombre;
    }

    public void setiNombre(String iNombre) {
        this.iNombre = iNombre;
    }

    public String getiMaterno() {
        return iMaterno;
    }

    public void setiMaterno(String iMaterno) {
        this.iMaterno = iMaterno;
    }

    public String getiPaterno() {
        return iPaterno;
    }

    public void setiPaterno(String iPaterno) {
        this.iPaterno = iPaterno;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getiEmail() {
        return iEmail;
    }

    public void setiEmail(String iEmail) {
        this.iEmail = iEmail;
    }

    public String getiTelefono() {
        return iTelefono;
    }

    public void setiTelefono(String iTelefono) {
        this.iTelefono = iTelefono;
    }

    public String getiDireccion() {
        return iDireccion;
    }

    public void setiDireccion(String iDireccion) {
        this.iDireccion = iDireccion;
    }

   
    
    
}
