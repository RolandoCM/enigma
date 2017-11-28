/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implements.CatalogosDAO;

import dao.Interface.ICatalogos.IInstructorDAO;
import dto.Curso;
import dto.Especialidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import jdbc.ConectionDB;
import dto.Instructor;
import exception.BusinessException;
import java.util.ArrayList;

/**
 *
 * @author alma
 */
public class InstructorDAO implements IInstructorDAO {
    private final ConectionDB database;
    public InstructorDAO()
    {
        this.database = new ConectionDB();
    }
    @Override
    public void crearInstructor(Instructor instructor) throws BusinessException{
        
        
        String sqlUser =
        "insert into users (nombre, email, utelefono, username, password, imagen)"+
        "values (?,?,?,?, md5(?),?)";
        
        String sqlRole = "insert into roles (username, role, descripcion, u_idusers) "+
                "value ((SELECT username FROM users WHERE email=?),"+
                " ?, ?, (SELECT idusers FROM users WHERE email=? ));";
        
        String sqlInstructor = "insert into instructor(iNombre, iPaterno, iMaterno, Carrera, iEmail, iTelefono, iDireccion, u_idusers)"+
        "values(?, ?, ?, ?, ?, ?, ?, "+
        "(SELECT idusers FROM users WHERE email=?));";

        String sqlIE = "insert instructor_has_especialidad (i_idinstructor, e_idespecialidad) "
                + "values ((SELECT idinstructor FROM instructor WHERE iEmail=?),?)";

        
        try
        {
            Connection conection = database.getConnection();
            PreparedStatement ps = conection.prepareStatement(sqlUser);
            ps.setString(1, instructor.getiNombre());
            ps.setString(2, instructor.getiEmail());
            ps.setString(3, instructor.getiTelefono());
            ps.setString(4, instructor.getUsername());
            ps.setString(5, instructor.getPassword());
            ps.setString(6, instructor.getImagen());
            int exec = ps.executeUpdate();
            
            
            ps = conection.prepareStatement(sqlRole);
                ps.setString(1, instructor.getiEmail());
                ps.setString(2, instructor.getRole());
                ps.setString(3, instructor.getDescripcion());
                ps.setString(4, instructor.getiEmail());
                 ps.executeUpdate();
            
            ps = conection.prepareStatement(sqlInstructor);
                ps.setString(1, instructor.getiNombre());
                ps.setString(2, instructor.getiPaterno());
                ps.setString(3, instructor.getiPaterno());
                ps.setString(4, instructor.getCarrera());
                ps.setString(5, instructor.getiEmail());
                ps.setString(6, instructor.getiTelefono());
                ps.setString(7, instructor.getiDireccion());
                ps.setString(8, instructor.getiEmail());
                ps.executeUpdate();
            
            ps = conection.prepareStatement(sqlIE);
                ps.setString(1, instructor.getiEmail());
                ps.setInt(2, instructor.getIdEspecialidad());
                ps.executeUpdate();
            
            ps.close();
            conection.close();
        }catch(Exception e)
        {
            e.printStackTrace();
            BusinessException be = new BusinessException();
            be.setMensaje("error en la capa de base de datos");
            be.setIdException("001");
            throw be;
        }
        
    }

   
    @Override
    public List<Instructor> listarInstructor() throws BusinessException{
        List<Instructor> instructores= new ArrayList<>();
        String sql="select i.idinstructor, i.iNombre, i.iPaterno, i.iMaterno, i.Carrera, e.eNombre,i.iEmail, i.iTelefono, i.iDireccion\n" +
                    "from instructor i, especialidad e, instructor_has_especialidad ie\n" +
                    "where i.idinstructor=ie.i_idinstructor AND e.idespecialidad=ie.e_idespecialidad;";
                
        try
        {
            Connection connection = database.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while(result.next())
            {
                Instructor instructor = new Instructor();
                instructor.setIdinstructor(result.getInt(1));
                instructor.setiNombre(result.getString(2));
                instructor.setiPaterno(result.getString(3));
                instructor.setiMaterno(result.getString(4));
                instructor.setCarrera(result.getString(5));
                instructor.setEspecialidad(result.getString(6));
                instructor.setiEmail(result.getString(7)); 
                instructor.setiTelefono(result.getString(8)); 
                instructor.setiDireccion(result.getString(9)); 
                instructores.add(instructor);
            }
            connection.close();
            ps.close();
            return instructores;
        }catch(Exception ex)
        {
            ex.printStackTrace();
            BusinessException be = new BusinessException();
            be.printStackTrace();
            be.setMensaje("Error en la capa de base de datos");
            be.setIdException("0001");
            throw be;
        }
    }

    @Override
    public List<Especialidad> buscarEspecialidad() throws BusinessException {
        String sql = "select idespecialidad, eNombre from especialidad;";
         List<Especialidad> especialidad = new ArrayList<>();
        try
        {
            Connection connection = database.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while(result.next())
            {
                Especialidad esp = new Especialidad();
                esp.setIdEspecialidad(result.getInt(1));
                esp.setNombreEspecialidad(result.getString(2));
                especialidad.add(esp);
            }
            connection.close();
            ps.close();
            return especialidad;
        }catch(Exception ex)
        {
            ex.printStackTrace();
            BusinessException be = new BusinessException();
            be.printStackTrace();
            be.setMensaje("Error en la capa de base de datos");
            be.setIdException("0001");
            throw be;
        }
    }
   
}
