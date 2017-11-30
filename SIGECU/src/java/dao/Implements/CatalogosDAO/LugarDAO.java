/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implements.CatalogosDAO;

import dao.Interface.ICatalogos.ILugarDAO;
import dto.Ciudad;
import dto.Lugar;
import exception.BusinessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConectionDB;

/**
 *
 * @author zoro
 */
public class LugarDAO implements ILugarDAO{
     private final ConectionDB database;
    public LugarDAO()
    {
        this.database = new ConectionDB();
    }

    @Override
    public List<Lugar> listarLugar() throws BusinessException {
        String sql = "select l.idlugar, l.c_idCiudad, l.lNombre, l.lDescripcion, c.cNombre\n" +
                "FROM lugar l, ciudad c\n" +
                "WHERE l.c_idCiudad=c.idCiudad;";
        List<Lugar> lugarLista = new ArrayList<>();
        
        try
        {
            Connection connection = database.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            
            while(result.next())
            {
                Lugar lugar = new Lugar();
                lugar.setIdLugar(result.getInt(1));
                lugar.setIdCiudad(result.getInt(2));
                lugar.setNombreLugar(result.getString(3));
                lugar.setDescripcionLugar(result.getString(4));
                lugar.setCiudadLugar(result.getString(5));
                
                lugarLista.add(lugar);
            }
            connection.close();
            ps.close();
            return lugarLista;
        }catch(Exception ex)
        {
            ex.printStackTrace();
            BusinessException be = new BusinessException();
            be.printStackTrace();
            be.setMensaje("Error en la capa de base de datos");
            be.setIdException("0001");
            throw be;
        }
    }

    @Override
    public void crearLugar(Lugar lugar) throws BusinessException {
        String sql="insert lugar (lNombre, lDescripcion, c_idCiudad)\n" +
                    "values(?,?, ?);";
         try
        {
            Connection conection = database.getConnection();
            PreparedStatement ps = conection.prepareStatement(sql);
            
            ps.setString(1, lugar.getNombreLugar());
            ps.setString(2, lugar.getDescripcionLugar());
            ps.setInt(3, lugar.getIdCiudad());
 
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
    public List<Ciudad> buscarCiudad() throws BusinessException {
        List<Ciudad> listaCiudad= new ArrayList<>();
        String sql ="select idCiudad, cNombre FROM ciudad;";
        try
        {
            Connection connection = database.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            
            while(result.next())
            {
                Ciudad ciudad = new Ciudad();
                ciudad.setIdCiudad(result.getInt(1));
                ciudad.setNombreCiudad(result.getString(2));
                listaCiudad.add(ciudad);
            }
            connection.close();
            ps.close();
            return listaCiudad;
        }catch(Exception ex)
        {
            ex.printStackTrace();
            BusinessException be = new BusinessException();
            be.printStackTrace();
            be.setMensaje("Error en la capa de base de datos");
            be.setIdException("0001");
            throw be;
        }
    }
    
}
