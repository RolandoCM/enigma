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
public class Instructor  {
	private Integer idinstructor;
        private int idEspecialidad;
        private int idUser;
        
	private String iNombre;	        
	private String iMaterno;
	private String iPaterno;
        private String carrera;
        private String especialidad;
        private String iEmail;
        private String iTelefono;
        private String iDireccion;
        private String username;
        private String role;
        private String descripcion;
        private String password;
        private String imagen;

    /**
     * @return the idinstructor
     */
    public Integer getIdinstructor() {
        return idinstructor;
    }

    /**
     * @param idinstructor the idinstructor to set
     */
    public void setIdinstructor(Integer idinstructor) {
        this.idinstructor = idinstructor;
    }

    /**
     * @return the idEspecialidad
     */
    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    /**
     * @param idEspecialidad the idEspecialidad to set
     */
    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    /**
     * @return the idUser
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * @return the iNombre
     */
    public String getiNombre() {
        return iNombre;
    }

    /**
     * @param iNombre the iNombre to set
     */
    public void setiNombre(String iNombre) {
        this.iNombre = iNombre;
    }

    /**
     * @return the iMaterno
     */
    public String getiMaterno() {
        return iMaterno;
    }

    /**
     * @param iMaterno the iMaterno to set
     */
    public void setiMaterno(String iMaterno) {
        this.iMaterno = iMaterno;
    }

    /**
     * @return the iPaterno
     */
    public String getiPaterno() {
        return iPaterno;
    }

    /**
     * @param iPaterno the iPaterno to set
     */
    public void setiPaterno(String iPaterno) {
        this.iPaterno = iPaterno;
    }

    /**
     * @return the carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * @return the especialidad
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * @param especialidad the especialidad to set
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * @return the iEmail
     */
    public String getiEmail() {
        return iEmail;
    }

    /**
     * @param iEmail the iEmail to set
     */
    public void setiEmail(String iEmail) {
        this.iEmail = iEmail;
    }

    /**
     * @return the iTelefono
     */
    public String getiTelefono() {
        return iTelefono;
    }

    /**
     * @param iTelefono the iTelefono to set
     */
    public void setiTelefono(String iTelefono) {
        this.iTelefono = iTelefono;
    }

    /**
     * @return the iDireccion
     */
    public String getiDireccion() {
        return iDireccion;
    }

    /**
     * @param iDireccion the iDireccion to set
     */
    public void setiDireccion(String iDireccion) {
        this.iDireccion = iDireccion;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
   
}
