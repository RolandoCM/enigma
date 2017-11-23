/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author rolando
 */
public class Instructor extends Usuario {
    private String id;   
    private String carrera;
    private String especialidad;

    public String getCarrera() {
        return carrera;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   
    
    
}
