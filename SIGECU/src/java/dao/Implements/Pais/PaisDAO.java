/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implements.Pais;

import dao.Interface.IPais.IPaisDAO;
import dto.Pais;
import exception.BusinessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        
        String sql="INSERT INTO pais(nombre,region) values (?,?)";
        
        try {
             Connection conection = database.getConnection();
            PreparedStatement ps = conection.prepareStatement(sql);
            
            Pais pais= new Pais();
           ps.setInt(1, pais.getIdpais());
           ps.setString(2,pais.getNombrepais());
           ps.setString(3,pais.getRegion());
           
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
