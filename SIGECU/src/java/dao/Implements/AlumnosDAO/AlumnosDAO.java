/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implements.AlumnosDAO;

import dao.Interface.IAlumnosDAO.IAlumnosDAO;
import dto.Curso;
import dto.Evento;
import dto.Pago;
import exception.BusinessException;
import extras.Convierte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConectionDB;

/**
 *
 * @author zoro
 */
public class AlumnosDAO implements IAlumnosDAO{
    private final ConectionDB database;
    public AlumnosDAO()
    {
        this.database=new ConectionDB();
    }

    @Override
    public List<Curso> listarCursosAlumno(int idAlumno) throws BusinessException {
        List<Curso> listaCursos=new ArrayList<>();
        String sql="select e.idEvento, c.cNombre, e.eHorario, e.eFechaInicio, e.eFechaTermino, concat(i.iNombre,\" \", i.iPaterno) as Nombre\n" +
            "from cursos c, eventos e, instructor i, alumno a\n" +
            "where c.idcursos=e.cursos_idcursos AND i.idinstructor=e.i_idinstructor AND a.idalumno=?;";
        try{
          Connection connection=database.getConnection();
          PreparedStatement ps=connection.prepareStatement(sql);
          ps.setInt(1, idAlumno);
          ResultSet result=ps.executeQuery();
          while(result.next()){
              Curso curso = new Curso();
              curso.setIdcurso(result.getInt(1));
              curso.setNombre(result.getString(2));
              curso.setHorario(result.getString(3));  
              try{
                  String fecha= Convierte.fechaString(result.getDate(4));
                  curso.setFechaInicio(fecha);
              }
              catch(SQLException e){
                 curso.setFechaInicio("0000-00-00");
              }
              try{
                  String fecha= Convierte.fechaString(result.getDate(5));
                  curso.setFechaFin(fecha);
              }
              catch(SQLException e){
                 curso.setFechaFin("0000-00-00");
              }
              curso.setNombreInstructor(result.getString(6));
              listaCursos.add(curso);
          }
          connection.close();
          ps.close();
          return listaCursos;
        }
        catch(Exception ex){
          ex.printStackTrace();
            BusinessException be = new BusinessException();
            be.printStackTrace();
            be.setMensaje("Error al conectar la base de datos");
            be.setIdException("1");
            throw be;
        }
    }

    @Override
    public int buscarAlumno(String alumno) throws BusinessException {
        String sql = "Select a.idalumno\n" +
                        "from alumno a, users u\n" +
                        "where a.u_idusers=u.idusers AND u.username=?";
        int idAlumno=0;
        try
        {
            Connection cn = database.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, alumno);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                idAlumno=rs.getInt(1);
            }
            ps.close();
            cn.close();
            return idAlumno;
        }catch (Exception e)
        {
            
            e.printStackTrace();
            BusinessException be = new BusinessException();
            be.setMensaje("error en la capa de base de datos");
            be.setIdException("001");
            throw be;
        }
    }

    @Override
    public List<Pago> listaPagosPendientes(int idAlumno) throws BusinessException {
        
        String sql = "SELECT hp.idhistorialPagos, c.cNombre, pre.precio, e.eFechaInicio, (pre.precio-SUM(p.pCantidad))\n" +
                    "FROM eventos e, cursos c, pagos p, historialPagos hp, alumno_has_eventos ae, precios pre,\n" +
                    "	eventos_precios_destinatarios epd, alumno a, tipoPago tp\n" +
                    "WHERE e.cursos_idcursos=c.idcursos AND pre.idprecios=epd.p_idprecios AND epd.e_idevento=e.idevento\n" +
                    "	AND ae.e_idevento=e.idevento AND ae.a_idalumno=a.idalumno AND hp.idhistorialPagos=p.hP_idhistorialPagos\n" +
                    "    AND ae.a_idalumno=hp.ahe_a_idalumno AND hp.ahe_e_idevento=ae.e_idevento AND tp.idtipoPago=p.tP_idtipoPago\n" +
                    "    AND hp.pagoCompleto='0' AND a.idalumno=?\n" +
                    "GROUP BY  hp.idhistorialPagos, c.cNombre, pre.precio, p.pCantidad,e.eFechaInicio;";
        try
        {
            List<Pago> pagosPendientes =new ArrayList<>();
            Connection cn = database.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Pago pago = new Pago();
                pago.setIdHistorial(1);
                pago.setQuePago(rs.getString(2));
                pago.setPrecio(rs.getDouble(3));
                try{
                  String fecha= Convierte.fechaString(rs.getDate(4));
                  pago.setFechaPago(fecha);
                }
                catch(SQLException e){
                   pago.setFechaPago("0000-00-00");
                }
                pago.setMonto(rs.getDouble(5));
                pagosPendientes.add(pago);
                
                
            }
            ps.close();
            cn.close();
            return pagosPendientes;
        }catch (Exception e)
        {
            
            e.printStackTrace();
            BusinessException be = new BusinessException();
            be.setMensaje("error en la capa de base de datos");
            be.setIdException("001");
            throw be;
        }
    }
    
}
