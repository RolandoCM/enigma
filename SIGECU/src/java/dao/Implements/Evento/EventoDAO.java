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
import java.util.List;
import jdbc.ConectionDB;
import dao.Interface.Evento.IEventoDAO;
import exception.BusinessException;
import java.util.ArrayList;

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
    public void crearEvento(Evento evento) throws BusinessException{
        
        List<Evento> lista = null;
        String sql = "INSERT INTO eventos (nombre, fechaInicio, descripcion,"
                + "programa, i_idinstructor, lugar, c_idCiudad,"
                + "capacidad,tipo,estatus, costo, t_idtempletes, p_idpromociones)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)"; //terminar consulta  *******
        
        try
        {
            Connection conection = database.getConnection();
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setString(1, evento.getNombre());
            ps.setString(2, evento.getFecha());
            ps.setString(3, evento.getDescripcion());
            ps.setString(5, evento.getPrograma());
            ps.setString(6, evento.getInstructor().getNombre());
            ps.setString(7, evento.getLugar());
            ps.setString(8, evento.getCiudad());
            ps.setInt(9, evento.getCapacidad());
            ps.setString(10, evento.getTipo());
            ps.setString(11, evento.getStatus());
            ps.setInt(12, evento.getTemplete());
            ps.setDouble(13, evento.getPromocion());
              
            int exec = ps.executeUpdate();
              
            if(exec==0)
            {
                throw new BusinessException();
            }
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
    public List<Evento> listarEventoCondirmado() throws BusinessException{
        List<Evento> eventosConfirmados= new ArrayList<>();
        String sql="SELECT nombre ciudad pais FROM eventos WHERE status==1"; //revisar consulta ******
        try
        {
            Connection connection = database.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while(result.next())
            {
                Evento evento = new Evento();
                evento.setNombre(result.getString(1));
                evento.setCiudad(result.getString(2));
                eventosConfirmados.add(evento);
            }
            connection.close();
            ps.close();
            return eventosConfirmados;
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
    public void actualizarEventoConfirmado(Evento evento) throws BusinessException {
        
    }

    @Override
    public String cancelarEventoConfirmado(int idEvento) throws BusinessException {
        
        return null;
    }

    @Override
    public Evento detallesEvento(int idEvento) throws BusinessException{
        Evento evento= null;
        String sql="SELECT idEvento, nombre, fecha, descripcion, destinatarios, programa, instructor, "
                + "lugar, ciudad, pais, precios, promociones FROM eventos WHERE idEvento=? AND tipo=1"; // revisar consulta
        
        try {
            Connection connection = database.getConnection();
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            ps.setInt(1, idEvento);
              
            int exec = ps.executeUpdate();
               
            if(exec ==0)
            {
                throw new BusinessException();
            }
            ps.close();
            connection.close();
            return evento;
        } catch (Exception ex) {
            BusinessException be = new BusinessException();
            be.setIdException("0001");
            be.setMensaje("Error en la capa de base de datos");
            throw be;
        }
    }


}
