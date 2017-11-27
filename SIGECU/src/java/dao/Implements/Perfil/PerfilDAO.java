/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implements.Perfil;

import dao.Interface.Iperfil.IPerfilDAO;
import dto.Alumno;
import dto.Curso;
import dto.Evento;
import dto.Instructor;
import dto.Perfil;
import dto.Usuario;

import exception.BusinessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.AbstractList;
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
        String sql = "SELECT a.idalumno,a.aNombre,a.aPaterno, a.aMaterno, a.aTelefono,"
                + "a.aEmail,a.e_idEmpresa,a.aCarrera,u.nombre,u.password,u.imagen FROM alumno a, users u"
                + " WHERE a.u_idusers=2 AND u.idusers=2";
        
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
    
        @Override
     public void modificarPerfil(Perfil per) throws BusinessException{
         String sql = "UPDATE alumno SET aNombre=?,"
                 + "aPaterno=?,aMaterno=?,aTelefono=?,"
                 + "aEmail=?,e_idEmpresa=?,aCarrera=?"
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
    
     
       
        @Override
        public List<Evento> EventosPorAlumno() throws BusinessException{ 
    
    List<Evento> eventosalum =new ArrayList<>();
    List<Instructor> instru = new ArrayList<>();
    List<Curso> curss= new ArrayList<>();
    List<Alumno> alumm=new ArrayList<>();
    String sql="SELECT a.idalumno,e.idevento,e.cursos_idcursos,e.i_idinstructor,e.eDescripcion,e.eFechaInicio,e.eFechaTermino,e.ePrograma,e.eHorario,e.lugar_idlugar,e.t_idtempletes,e.eCapacidad,e.eTipo,(SELECT cNombre FROM cursos WHERE idcursos=e.idevento),i.iNombre,i.iPaterno,i.iMaterno,t.tDescripcion,(SELECT lNombre FROM lugar WHERE idlugar=e.lugar_idlugar),ci.cNombre FROM alumno a,eventos e,cursos c,alumno_has_eventos ah,instructor i,templetes t,lugar l,ciudad ci WHERE a.idalumno=1 AND ah.a_idalumno=ah.e_idevento AND ah.confirmado='1' GROUP BY e.idevento";
    
//     String sql2 ="SELECT a.idalumno,e.idevento,e.cursos_idcursos,"
//             + "e.i_idinstructor,e.eDescripcion, e.eFechaInicio,"
//             + "e.eFechaTermino,e.ePrograma,e.eHorario,"
//             + " e.lugar_idlugar,e.t_idtempletes,e.eCapacidad,"
//             + "e.eTipo,c.cNombre, i.iNombre,i.iPaterno,"
//             + "i.iMaterno,t.tDescripcion,l.lNombre,ci.cNombre, ah.confirmado "
//             + "FROM alumno a,eventos e,cursos"
//             + " c,alumno_has_eventos ah,instructor "
//             + "i,templetes t,lugar l,ciudad ci "
//             + "WHERE a.idalumno=1 AND ah.a_idalumno=ah.e_idevento AND ah.confirmado=1 GROUP BY a.idalumno";
//       
    try {
         Connection conection = database.getConnection();
            PreparedStatement ps = conection.prepareStatement(sql);
           ResultSet result = ps.executeQuery();
            while(result.next()){
                Evento eve=new Evento();
                Alumno al =new Alumno();
                Curso cu=new Curso();
                Instructor in=new Instructor();
                Instructor in1=new Instructor();
                al.setIdAlumno(result.getInt(1));
                eve.setAlumno(al);
                eve.setId(result.getString(2));
                cu.setIdcurso(result.getInt(3));
                in.setIdinstructor(result.getInt(4));
                eve.setInstructor(in);
                eve.setDescripcion(result.getString(5));
                eve.setFecha(result.getString(6));
                eve.setFechaTermino(result.getString(7));
                eve.setPrograma(result.getString(8));
                eve.setHorario(result.getString(9));
                eve.setCapacidad(result.getInt(12));
                eve.setTipo(result.getString(13));
                cu.setNombrecur(result.getString(14));
                eve.setNombre(result.getString(14));
                in1.setiNombre(result.getString(15)+" "+result.getString(16)+" "+result.getString(17));
                eve.setInstructor(in1);
                eve.setTemplete(result.getString(18));
                eve.setLugar(result.getString(19));
                eve.setCiudad(result.getString(20));
                eventosalum.add(eve); 
                
            }
       conection.close();
            ps.close();
            return eventosalum;
        } catch (Exception ex) {
             ex.printStackTrace();
            BusinessException be = new BusinessException();
            be.printStackTrace();
            be.setMensaje("Error en la capa de base de datos");
            be.setIdException("0001");
            throw be;
        }
}
//termina el metodo de mostrar eventos por alumno

}
