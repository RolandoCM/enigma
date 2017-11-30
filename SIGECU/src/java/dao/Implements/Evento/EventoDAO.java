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
import dto.Ciudad;
import dto.IdentificadoresEvento;
import dto.Instructor;
import dto.Lugar;
import dto.MensajesDTO;
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
        
        
        String sql = "INSERT INTO eventos (cursos_idcursos, i_idinstructor, d_iddestinatario, fechaTermino, fechaInicio,\n" +
                        "programa, lugar_idlugar,capacidad, tipo,precios_idprecios, estatus)\n" +
                        "values(?,?,?,?,?,?,?,?,?,?,?);";
        
        
        try
        {
            Connection conection = database.getConnection();
            PreparedStatement ps = conection.prepareStatement(sql);
            
            ps.setString(1, evento.getNombre());
            ps.setString(2, evento.getInstructor().getId());
            ps.setString(3, evento.getDestinatarios());
            ps.setString(4, evento.getFechaTermino());
            ps.setString(5, evento.getFecha());
            ps.setString(6, evento.getPrograma());
            ps.setString(7, evento.getLugar());
            ps.setInt(8, evento.getCapacidad());
            ps.setString(9, evento.getTipo());
            ps.setDouble(10, evento.getCosto());
            ps.setString(11, evento.getStatus());
            
              
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
        String sql="select e.idevento, c.cNombre, t.idtempletes ,cd.cNombre, p.pNombre, e.eFechaInicio, e.eFechaTermino, e.eEstatus, e.eTipo\n" +
                    "from eventos e, cursos c, instructor i, lugar l, ciudad cd, pais p, templetes t\n" +
                    "where e.cursos_idcursos = c.idcursos\n" +
                    "AND e.i_idinstructor = i.idinstructor\n" +
                    "AND e.lugar_idlugar = l.idlugar AND l.c_idCiudad = cd.idCiudad AND cd.p_idPais = p.idPais\n" +
                    "AND e.t_idtempletes = t.idtempletes\n" +
                    "ORDER BY e.eEstatus DESC;";//e.fechaTermino>sysdate()
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
                evento.setTemplete(result.getString(3));
                evento.setNombreCiudad(result.getString(4));
                evento.setNombrePais(result.getString(5));               
                try
                {
                    String fechaI = Convierte.fechaString(result.getDate(6));
                    evento.setFecha(fechaI);
                }
                catch(SQLException e)
                {
                    evento.setFecha("0000-00-00");
                }
                
                try
                {
                    String fechaT = Convierte.fechaString(result.getDate(7));
                    evento.setFechaTermino(fechaT);
                }
                catch(SQLException e)
                {
                    evento.setFecha("0000-00-00");
                }
                evento.setStatus(result.getString(8));
                
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
        
        
        
        String sql="select  e.idevento, c.cNombre, e.eFechaInicio, c.cDescripcion, e.ePrograma, i.iNombre,\n" +
"i.iPaterno, i.iMaterno, l.lNombre, cd.cNombre, e.eCapacidad, e.eTipo, e.eEstatus, pre.precio, pro.nombre\n" +
"from eventos e, cursos c, ciudad cd, pais p, lugar l, instructor i, precios pre, promociones pro,\n" +
"		templetes t, eventos_precios_destinatarios epd, destinatario d, eventos_has_promociones ep\n" +
"        \n" +
"where e.cursos_idcursos=c.idcursos AND p.idPais=cd.p_idPais AND i.idinstructor=e.i_idinstructor\n" +
"	AND l.idlugar=e.lugar_idlugar AND t.idtempletes = e.t_idtempletes AND epd.p_idprecios=pre.idprecios\n" +
"    AND epd.e_idevento=e.idevento AND epd.d_iddestinatario=d.iddestinatario AND pro.idpromociones=ep.p_idpromociones\n" +
"    AND ep.e_idevento=e.idevento AND l.c_idCiudad=cd.idCiudad\n" +
"	AND cd.p_idPais=p.idPais and e.eEstatus='on' AND e.eTipo='publico';";
        
//        String sqlins="SELECT iNombre,iPaterno,iMaterno FROM instructor WHERE idinstructor=?";
//        String sqlciudad="SELECT nombre FROM ciudad WHERE idCiudad=?";
//        String sqlpromociones="SELECT tipo FROM promociones WHERE idpromociones=?";
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
                evento.setDescripcion(result.getString(4));
                evento.setPrograma(result.getString(5));
                Instructor ins= new Instructor();
                ins.setNombre(result.getString(6)+result.getString(7)+result.getString(8));
                evento.setInstructor(ins);
                evento.setLugar(result.getString(9));
                evento.setCiudad(result.getString(10));
                evento.setCapacidad(result.getInt(11));
                evento.setTipo(result.getString(12));
                evento.setStatus(result.getString(13));
                evento.setCosto(result.getDouble(14));
                evento.setPromocion(result.getString(15));
                
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
        String sql = "UPDATE eventos SET nombre=?, fechaInicio=?, descripcion=?, "
                + "programa=?, i_idinstructor=?, lugar=?,c_idCiudad=?, capacidad=?,\n"
                + "tipo=?, estatus=?, costo=?, t_idtempletes=?, p_idpromociones=?, fechaTermino=? WHERE idevento=?";
        
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
            ps.setString(14, evento.getFechaTermino());
            ps.setString(15, evento.getId());
            
              
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
    public String cancelarEventoConfirmado(int idEvento) throws BusinessException {
        String eventocan="";
        String sql="UPDATE eventos SET eEstatus='off' WHERE idevento=?";
        try {
            Connection con = database.getConnection();
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setInt(1, idEvento);
            int execute = ps.executeUpdate();
            
            if(execute == 0){
                throw  new BusinessException();
                
            }
            eventocan="si";
            ps.close();
            con.close();
        } catch (Exception ex) {
            BusinessException be = new BusinessException();
            be.setIdException("0001");
            be.setMensaje("Error en la capa de base de datos");
            throw be;
        }
        return eventocan;
    }
    
    @Override
    public String confirmarEvento(int idEvento) throws BusinessException {
        String eventocon="";
        String sql="UPDATE eventos SET eEstatus='on' WHERE idevento=?";
        try {
            Connection con = database.getConnection();
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setInt(1, idEvento);
            int execute = ps.executeUpdate();
            
            if(execute == 0){
                throw  new BusinessException();
                
            }
            eventocon="si";
            ps.close();
            con.close();
        } catch (Exception ex) {
            BusinessException be = new BusinessException();
            be.setIdException("0001");
            be.setMensaje("Error en la capa de base de datos");
            throw be;
        }
        return eventocon;
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
        final int PAIS=4;
        final int CURSO=5;
        final int LUGAR=6;
        final int PRECIO=7;
        final int DESTINATARIOS=8;
        String []sql = new String [9];
        
        sql[INSTRUCTOR] = "SELECT idinstructor, iNombre, iPaterno FROM instructor;";
        sql[CIUDAD]= "SELECT idCiudad, cNombre FROM ciudad;";
        sql [TEMPLETE]= "SELECT idtempletes, tDescripcion FROM templetes;";
        sql[PROMOCION] = "SELECT idpromociones, nombre FROM promociones;";
        sql[PAIS] = "SELECT idPais, pNombre FROM pais;";
        sql[CURSO] = "SELECT idcursos, cNombre FROM cursos;";
        sql[LUGAR] = "SELECT idlugar, lNombre FROM lugar;";
        sql[PRECIO] = "SELECT idprecios, precio FROM precios;";
        sql[DESTINATARIOS] = "SELECT iddestinatario, dNombre FROM destinatario;";
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
        
        String sql="select  e.idevento, c.nombre, cd.nombre, p.nombre, e.fechaInicio\n" +
                    "from eventos e, cursos c, ciudad cd, pais p, lugar l\n" +
                    "where e.cursos_idcursos=c.idcursos AND p.idPais=cd.p_idPais\n" +
                    "	AND l.ciudad_idCiudad=cd.idCiudad; AND e.idevento=?";
        try
        {
            Connection conection = database.getConnection();
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, idEvento);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                evento.setId(rs.getString(1));
                evento.setNombre(rs.getString(2));
                try
                {
                    String fecha = Convierte.fechaString(rs.getDate(3));
                    evento.setFecha(fecha);
                    String fechaTermino = Convierte.fechaString(rs.getDate(12));
                    evento.setFechaTermino(fechaTermino);
                }
                catch(SQLException e)
                {
                    evento.setFecha("0000-00-00");
                    evento.setFechaTermino("0000-00-00");
                }
                evento.setDescripcion(rs.getString(4));
                evento.setPrograma(rs.getString(5));
                evento.setLugar(rs.getString(6));
                evento.setNombreCiudad(rs.getString(7));
                evento.setNombrePais(rs.getString(8));
                evento.setCapacidad(rs.getInt(9));
                evento.setCosto(rs.getDouble(10));
                evento.setTipo(rs.getString(11));    
            }
            
        }catch(Exception ex)
        {
            BusinessException be = new BusinessException();
            be.setIdException("001");
            be.setMensaje("Error en la capa de base de datos");
            throw be;
        }
        return evento;
    }

    @Override
    public List<Ciudad> cargarCiudades(int idPais) throws BusinessException {
        
        String sql = "SELECT idCiudad, cNombre FROM ciudad WHERE p_idPais = ?;";
        List <Ciudad> listaCiudad= new ArrayList<>();
        try {
            Connection connection = database.getConnection();
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            ps.setInt(1, idPais);

            
            ResultSet rs= ps.executeQuery();
            
            while(rs.next())
            {
                Ciudad ciudad = new Ciudad();
                ciudad.setIdCiudad(rs.getInt(1));
                ciudad.setNombreCiudad(rs.getString(2));
                listaCiudad.add(ciudad);
            }
            
            ps.close();
            connection.close();
            return listaCiudad;
        } catch (Exception ex) {
            BusinessException be = new BusinessException();
            be.setIdException("0001");
            be.setMensaje("Error en la capa de base de datos");
            throw be;
        }
        
    }

    @Override
    public List<Lugar> cargarLugares(int idCiudad) throws BusinessException {
        
        String sql = "SELECT idlugar, lNombre FROM lugar WHERE c_idCiudad = ?;";
        List <Lugar> listaLugar= new ArrayList<>();
        try {
            Connection connection = database.getConnection();
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            ps.setInt(1, idCiudad);

            
            ResultSet rs= ps.executeQuery();
            
            while(rs.next())
            {
                Lugar lugar = new Lugar();
                lugar.setIdLugar(rs.getInt(1));
                lugar.setNombreLugar(rs.getString(2));
                listaLugar.add(lugar);
            }
            
            ps.close();
            connection.close();
            return listaLugar;
        } catch (Exception ex) {
            BusinessException be = new BusinessException();
            be.setIdException("0001");
            be.setMensaje("Error en la capa de base de datos");
            throw be;
        }
        
    }
}
