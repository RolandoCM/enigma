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
public class Evento {
    private String nombre;
    private String fecha; // revisar fecha no es string 
    private String descripcion;
    private String programa;  // definir prgrama
    private Instructor instructor;
    private String lugar;
    private String ciudad;
    private int capacidad;
    private String tipo;
    private String status;
    private double costo;
    private String templete;
    private String promocion;

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setTemplete(String templete) {
        this.templete = templete;
    }

    public String getLugar() {
        return lugar;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public String getStatus() {
        return status;
    }

    public double getCosto() {
        return costo;
    }

    public String getTemplete() {
        return templete;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setPromocion(String promocion) {
        this.promocion = promocion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrograma() {
        return programa;
    }

    public Instructor getInstructor() {
        return instructor;
    }
    public String getPromocion() {
        return promocion;
    }
}
