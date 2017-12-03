/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implements.Pais;

import dao.Interface.IPais.IPaisDAO;
import dto.Ciudad;
import dto.Pais;
import exception.BusinessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConectionDB;

/**
 *
 * @author Dell
 */
public class PaisDAO implements IPaisDAO{
    private final ConectionDB database;

    public PaisDAO() {
        this.database = new ConectionDB();
    }
    
    @Override
    public void insertar(Pais pa) throws  BusinessException{
        
        String sql="INSERT INTO pais(pNombre,pRegion) values (?,?)";
        
        try {
             Connection conection = database.getConnection();
            PreparedStatement ps = conection.prepareStatement(sql);
            
            
          
           ps.setString(1,pa.getNombrepais());
           ps.setString(2,pa.getRegion());
           
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
    public List<Pais> listarPaises() throws BusinessException{
        
        List<Pais> listarPais =new ArrayList<>();
        
        String sql="SELECT idPais, pNombre'UTF8', pRegion FROM pais";
         try {
            Connection conection = database.getConnection();
            PreparedStatement ps = conection.prepareStatement(sql);
           ResultSet result = ps.executeQuery();
            while(result.next())
            {
                Pais p=new Pais();
                p.setIdpais(result.getInt(1));
                p.setNombrepais(result.getString(2));
                p.setRegion(result.getString(3));
                listarPais.add(p);
                
            }
            conection.close();
            ps.close();
            return listarPais;
    } catch (Exception ex) {
             ex.printStackTrace();
            BusinessException be = new BusinessException();
            be.printStackTrace();
            be.setMensaje("Error en la capa de base de datos");
            be.setIdException("0001");
            throw be;
        }
    }
    
    
    @Override
     public void modificarPais(Pais pa) throws BusinessException{
         String sql = "UPDATE pais SET pNombre=?,pRegion=? WHERE idPais=?";
        
        try
        {
            Connection conection = database.getConnection();
            PreparedStatement ps = conection.prepareStatement(sql);
            
            ps.setString(1, pa.getNombrepais());
            ps.setString(2, pa.getRegion());
            ps.setInt(3, pa.getIdpais());
           
            
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
    public void insertarCiudad(Ciudad ci) throws  BusinessException{
        
        String sql="INSERT INTO ciudad(cNombre, p_idPais) values (?,?)";
        
        try {
             Connection conection = database.getConnection();
            PreparedStatement ps = conection.prepareStatement(sql);
            
           ps.setString(1,ci.getNombreCiudad());
           ps.setInt(2,ci.getIdpais());
           
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
    public List<Ciudad> listarCiudades() throws BusinessException{
        
        List<Ciudad> listarPais =new ArrayList<>();
        
        String sql="SELECT c.idCiudad, c.cNombre, c.p_idPais,p.idPais,p.pNombre FROM ciudad c ,pais p GROUP BY c.idCiudad ";
         try {
            Connection conection = database.getConnection();
            PreparedStatement ps = conection.prepareStatement(sql);
           ResultSet result = ps.executeQuery();
            while(result.next())
            {
                Ciudad p=new Ciudad();
                p.setIdCiudad(result.getInt(1));
                p.setNombreCiudad(result.getString(2));
                p.setIdpais(result.getInt(4));
                p.setNombrepais(result.getString(5));
               
                listarPais.add(p);
                
            }
            conection.close();
            ps.close();
            return listarPais;
    } catch (Exception ex) {
             ex.printStackTrace();
            BusinessException be = new BusinessException();
            be.printStackTrace();
            be.setMensaje("Error en la capa de base de datos");
            be.setIdException("0001");
            throw be;
        }
    }
    
    public void modificarCiudad(Ciudad ciu) throws BusinessException{
        String sql="UPDATE ciudad SET cNombre=?,p_idPais=? WHERE idCiudad=?";
        try {
            Connection conection = database.getConnection();
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setString(1, ciu.getNombreCiudad());
            ps.setInt(2, ciu.getIdpais());
            ps.setInt(3, ciu.getIdCiudad());
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
