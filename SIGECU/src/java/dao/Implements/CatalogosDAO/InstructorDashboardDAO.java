package dao.Implements.Instructor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.Interface.Curso.ICursoDashboardDAO;
import dao.Interface.Instructor.IInstructorDashboardDAO;
import exception.BusinessException;
import extras.Convierte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import jdbc.ConectionDB;
import dto.Curso;
import dto.Instructor;
import java.util.ArrayList;
/**
 *
 * @author alma
 */
public class InstructorDashboardDAO implements IInstructorDashboardDAO{
    private ConectionDB database = new ConectionDB();
    @Override
    public List<Instructor> dashInstructorDAO() throws BusinessException {
        List<Instructor> dashInstructor= new ArrayList<>();
        String sql = "SELECT * FROM cursos;";
        try
        {
                        
            Connection conn = database.getConnection();
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            
            while(result.next())
            {
                Instructor instructor = new Instructor();
                instructor.setIdinstructor(Integer.parseInt(result.getString(1)));
                instructor.setiNombre(result.getString(2));
                instructor.setiPaterno(result.getString(3));
                instructor.setiMaterno(result.getString(4));
                instructor.setCarrera(result.getString(5));
                instructor.setEspecialidad(result.getString(6));
                instructor.setiEmail(result.getString(7)); 
                instructor.setiTelefono(result.getString(8)); 
                instructor.setiDireccion(result.getString(9)); 
                dashInstructor.add(instructor);
            }
            conn.close();
            ps.close();
            return dashInstructor;
        }catch(Exception ex)
        {
            ex.printStackTrace();
            BusinessException be = new BusinessException();
            be.printStackTrace();
            be.setIdException("0001");
            be.setMensaje("Error en la capa de base de datos");
            throw be;
        }
    }

}
