/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implements.Perfil;

import dao.Interface.Iperfil.IPerfilDAO;
import dto.Evento;
import dto.Usuario;
import dto.preInscripcion;
import exception.BusinessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConectionDB;

/**
 *
 * @author JorgeLuna
 */
public class PerfilDAO implements IPerfilDAO{
        private final ConectionDB database;

    public PerfilDAO() {
        this.database = new ConectionDB();
    }

        
    //metodo para consultar a la base de datos los datos del perfil
    public List<preInscripcion> listaDatosPerfil() throws BusinessException{
        List<preInscripcion> datosPerfil= new ArrayList<>();
        String sql = "SELECT a.idalumno,a.aNombre,a.aPaterno, a.aMaterno, a.telefono,"
                + "a.email,a.e_idEmpresa,a.carrera,u.userName,u.userPass,u.foto FROM alumno a, usuarios u"
                + " WHERE a.idalumno=1 AND u.idalumno=1";
        
        try {
            Connection conection = database.getConnection();
            PreparedStatement ps = conection.prepareStatement(sql);
           ResultSet result = ps.executeQuery();
            while(result.next())
            {
                preInscripcion Perfil = new preInscripcion();
                Perfil.setIdpreIns(result.getInt(1));
                Perfil.setNombre(result.getString(2));
                Perfil.setApellido(result.getString(3)+ " " +result.getString(4));
                Perfil.setTelefono(result.getString(6));
                Perfil.setEmail(result.getString(7));
                Perfil.setIdEmpresa(result.getInt(8));
                Perfil.setCarrera(result.getString(9));
                Usuario usu =new Usuario();
                
                Perfil.setFoto(result.getString(12));
                datosPerfil.add(Perfil);
            }
            conection.close();
            ps.close();
            return datosPerfil;
        } catch (Exception ex) {
             ex.printStackTrace();
            BusinessException be = new BusinessException();
            be.printStackTrace();
            be.setMensaje("Error en la capa de base de datos");
            be.setIdException("0001");
            throw be;
        }
    }
    
}
