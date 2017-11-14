package dao.Implements.PreInscripcion;

import dto.EventoVO;
import dao.Interface.IPreInscripciones.IPagoDAO;
import dto.Pago;
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
  
    
    @Override
    public List<Pago> listarPagoPendienteE() {
        List<Pago> pagoPendienteE = new ArrayList<>();
        try {
            
            
            String sql="SELECT e.idevento, e.nombre, e.descripcion, p.tipo, p.status, p.costo FROM eventos e, pago p "
                    + "WHERE p.status=2";
            
            Connection connection = database.getConnection();
            
            if(connection != null){
                
                try{
                    
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ResultSet result = ps.executeQuery();
                    pagoPendienteE= new LinkedList<Pago>();
                    while(result.next()){
                        Pago pago =new Pago();
                        EventoVO evento = new EventoVO();
                        
                        evento.setId_Evento(result.getInt(1));
                        evento.setNombre(result.getString(2));
                        evento.setDescripcion(result.getString(3));
                        pago.setTipo(result.getString(4));
                        pago.setStatus(result.getInt(5));
                    }
                    ps.close();
                    
                }catch(SQLException e){
                    setMensaje("Problemas para listar: "+e.getMessage());
                }finally{
                    try{
                        connection.close();
                    }catch(SQLException ex){
                        setMensaje(ex.getMessage());
                    }
                }
            }else{
                setMensaje("Error en conexion: "+database.getMessage());
            }
           
        } catch (Exception ex) {
            Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return pagoPendienteE;
    }
    
     public String getMensaje(){
    return mensaje;
}
     public void setMensaje(String mensaje){
    this.mensaje=mensaje;
}

    @Override
    public void registrarPago(Pago pago) {
        try {
            String sql ="INSERT INTO pago VALUES(NULL,?,?,?)";
            Connection cn=database.getConnection();
            if(cn !=null){
                try{
                    
                    PreparedStatement ps=cn.prepareStatement(sql);
                    ps.setString(1, pago.getTipo());
                    ps.setInt(2,pago.getStatus());
                    
                    int exc=ps.executeUpdate();
                    
                    if(exc==0){
                        throw new SQLException();
                    }
                    ps.close();
                }
                catch(SQLException e){
                    System.out.println(e.getMessage());
                    setMensaje("Problemas para insertar: "+ e.getMessage());
                    
                }finally{
                    try{
                        cn.close();
                    }catch(SQLException ex){
                        ex.printStackTrace();
                        System.out.println(ex.getMessage());
                        setMensaje(ex.getMessage());
                    }
                }
            }else{
                setMensaje("Error en la conexión: "+database.getMessage());
            }
        } catch (Exception ex) {
            Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   
    
    }
