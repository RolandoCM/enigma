/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implements.PreInscripcion;

import dao.Interface.IPreInscripciones.IPreInscripcionDAO;
import dto.identiPreIns;
import dto.preInscripcion;
import exception.BusinessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
     * @param preIn
     * @return
     * @throws exception.BusinessException
     */
    @Override
    public boolean nuevaPreInscripcion (preInscripcion preIn) throws BusinessException{
        boolean correcto = false;
        String sql = "INSERT INTO pre_inscripcion VALUES(null,?,?,?,?,?,?,?)";
	Connection cn = null;
        try
        {
            cn = db.getConnection();
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
            else
            {
                correcto = true;
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

       /*Metodo para generar los datos necesarios de rellono automatico en crear evento*/

    /**
     *
     * @return
     * @throws BusinessException
     */

    @Override
    public List<identiPreIns> consultaPreIns() throws BusinessException {
        List<identiPreIns> listaDatos= new ArrayList<>();
        String EMPRESA= "SELECT idEmpresa, nombre FROM empresa";
        try
        {
            Connection conn = db.getConnection();
            PreparedStatement ps;
           
                ps = conn.prepareStatement(EMPRESA);
                ResultSet result = ps.executeQuery();
                
                
                while(result.next())
                {
                    identiPreIns idPre = new identiPreIns();
                    idPre.setId(result.getString(1));
                    idPre.setNombre(result.getString(2));
                    listaDatos.add(idPre);
                }   
        }catch(Exception e)
        {
            BusinessException be = new BusinessException();
            be.setIdException("001");
            be.setMensaje("Error en la base de datos");
            throw be;
        }
        
        return listaDatos;
    } //fin de metodo consultatDatosCrearEvento
    
   
	public String getMensaje() {
		return mensaje;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}    

    public List<preInscripcion> preQry() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

}




