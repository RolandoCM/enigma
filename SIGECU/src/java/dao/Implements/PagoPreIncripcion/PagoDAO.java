package dao.Implements.PagoPreIncripcion;

import dto.EventoVO;
import dao.Interface.PagoPreInscripcion.IPagoDAO;
import dto.Alumno;
import dto.Cheque;
import dto.Curso;
import dto.Evento;
import dto.Pago;
import dto.Tarjeta;
import exception.BusinessException;
import extras.Convierte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.ConectionDB;

/**
 *
 * @author Anayeli Ramírez
 */
public class PagoDAO implements IPagoDAO{
    private final ConectionDB database;
    private String mensaje;
    
    public PagoDAO(){
        this.database=new ConectionDB();
        
        
    }
  /*Registro de un pago */
    @Override
    public void registrarPago(Pago pago){
     String pagosSQL = "insert into pagos(tP_idtipoPago, pCantidad, pFecha, pStatus, hP_idhistorialPagos) \n" +
                     "values(?,?,?,?,?);";
     try{
         Connection conection= database.getConnection();
         PreparedStatement ps=conection.prepareStatement(pagosSQL);
       
         ps.setInt(1, pago.getIdTipoPago());
         ps.setDouble(2, pago.getMonto());
         ps.setString(3, pago.getFechaPago());
         ps.setInt(4, pago.getStatus());
         ps.setInt(5, pago.getIdHistorial());
         
         ps.executeUpdate();
         ps.close();
         conection.close();    
     } catch (Exception e){
         e.printStackTrace();
            BusinessException be = new BusinessException();
            be.setMensaje("Error al conectar en la base de datos");
            be.setIdException("1");
          
    }

        
    }

   /*Metodo para mostrar todos los pagos que a realizado un alumno*/
    @Override
    public List<Pago> historialPagos(int idAlumno) throws BusinessException{
        List<Pago> historial=new ArrayList<>();
        String sql="SELECT c.cNombre, pre.precio, p.pCantidad,p.pFecha, tp.tpNombre\n" +
            "FROM eventos e, cursos c, pagos p, historialPagos hp, alumno_has_eventos ae, precios pre,\n" +
            "eventos_precios_destinatarios epd, alumno a, tipoPago tp\n" +
            "WHERE e.cursos_idcursos=c.idcursos AND pre.idprecios=epd.p_idprecios AND epd.e_idevento=e.idevento\n" +
            "	AND ae.e_idevento=e.idevento AND hp.idhistorialPagos=p.hP_idhistorialPagos AND hp.ahe_a_idalumno=ae.a_idalumno\n" +
            "    AND hp.ahe_e_idevento=ae.e_idevento AND tp.idtipoPago=p.tP_idtipoPago\n" +
            "    AND ae.a_idalumno=?;";
        try{
          Connection connection=database.getConnection();
          PreparedStatement ps=connection.prepareStatement(sql);
          ps.setInt(1, idAlumno);
          ResultSet result=ps.executeQuery();
          while(result.next()){
              Pago pago=new Pago();
              Evento evento=new Evento();
              
              pago.setQuePago(result.getString(1));
              pago.setPrecio(result.getDouble(2));
              pago.setMonto(result.getDouble(3));   
              try{
                  String fecha= Convierte.fechaString(result.getDate(4));
                  pago.setFechaPago(fecha);
              }
              catch(SQLException e){
                 pago.setFechaPago("0000-00-00");
              }
              pago.setTipo(result.getString(5));
              historial.add(pago);
          }
          connection.close();
          ps.close();
          return historial;
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
    
    /*Buscamos el id del tipo de pago de acuerdo al nombre del tipo de pago 
    * para hecer el registro de pago*/
    @Override
    public Pago tipoPago(Pago pago) throws BusinessException{
        String tipo ="select distinct tp.idtipoPago\n" +
            "FROM tipoPago tp, pagos p\n" +
            "WHERE p.tP_idtipoPago=tp.idtipoPago AND tp.tpNombre=?;";
        try
        {
            Connection cn = database.getConnection();
            PreparedStatement ps = cn.prepareStatement(tipo);
            ps.setString(1, pago.getTipo());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                pago.setIdTipoPago(rs.getInt(1));
            }
            ps.close();
            cn.close();
            return pago;
        }catch(Exception e)
        {
            e.printStackTrace();
            BusinessException be = new BusinessException();
            be.setMensaje("error en la capa de base de datos");
            be.setIdException("001");
            throw be;
        }
    }
    /*Buscamos el id de historial de pagos para saber que pago corresponde a que 
    * historial de pagos*/
    @Override
    public Pago buscarIdHistorialPago(Pago pago) throws BusinessException {
        String tipo ="select idhistorialPagos\n" +
                        "from historialPagos\n" +
                        "where ahe_a_idalumno=? AND ahe_e_idevento=?;";
        try
        {
            Connection cn = database.getConnection();
            PreparedStatement ps = cn.prepareStatement(tipo);
            ps.setInt(1, pago.getIdUsuario());
            ps.setInt(2, pago.getIdEvento());
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                pago.setIdHistorial(rs.getInt(1));
            }
            ps.close();
            cn.close();
            return pago;
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
    public Pago buscarIdUsuario(Pago pago) throws BusinessException {
        String sql = "Select a.idalumno, a.aNombre, a.aPaterno, a.aMaterno, a.aEmail, a.aTelefono\n" +
                        "from alumno a, users u\n" +
                        "where a.u_idusers=u.idusers AND u.username=?";
        
        try
        {
            Connection cn = database.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, pago.getQuienPago());
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                pago.setIdUsuario(rs.getInt(1));
                pago.setNombreAlumno(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
            }
            ps.close();
            cn.close();
            return pago;
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
    public List<Pago> seguimientoPagos(int idEvento) throws BusinessException {
         String sql = "SELECT hp.idhistorialPagos, c.cNombre, pre.precio, e.eFechaInicio, a.aNombre, tp.tpNombre, a.idalumno\n"+
                    "FROM eventos e, cursos c, pagos p, historialPagos hp, alumno_has_eventos ae, precios pre,\n" +
                    "	eventos_precios_destinatarios epd, alumno a, tipoPago tp\n" +
                    "WHERE e.cursos_idcursos=c.idcursos AND pre.idprecios=epd.p_idprecios AND epd.e_idevento=e.idevento\n" +
                    "	AND ae.e_idevento=e.idevento AND ae.a_idalumno=a.idalumno AND hp.idhistorialPagos=p.hP_idhistorialPagos\n" +
                    "    AND ae.a_idalumno=hp.ahe_a_idalumno AND hp.ahe_e_idevento=ae.e_idevento AND tp.idtipoPago=p.tP_idtipoPago\n" +
                    "    AND hp.pagoCompleto='0' AND e.idevento=?\n" +
                    "GROUP BY  hp.idhistorialPagos, c.cNombre, pre.precio, p.pCantidad,e.eFechaInicio, a.aNombre, tp.tpNombre, a.idalumno;";
        try
        {
            List<Pago> pagosPendientes =new ArrayList<>();
            Connection cn = database.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, idEvento);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Pago pago = new Pago();
                pago.setIdHistorial(rs.getInt(1));
                pago.setQuePago(rs.getString(2));
                pago.setPrecio(rs.getDouble(3));
                try{
                  String fecha= Convierte.fechaString(rs.getDate(4));
                  pago.setFechaPago(fecha);
                }
                catch(SQLException e){
                   pago.setFechaPago("0000-00-00");
                }
                pago.setNombreAlumno(rs.getString(5));
                pago.setFormaPago(rs.getString(6));
                pago.setIdUsuario(rs.getInt(7));
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

    @Override
    public List<Evento> cargarEvento() throws BusinessException {
        String sql = "select e.idevento, c.cNombre  from eventos e, cursos c \n" +
                        "where e.cursos_idcursos=c.idcursos;";
        List<Evento> listaEventos = new ArrayList<>();
        try
        {
            Connection cn = database.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Evento event = new Evento();
                event.setId(rs.getString(1));
                event.setNombre(rs.getString(2));
                listaEventos.add(event);
                
                
            }
            ps.close();
            cn.close();
            return listaEventos;
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
    public List<Pago> seguimientoPagos() throws BusinessException {
        String sql = "SELECT hp.idhistorialPagos, c.cNombre, pre.precio, e.eFechaInicio, a.aNombre, tp.tpNombre, a.idalumno\n"+
                    "FROM eventos e, cursos c, pagos p, historialPagos hp, alumno_has_eventos ae, precios pre,\n" +
                    "	eventos_precios_destinatarios epd, alumno a, tipoPago tp\n" +
                    "WHERE e.cursos_idcursos=c.idcursos AND pre.idprecios=epd.p_idprecios AND epd.e_idevento=e.idevento\n" +
                    "	AND ae.e_idevento=e.idevento AND ae.a_idalumno=a.idalumno AND hp.idhistorialPagos=p.hP_idhistorialPagos\n" +
                    "    AND ae.a_idalumno=hp.ahe_a_idalumno AND hp.ahe_e_idevento=ae.e_idevento AND tp.idtipoPago=p.tP_idtipoPago\n" +
                    "    AND hp.pagoCompleto='0' " +
                    "GROUP BY  hp.idhistorialPagos, c.cNombre, pre.precio, p.pCantidad,e.eFechaInicio, a.aNombre, tp.tpNombre, a.idalumno;";
        try
        {
            List<Pago> pagosPendientes =new ArrayList<>();
            Connection cn = database.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Pago pago = new Pago();
                pago.setIdHistorial(rs.getInt(1));
                pago.setQuePago(rs.getString(2));
                pago.setPrecio(rs.getDouble(3));
                try{
                  String fecha= Convierte.fechaString(rs.getDate(4));
                  pago.setFechaPago(fecha);
                }
                catch(SQLException e){
                   pago.setFechaPago("0000-00-00");
                }
                pago.setNombreAlumno(rs.getString(5));
                pago.setFormaPago(rs.getString(6));
                pago.setIdUsuario(rs.getInt(7));
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

    @Override
    public boolean confirmarPago(int idhistorial) throws BusinessException {
        boolean confirmado= false;
        String sql = "update historialPagos set pagoCompleto=1 WHERE idhistorialPagos=?;";
        
        try{
         Connection conection= database.getConnection();
         PreparedStatement ps=conection.prepareStatement(sql);
         ps.setInt(1, idhistorial);
         ps.executeUpdate();
         confirmado=true;
         ps.close();
         conection.close();    
     } catch (Exception e){
         e.printStackTrace();
            BusinessException be = new BusinessException();
            be.setMensaje("Error al conectar en la base de datos");
            be.setIdException("1");
          
    }
        return confirmado;
    }

    @Override
    public String correo(int idUsuario) throws BusinessException {
        try
        {
            String correo="";
            String sql = "select aEmail from alumno where idalumno=?;";
            Connection cn = database.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                correo = rs.getString(1);
                
                
            }
            ps.close();
            cn.close();
            return correo;
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


   
   
   
   