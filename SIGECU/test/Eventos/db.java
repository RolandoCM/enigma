/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import dto.Evento;
import extras.Convierte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConectionDB;

/**
 *
 * @author rolando
 */
public class db {
    public static void main (String [] args ) throws Exception
    {
        ConectionDB database = new ConectionDB();
        database.getConnection();
        
        List<Evento> eventosConfirmados= new ArrayList<>();
        String sql="SELECT e.idevento, e.nombre, c.nombre, p.nombre, e.fechaInicio FROM eventos e, ciudad c,"
                + "pais p WHERE c.idCiudad = e.c_idCiudad AND p.idPais=c.p_idPais ";
               // + "AND e.estatus IS NOT NULL;";
            Connection connection = database.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while(result.next())
            {
                try
                {
                    System.out.print(Convierte.fechaString(result.getDate(5)));
                }catch(SQLException e)
                {
                    System.out.print("Nada");
                }
                
            }
            connection.close();
            ps.close();
    }
    
}
