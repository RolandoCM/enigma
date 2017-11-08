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
import dto.IdentificadoresEvento;
import exception.BusinessException;
import extras.Convierte;
import java.sql.SQLException;
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
        
        
        String sql = "insert into eventos (nombre, fechaInicio, descripcion, "
                + "programa, i_idinstructor, lugar,c_idCiudad, capacidad,\n"
                + "tipo, estatus, costo, t_idtempletes, p_idpromociones)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)"; //terminar consulta  *******
        
        try
        {
            Connection conection = database.getConnection();
            PreparedStatement ps = conection.prepareStatement(sql);
            
            ps.setString(1, evento.getNombre());
            ps.setString(2, evento.getFecha());
            ps.setString(3, evento.getDescripcion());
            ps.setString(4, evento.getPrograma());
            ps.setString(5, evento.getInstructor().getId());
            ps.setString(6, evento.getLugar());
            ps.setString(7, evento.getCiudad());
            ps.setInt(8, evento.getCapacidad());
            ps.setString(9, evento.getTipo());
            ps.setString(10, evento.getStatus());
            ps.setDouble(11, evento.getCosto());
            ps.setString(12, evento.getTemplete());
            ps.setString(13, evento.getPromocion());
              
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

    /*Metodo para listar eventos*/
    @Override
    public List<Evento> listarEventoCondirmado() throws BusinessException{
        List<Evento> eventosConfirmados= new ArrayList<>();
        String sql="SELECT e.idevento, e.nombre, c.nombre, p.nombre, e.fechaInicio FROM eventos e, ciudad c,"
                + "pais p WHERE c.idCiudad = e.c_idCiudad AND p.idPais=c.p_idPais AND e.fechaInicio>sysdate()"
                + " order by e.fechaInicio";
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
    
    /*Metodo para listar eventos*/
    @Override
    public List<Evento> listarEventosPublicos() throws BusinessException{
        List<Evento> eventosPublicos= new ArrayList<>();
        String sql="SELECT idevento, nombre, fechaInicio FROM db_sigecu.eventos where tipo='Publico' order by fechaInicio";
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
                try
                {
                    String fecha = Convierte.fechaString(result.getDate(3));
                    evento.setFecha(fecha);
                }
                catch(SQLException e)
                {
                    evento.setFecha("0000-00-00");
                }
                eventosPublicos.add(evento);
            }
            connection.close();
            ps.close();
            return eventosPublicos;
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
    } //fin del metodo detallesEvento

    
    /*Metodo para generar los datos necesarios de rellono automatico en crear evento*/
    @Override
    public List<List<IdentificadoresEvento>> consultaDatosCrearEvento() throws BusinessException {
        List<List<IdentificadoresEvento>> datosParaEvento =  new ArrayList<>();
        final int INSTRUCTOR =0;
        final int CIUDAD = 1;
        final int TEMPLETE = 2;
        final int PROMOCION=3;
        String []sql = new String [4];
        
        sql[INSTRUCTOR] = "SELECT 	idinstructor, iNombre, iPaterno FROM instructor;";
        sql[CIUDAD]= "SELECT idCiudad, nombre FROM ciudad";
        sql [TEMPLETE]= "SELECT idtempletes, descripcion FROM templetes;";
        sql[PROMOCION] = "SELECT idpromociones, tipo FROM promociones;";
        try
        {
            Connection conn = database.getConnection();
            PreparedStatement ps;
            
            for(int i=0; i<sql.length;i++)
            {
                ps = conn.prepareStatement(sql[i]);
                ResultSet result = ps.executeQuery();
                List<IdentificadoresEvento> listaDatos= new ArrayList<>();
                while(result.next())
                {
                    IdentificadoresEvento idsEventos = new IdentificadoresEvento();
                    idsEventos.setId(result.getString(1));
                    if(i==0)
                        idsEventos.setNombre(result.getString(2) + " " + result.getString(3));
                    else
                        idsEventos.setNombre(result.getString(2));  
                    listaDatos.add(idsEventos);
                }
                datosParaEvento.add(listaDatos);
            }    
        }catch(Exception e)
        {
            BusinessException be = new BusinessException();
            be.setIdException("001");
            be.setMensaje("Error en la capa de base de datos");
            throw be;
        }
        
        return datosParaEvento;
    } //fin de metodo consultatDatosCrearEvento

    @Override
    public Evento buscarEventoDAO(int idEvento) throws BusinessException {
        Evento evento = new Evento();
        String sql = "SELECT e.nombre, c.nombre, p.nombre, e.fechaInicio "
                + "FROM eventos e, ciudad c, pais p "
                + "WHERE c.idCiudad = e.c_idCiudad AND p.idPais=c.p_idPais AND e.idevento=?;";
        try
        {
            Connection conection = database.getConnection();
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, idEvento);
            ps.executeQuery();
            
        }catch(Exception ex)
        {
            BusinessException be = new BusinessException();
            be.setIdException("001");
            be.setMensaje("Error en la capa de base de datos");
            throw be;
        }
        return evento;
    }


}
