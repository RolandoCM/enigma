package dao.Implements.Evento;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dto.Evento;
import exception.BusinessException;
import extras.Convierte;
import extras.ObtenerProgreso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jdbc.ConectionDB;
import dao.Interface.Evento.IEventosDashboardDAO;
/**
 *
 * @author jose-
 */
public class EventosDashboardDAO implements IEventosDashboardDAO{
    private ConectionDB database = new ConectionDB();
    @Override
    public List<Evento> dashEventoDAO() throws BusinessException {
        List<Evento> dashEvento= new ArrayList<>();
        String sql = "select  e.idevento, c.cNombre, e.eFechaInicio, e.eFechaTermino, count(*)\n" +
                    "from alumno a, alumno_has_eventos ae, cursos c, eventos e\n" +
                    "where ae.e_idevento = e.idevento and a.idalumno=ae.a_idalumno and e.cursos_idcursos = c.idcursos and ae.activo=1\n" +
                    "group by e.idevento, c.cNombre, e.eFechaInicio, e.eFechaTermino;";
        
        try
        {
                        
            Connection conn = database.getConnection();
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Evento evento = new Evento();
                evento.setId(rs.getString(1));
                evento.setNombre(rs.getString(2));
                 try
                {
                    String fechaInicio = Convierte.fechaString(rs.getDate(3));
                    String fechaTermino = Convierte.fechaString(rs.getDate(4));
                    evento.setProgreso(ObtenerProgreso.progreso(fechaInicio, fechaTermino));
                    evento.setFecha(fechaInicio);
                    evento.setFechaTermino(fechaTermino);
                }catch(SQLException e)
                {
                    evento.setFecha("0000-00-00");
                    evento.setFechaTermino("0000-00-00");
                }
                 evento.setInscritos(rs.getInt(5));
                dashEvento.add(evento);
            }
            conn.close();
            ps.close();
            return dashEvento;
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
