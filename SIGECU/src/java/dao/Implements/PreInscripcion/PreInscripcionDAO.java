/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implements.PreInscripcion;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import dao.Interface.IPreInscripciones.IPreInscripcionDAO;
import dto.PreInscripcionEvento;
import exception.BusinessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.ConectionDB;
/**
 *
 * @author Anel * @author Anel
 */
public class PreInscripcionDAO implements IPreInscripcionDAO {
    
    private final ConectionDB db;
	private String mensaje;
	
	public PreInscripcionDAO() {
		this.db = new ConectionDB();
	}
        
    /**
     *
     * @param preInscripcion
     * @param preIn
     * @return
     * @throws exception.BusinessException
     */
        
    @Override
    public boolean nuevaPreInscripcion (PreInscripcionEvento preInscripcion) throws BusinessException{
        boolean correcto = false;
        String sql = "insert into alumno_has_eventos (a_idalumno, e_idevento, confirmado,activo)\n" +
                        "values(?,?,?,?);";
	Connection cn = null;
        try
        {
            cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, preInscripcion.getIdUsuario());
            ps.setString(2, preInscripcion.getIdEvento());
            ps.setString(3,preInscripcion.getConfirmadoPago());
            ps.setString(4, preInscripcion.getActivoInscrito());
            
            int exec=0;
            try
            {
               exec = ps.executeUpdate();
               correcto = true;
            }catch(Exception e)
            {
                correcto=false;
            }
            
            
            ps.close();
            
        }catch (Exception e)
        {
            e.printStackTrace();
            BusinessException be = new BusinessException();
            be.setMensaje("error en la capa de base de datos");
            be.setIdException("001");
            throw be;
        }
        return correcto;
    }

    @Override
    public PreInscripcionEvento datosPreInscripcion(PreInscripcionEvento preInscripcion) throws BusinessException {
        String sql = "Select a.idalumno, a.aNombre, a.aPaterno, a.aMaterno, a.aEmail, a.aTelefono\n" +
                        "from alumno a, users u\n" +
                        "where a.u_idusers=u.idusers AND u.username=?";
        
        try
        {
            Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, preInscripcion.getUsuario());
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                preInscripcion.setIdUsuario(rs.getString(1));
                preInscripcion.setNombreAlumno(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
            }
            return preInscripcion;
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
    public void generarHistorialDePagos(PreInscripcionEvento preInscripcion) throws BusinessException {
        String sql = "insert into historialPagos (ahe_a_idalumno, ahe_e_idevento, pagoCompleto) "
                + "values(?,?,'0');";
	Connection cn = null;
        try
        {
            cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, preInscripcion.getIdUsuario());
            ps.setString(2, preInscripcion.getIdEvento());
				
            int exec = ps.executeUpdate();
		
            if (exec == 0) {
		throw new SQLException();
            }
            ps.close();
            
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




