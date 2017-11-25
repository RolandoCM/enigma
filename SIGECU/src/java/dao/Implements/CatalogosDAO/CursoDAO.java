/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implements.Curso;

import dao.Implements.Evento.*;
import dao.Interface.Curso.ICursoDAO;
import dto.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import jdbc.ConectionDB;
import dto.curso;
import exception.BusinessException;
import extras.Convierte;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alma
 */
public class CursoDAO implements ICursoDAO {
    private final ConectionDB database;
    public CursoDAO()
    {
        this.database = new ConectionDB();
    }
    @Override
    public void crearCurso(curso curso) throws BusinessException{
        
        
        String sql = "insert into cursos (nombre, horario, fechaInicio, fechaFin, tipo, i_idinstructor)"
                + " VALUES (?,?,?,?,?,?)";
        
        try
        {
            Connection conection = database.getConnection();
            PreparedStatement ps = conection.prepareStatement(sql);
            
            ps.setString(1, curso.getNombre());
            ps.setString(2, curso.getHorario());
            ps.setString(3, curso.getFechaInicio());
            ps.setString(4, curso.getFechaFin());
            ps.setString(5, curso.getTipo());
            ps.setInt(6, Integer.parseInt(curso.getTipo()));
              
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
    public List<curso> listarCurso() throws BusinessException{
        List<curso> cursos= new ArrayList<>();
        String sql="SELECT c.idcursos, c.nombre, c.horario, c.fechaInicio, c.fechaFin, c.tipo, c.i_idinstructor FROM curssos";
                
        try
        {
            Connection connection = database.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
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
                cursos.add(curso);
            }
            connection.close();
            ps.close();
            return cursos;
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
    public void actualizarCurso(curso curso) throws BusinessException {
        String sql = "UPDATE cursos SET nombre=?, horario=?, fechaInicio=?, fechaFin=?, tipo=?, i_idinstructor=?"
                + "WHERE idcursos=?";
        
        try
        {
            Connection conection = database.getConnection();
            PreparedStatement ps = conection.prepareStatement(sql);
            
            ps.setString(1, curso.getNombre());
            ps.setString(2, curso.getHorario());
            ps.setString(3, curso.getFechaInicio());
            ps.setString(4, curso.getFechaFin());
            ps.setString(5, curso.getTipo());
            ps.setString(6, curso.getI_idinstructor());
            
              
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
    public String cancelarCurso(int idCurso) throws BusinessException {
        String cursocan="";
        String sql="delete from cursos WHERE idevento=?";
        try {
            Connection con = database.getConnection();
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCurso);
            int execute = ps.executeUpdate();
            
            if(execute == 0){
                throw  new BusinessException();
                
            }
            cursocan="si";
            ps.close();
            con.close();
        } catch (Exception e) {
        }
        return cursocan;
    }

   

    @Override
    public curso buscarCursoDAO(int idCurso) throws BusinessException {
        curso curso = new curso();
 
        String sql = "select * from cursos" +
        "where idcursos=?;";
        try
        {
            Connection conection = database.getConnection();
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, idCurso);
            ResultSet result = ps.executeQuery();
            while(result.next())
            {
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
        return curso;
}
}
