/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implements.Perfil;

import dao.Interface.Iperfil.IPerfilDAO;
import dto.Evento;
import dto.Perfil;
import dto.Usuario;

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
        @Override
    public List<Perfil> listaDatosPerfil() throws BusinessException{
        List<Perfil> datosPerfil= new ArrayList<>();
        String sql = "SELECT a.idalumno,a.aNombre,a.aPaterno, a.aMaterno, a.telefono,"
                + "a.email,a.e_idEmpresa,a.carrera,u.unombre,u.password,u.foto FROM alumno a, users u"
                + " WHERE a.idalumno=1 AND u.idalumno=1";
        
        
        try {
            Connection conection = database.getConnection();
            PreparedStatement ps = conection.prepareStatement(sql);
           ResultSet result = ps.executeQuery();
            while(result.next())
            {
                Perfil Perfill = new Perfil();
                Perfill.setIdper(result.getInt(1));
                Perfill.setNombreper(result.getString(2));
                Perfill.setApellidop(result.getString(3));
                Perfill.setApellidom(result.getString(4));
                Perfill.setTelefono(result.getString(5));
                Perfill.setEmail(result.getString(6));
                Perfill.setIdEmpresa(result.getInt(7));
                Perfill.setCarrera(result.getString(8));
                Usuario usu =new Usuario();
                Perfill.setNombre(result.getString(9));
                Perfill.setPass(result.getString(10));
                Perfill.setFoto(result.getString(11));
                datosPerfil.add(Perfill);
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
    
     public void modificarPerfil(Perfil per) throws BusinessException{
         String sql = "UPDATE alumno SET aNombre=?,"
                 + "aPaterno=?,aMaterno=?,telefono=?,"
                 + "email=?,e_idEmpresa=?,carrera=?"
                 + " WHERE idalumno=?";
        
        try
        {
            Connection conection = database.getConnection();
            PreparedStatement ps = conection.prepareStatement(sql);
            
            ps.setString(1, per.getNombreper());
            ps.setString(2, per.getApellidop());
            ps.setString(3, per.getApellidom());
            ps.setString(4, per.getTelefono());
            ps.setString(5, per.getEmail());
            ps.setInt(6, per.getIdEmpresa());
            ps.setString(7, per.getCarrera());
            ps.setInt(8, 1);
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
    
    
}
