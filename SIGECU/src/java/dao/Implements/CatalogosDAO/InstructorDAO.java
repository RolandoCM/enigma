/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implements.Instructor;
import dao.Interface.Instructor.IInstructorDAO;
import dto.curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import jdbc.ConectionDB;
import dto.instructor;
import exception.BusinessException;
import extras.Convierte;
import java.sql.SQLException;
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
    public void crearInstructor(instructor instructor) throws BusinessException{
        
        
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
    public List<instructor> listarInstructor() throws BusinessException{
        List<instructor> instructores= new ArrayList<>();
        String sql="SELECT * FROM instructor";
                
        try
        {
            Connection connection = database.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while(result.next())
            {
                instructor instructor = new instructor();
                instructor.setIdinstructor(Integer.parseInt(result.getString(1)));
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
    public void actualizarInstructor(instructor instructor) throws BusinessException {
        String sql = "UPDATE instructor SET iNombre=?, iPaterno=?, iMaterno=?, Carrera=?, Especialidad=?, iEmail=?, iTelefono=?, iDireccion=?"
                + "WHERE idinstructor=?";
        
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
            ps.setString(9, instructor.getIdinstructor().toString());
              
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
    public String cancelarInstructor(int idInstructor) throws BusinessException {
        String instructorcan="";
        String sql="delete from instructor WHERE idinstructor=?";
        try {
            Connection con = database.getConnection();
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setInt(1, idInstructor);
            int execute = ps.executeUpdate();
            
            if(execute == 0){
                throw  new BusinessException();
                
            }
            instructorcan="si";
            ps.close();
            con.close();
        } catch (Exception e) {
        }
        return instructorcan;
    }

   

    @Override
    public instructor buscarInstructorDAO(int idInstructor) throws BusinessException {
        instructor instructor = new instructor();
 
        String sql = "select * from cursos" +
        "where idcursos=?;";
        try
        {
            Connection conection = database.getConnection();
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, idInstructor);
            ResultSet result = ps.executeQuery();
            while(result.next())
            {
                instructor.setIdinstructor(Integer.parseInt(result.getString(1)));
                instructor.setiNombre(result.getString(2));
                instructor.setiPaterno(result.getString(3));
                instructor.setiMaterno(result.getString(4));
                instructor.setCarrera(result.getString(5));
                instructor.setEspecialidad(result.getString(6));
                instructor.setiEmail(result.getString(7)); 
                instructor.setiTelefono(result.getString(8)); 
                instructor.setiDireccion(result.getString(9)); 
            }
            conection.close();
            ps.close();
        }catch(Exception ex)
        {
            BusinessException be = new BusinessException();
            be.setIdException("001");
            be.setMensaje("Error en la capa de base de datos");
            throw be;
        }
        return instructor;
}

}
