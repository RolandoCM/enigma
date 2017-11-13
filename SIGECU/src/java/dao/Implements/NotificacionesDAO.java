/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implements;

import dao.Interface.INotificacionesDAO;
import dto.Evento;
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
 * @author rolando
 */
public class NotificacionesDAO implements INotificacionesDAO {
    private ConectionDB database;
    public NotificacionesDAO ()
    {
        this.database = new ConectionDB();
    }

    @Override
    public List<Evento> notificarEmailComercial() throws BusinessException {
         List<Evento> eventos= new ArrayList<>();
        String sql="SELECT e.idevento, e.nombre, c.nombre, p.nombre, e.fechaInicio FROM eventos e, ciudad c,"
                + "pais p WHERE c.idCiudad = e.c_idCiudad AND p.idPais=c.p_idPais AND e.fechaTermino>sysdate() AND e.estatus='on'"
                + " order by e.fechaInicio"; //e.fechaTermino>sysdate()
               // + "AND e.estatus IS NOT NULL;";
        try
        {
            Connection connection = database.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while(result.next())
            {
                Evento evento = new Evento();
                evento.setId(result.getString(1));
                evento.setNombre(result.getString(2));
                evento.setNombreCiudad(result.getString(3));
                evento.setNombrePais(result.getString(4));                 
                try
                {
                    String fecha = Convierte.fechaString(result.getDate(5));
                    evento.setFecha(fecha);
                }
                catch(SQLException e)
                {
                    evento.setFecha("0000-00-00");
                }
                eventos.add(evento);
            }
            connection.close();
            ps.close();
            return eventos;
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
