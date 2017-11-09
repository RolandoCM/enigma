/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Implements.Evento;

import dao.Implements.Evento.preInsDAO;
import dao.Interface.Evento.IPreInscripcionDAO;
import dto.identiPreIns;
import dto.preInscripcion;
import exception.BusinessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.ConectionDB;
import service.Interface.Evento.servPreInscr;

/**
 *
 * @author Anel
 */
public class PreInscripcionService implements servPreInscr {

    private String mensaje;
    private final ConectionDB db;
    
    public PreInscripcionService(){
        this.db = new ConectionDB();
    }
    @Override
    public List<preInscripcion> preQry() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    @Override
    public void alumnosIns(preInscripcion preIn) {
        String sql = "INSERT INTO pre_inscripcion VALUES(null,?,?,?,?,?,?,?)";
		
		Connection cn = null;
        try {
            cn = db.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(PreInscripcionService.class.getName()).log(Level.SEVERE, null, ex);
        }
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(sql);
				
				ps.setString(1, preIn.getNombre());
				ps.setString(2, preIn.getApellido());
                                ps.setString(3, preIn.getTelefono());
                                ps.setString(4, preIn.getEmail());
                                ps.setString(5, preIn.getIdEmpresa().toString());
				ps.setString(6, preIn.getCarrera());
				ps.setString(7, preIn.getConfirmar());
                                
				int exec = ps.executeUpdate();
				
				if (exec == 0) {
					throw new SQLException();
				}
				ps.close();
				
			} catch (SQLException e) {
                            e.printStackTrace();
                            System.out.println(e.getMessage());
				setMensaje("Problemas para insertar: " + e.getMessage());
			} finally {
				try {
					cn .close();
				} catch (SQLException ex) {
                                    ex.printStackTrace();
                                    System.out.println(ex.getMessage());
					setMensaje(ex.getMessage());
				}
			}
		} else {
			setMensaje("Error en conexion: " + db.getMessage());
		}
    }

    @Override
    public String getMensaje() {
		return mensaje;
	}

    public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	} 
    
    @Override
    public List<identiPreIns> consulPre() throws BusinessException {
        List<identiPreIns> empresaPreIns;
        
        IPreInscripcionDAO preIns = new preInsDAO();
        empresaPreIns = preIns.consultaPreIns();
        
        return empresaPreIns;
    }
    
}
