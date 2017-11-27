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
     //Método para mortrar el nombre del alumno y del evento al momento de realizar el pago
      @Override
   public List<Pago> mostrarDatos() {
        List<Pago> mostrar=new ArrayList<>();
     Pago pago=new Pago();
       String sql="Select a.Nombre, c.nombre from alumno as a inner join alumno_has_cursos as ac\n" +
       "on a.idalumno=ac.a_idalumno inner join cursos as c on ac.c_idcursos=c.idcursos\n" +
       "inner join cursos_has_pagos as cp on c.idcursos=cp.c_idcursos\n" +
       "inner join pagos as p on cp.p_idpagos=p.idpagos where p.idpagos= "+pago.getIdPago()+";";
       try{
           Connection connection=database.getConnection();
           PreparedStatement ps=connection.prepareStatement(sql);
           ResultSet result=ps.executeQuery();
           while(result.next()){
               Alumno a=new Alumno();
               Curso c=new Curso();
               a.setNombre(result.getString(1));
               c.setNombre(result.getString(2));               
           }mostrar.add(pago);
                   
       }catch (Exception e){
         e.printStackTrace();
            BusinessException be = new BusinessException();
            be.setMensaje("Error al conectar en la base de datos");
            be.setIdException("1");
    }
       return mostrar;
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
        String sql="SELECT c.cNombre, pre.precio, p.pCantidad,p.pFecha\n" +
                    "FROM eventos e, cursos c, pagos p, historialPagos hp, alumno_has_eventos ae, precios pre,\n" +
                    "	eventos_precios_destinatarios epd, alumno a\n" +
                    "WHERE e.cursos_idcursos=c.idcursos AND pre.idprecios=epd.p_idprecios AND epd.e_idevento=e.idevento\n" +
                    "	AND ae.e_idevento=e.idevento AND ae.a_idalumno=?;";
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
                  String fecha= Convierte.fechaString(result.getDate(3));
                  pago.setFechaPago(fecha);
              }
              catch(SQLException e){
                 pago.setFechaPago("0000-00-00");
              }
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
    @Override
    public void tarjetaCredito(Tarjeta tarjeta){
       
     String sql= "INSERT INTO tarjeta(numero_tarjeta, "
             + "titular_tarjeta, fecha_expiracion, codigo_seguridad) values(?,?,?,?);";
     try{
         Connection conection= database.getConnection();
         PreparedStatement ps=conection.prepareStatement(sql);
         ps.setInt(1,tarjeta.getNumeroTarjeta());
         ps.setString(2, tarjeta.getTitularTarjeta());
         ps.setString(3,tarjeta.getFechaExpiracion());
         ps.setInt(4,tarjeta.getCodigo());
         
         int exec =ps.executeUpdate();
         ps.close();
         conection.close();    
     } catch (Exception e){
         e.printStackTrace();
            BusinessException be = new BusinessException();
            be.setMensaje("Error al conectar en la base de datos");
            be.setIdException("1");
          
    }

        
    }
    public void cheque(Cheque cheque){
       
     String sql= "INSERT INTO cheque(numero_seguridad, cantidad) values(?,?);";
     try{
         Connection conection= database.getConnection();
         PreparedStatement ps=conection.prepareStatement(sql);
         
         ps.setInt(1,cheque.getNumeroSeguridad());
         ps.setInt(4,cheque.getCantidad());
         
         int exec =ps.executeUpdate();
         ps.close();
         conection.close();    
     } catch (Exception e){
         e.printStackTrace();
            BusinessException be = new BusinessException();
            be.setMensaje("Error al conectar en la base de datos");
            be.setIdException("1");
          
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
    }


   
   
   
   