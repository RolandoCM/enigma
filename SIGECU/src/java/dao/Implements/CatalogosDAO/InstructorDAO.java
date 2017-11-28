/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implements.CatalogosDAO;

import dao.Interface.ICatalogos.IInstructorDAO;
import dto.Curso;
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
        
        
        /*
        insert into users (nombre, email, utelefono, username, password, imagen)
values ('Rodrigo', 'rodrigo@gmail.com','4425783658','rodrigo', md5('root'),'sin imagen');

insert into roles (username, role, descripcion, u_idusers) value (
					(SELECT username FROM users WHERE email='rodrigo@gmail.com'),
					'instructor', 'instructor', 
					(SELECT idusers FROM users WHERE email='rodrigo@gmail.com' ));

insert into instructor(iNombre, iPaterno, iMaterno, Carrera, iEmail, iTelefono, iDireccion, u_idusers)
values('Rodrigo', 'Salas', 'Rodriguez', 'ISC','rodrigo@gmail.com', '4425783658', 'centro 21', 
(SELECT idusers FROM users WHERE email='rodrigo@gmail.com'));

insert instructor_has_especialidad (i_idinstructor, e_idespecialidad)
values ((SELECT idinstructor FROM instructor WHERE iEmail='rodrigo@gmail.com'),2)
        
        
        */
        
        
        
        
        
        String sql = "insert into instructor (iNombre, iPaterno, iMaterno, Carrera, Especialidad, iEmail, iTelefono, iDireccion)"
                + " VALUES (?,?,?,?,?,?,?,?)";
        
        try
        {
            Connection conection = database.getConnection();
            PreparedStatement ps = conection.prepareStatement(sql);
            
            ps.setString(1, instructor.getiNombre());
            ps.setString(2, instructor.getiPaterno());
            ps.setString(3, instructor.getiMaterno());
            ps.setString(4, instructor.getCarrera());
            ps.setString(5, instructor.getEspecialidad());
            ps.setString(6, instructor.getiEmail());
            ps.setString(7, instructor.getiTelefono());
            ps.setString(8, instructor.getiDireccion());
              
              
            int exec = ps.executeUpdate();
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
   
}
