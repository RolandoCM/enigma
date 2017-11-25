package dao.Implements.Curso;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.Interface.Curso.ICursoDashboardDAO;
import exception.BusinessException;
import extras.Convierte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import jdbc.ConectionDB;
import dto.curso;
import java.util.ArrayList;
/**
 *
 * @author alma
 */
public class CursosDashboardDAO implements ICursoDashboardDAO{
    private ConectionDB database = new ConectionDB();
    @Override
    public List<curso> dashCursoDAO() throws BusinessException {
        List<curso> dashCurso= new ArrayList<>();
        String sql = "SELECT * FROM cursos;";
        try
        {
                        
            Connection conn = database.getConnection();
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            
            while(result.next())
            {
                curso curso = new curso();
                curso.setIdcurso(Integer.parseInt(result.getString(1)));
                curso.setNombre(result.getString(2));
                curso.setHorario(result.getString(3));
                curso.setTipo(result.getString(6)); 
                curso.setI_idinstructor(result.getString(7));
                try
                {
                    String fechai = Convierte.fechaString(result.getDate(4));
                    curso.setFechaInicio(fechai);
                    String fechaf = Convierte.fechaString(result.getDate(5));
                    curso.setFechaFin(fechaf);
                }
                catch(SQLException e)
                {
                    curso.setFechaInicio("0000-00-00");
                    curso.setFechaFin("0000-00-00");
                }
                dashCurso.add(curso);
            }
            conn.close();
            ps.close();
            return dashCurso;
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
