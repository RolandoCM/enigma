/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import extras.Convierte;

/**
 *
 * @author David
 */
public class Curso  extends Alumno{
    String mensaje;
    Integer idcurso;
    String nombrecur;	        
    String horario;
    String fechaInicio;
    String fechaFin;
    String tipo;
    String i_idinstructor;
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Integer idcurso) {
        this.idcurso = idcurso;
    }

    public String getNombrecur() {
        return nombrecur;
    }

    public void setNombrecur(String nombrecur) {
        this.nombrecur = nombrecur;
    }

   

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getI_idinstructor() {
        return i_idinstructor;
    }

    public void setI_idinstructor(String i_idinstructor) {
        this.i_idinstructor = i_idinstructor;
    }
    
}
