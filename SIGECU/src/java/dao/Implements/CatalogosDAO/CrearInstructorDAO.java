/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implements.CatalogosDAO;

import dao.Interface.ICatalogos.ICrearInstructorDAO;
import dto.Instructor;
import exception.BusinessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import jdbc.ConectionDB;

/**
 *
 * @author zoro
 */
public class CrearInstructorDAO implements ICrearInstructorDAO {
    private final ConectionDB db;
    public CrearInstructorDAO()
    {
        this.db = new ConectionDB();
    }
    @Override
    public void nuevoInstructor(Instructor instructor) throws BusinessException {
        
        String sql = "insert into instructor (iNombre, iPaterno, iMaterno, Carrera, Especialidad, iEmail, iTelefono, iDireccion)\n" +
                     "values (?,?,?,?,?,?,?,?);";
        
        try
        {
            Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, instructor.getNombre());
            ps.setString(2, instructor.getPaterno());
            ps.setString(3, instructor.getMaterno());
            ps.setString(4, instructor.getCarrera());
            ps.setString(5, instructor.getEspecialidad());
            ps.setString(6, instructor.getEmail());
            ps.setString(7, instructor.getTelefono());
            ps.setString(8, instructor.getDireccion());
            
            ps.executeQuery();
            ps.close();
            cn.close();
        }catch (BusinessException e)
        {
            throw e;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            BusinessException be = new BusinessException();
            be.setIdException("201");
            be.setMensaje("Error en la capa de negocio, conexion en crear Evento");
            throw be;
        }
        
    }
    
}
