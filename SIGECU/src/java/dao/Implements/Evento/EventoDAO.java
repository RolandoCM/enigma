/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implements.Evento;

import dto.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import jdbc.ConectionDB;
import dao.Interface.Evento.IEventoDAO;

/**
 *
 * @author rolando
 */
public class EventoDAO implements IEventoDAO {
    private final ConectionDB database;
    public EventoDAO()
    {
        this.database = new ConectionDB();
    }
    @Override
    public void crearEvento(Evento evento) {
        
        List<Evento> lista = null;
        String sql = "INSERT INTO eventos (nombre, fecha, descripcion,"
                + "destinatarios, programa, instructor, lugar, ciudad,"
                + " pais, capacidad, precios, promociones, tipo, status)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; //terminar consulta  *******
        Connection conection = database.getConnection();
        
        if(conection!=null)
        {
            try
            {
                PreparedStatement ps = conection.prepareStatement(sql);
                ps.setString(1, evento.getNombre());
                ps.setString(2, evento.getFecha());
                ps.setString(3, evento.getDescripcion());
                ps.setString(4, evento.getDestinatarios());
                ps.setString(5, evento.getPrograma());
                ps.setString(6, evento.getInstructor().getNombre());
                ps.setString(7, evento.getLugar());
                ps.setString(8, evento.getCiudad());
                ps.setString(9, evento.getPais());
                ps.setInt(10, evento.getCapacidad());
                ps.setDouble(11, evento.getPrecio());
                ps.setDouble(12, evento.getPromocion());
                ps.setShort(13, evento.getTipo());
                
                int exec = ps.executeUpdate();
                
                if(exec==0)
                {
                    throw new SQLException();
                }
                ps.close();
                
            }
            catch(SQLException ex)
            {
                
            }
        }
        
    }

    @Override
    public List<Evento> listarEventoCondirmado() {
        List<Evento> eventosConfirmados= null;
        String sql="SELECT nombre ciudad pais FROM eventos WHERE status==1"; //revisar consulta ******
        Connection connection = database.getConnection();
        if(connection!=null)
        {
            try
            {
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet result = ps.executeQuery();
                eventosConfirmados = new LinkedList<Evento>();
                while(result.next())
                {
                    Evento evento = new Evento();
                    evento.setNombre(result.getString(1));
                    evento.setCiudad(result.getString(2));
                    evento.setPais(result.getString(3));
                    eventosConfirmados.add(evento);
                }
                ps.close();
            }catch(SQLException ex)
            {
                
            }
        }
        return eventosConfirmados;
    }

    @Override
    public void actualizarEventoConfirmado(Evento evento) {
        
    }

    @Override
    public String cancelarEventoConfirmado(Evento evento) {
        
        return null;
    }

    @Override
    public Evento detallesEvento(int idEvento) {
        Evento evento= null;
        String sql="SELECT idEvento, nombre, fecha, descripcion, destinatarios, programa, instructor, "
                + "lugar, ciudad, pais, precios, promociones FROM eventos WHERE idEvento=? AND tipo=1"; // revisar consulta
        Connection connection = database.getConnection();
        if(connection != null)
        {
            PreparedStatement ps;
            try {
                ps = connection.prepareStatement(sql);
                ps.setInt(1, idEvento);
                
                int exec = ps.executeUpdate();
                
                if(exec ==0)
                {
                    throw new SQLException();
                }
                ps.close();
            } catch (SQLException ex) {
            }
            
        }
        
        return evento;
    }


}
