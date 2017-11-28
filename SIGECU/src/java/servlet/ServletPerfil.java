/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;


import dto.Evento;
import dto.MensajesDTO;
import exception.BusinessException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.Implements.Evento.EventoService;
import service.Interface.Evento.IEventoService;
import dao.Interface.Iperfil.IPerfilDAO;
import dto.Alumno;
import dto.Perfil;
import dto.Usuario;
import service.Implements.Perfil.PerfilService;
import service.Interface.Perfil.IPerfilService;

/**
 *
 * @author JorgeLuna
 */

@WebServlet( name="/Perfil", urlPatterns ={"/vistas/administrador/Perfil" })
public class ServletPerfil extends HttpServlet{
    private String direccionar = null;
    @Override
    protected void service (HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException
    {
        try {
            String accion = request.getParameter("accion");
            
            
            IPerfilService perfil = new PerfilService();
            
            switch(accion)
            {
                // LISTAR DATOS PERFIL
                case "LDP":
                    listarDatosPerfil(perfil , request, response);
                    break;
                    //CREAR EVENTOS 
               case "MP":
                   modificarPerfil(perfil , request, response);
                   break;
                    //todos los alumnos registrados
                   case "TA":
                    listarAlumnosRegistrados(perfil , request, response);
                   break;
                   //INSERTAR ALUMNOS
                    case "IA":
                    insertarAlumnos(perfil , request, response);
                   break;
                default:
                   
                 
                    break;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher despachador = request.getRequestDispatcher(direccionar);
            despachador.forward(request, response);
    } //fin del metodo service
    
    
    //metodo para listar los datos  del perfil
    private void listarDatosPerfil(IPerfilService perfil, HttpServletRequest request, HttpServletResponse response) 
    {
       MensajesDTO msjDTO = new MensajesDTO();
        try {
            List<Perfil> listaDatosPer = perfil.listaDatosPerfil();
            request.setAttribute("datosPerfil", listaDatosPer); 
            msjDTO.setId("000");
            msjDTO.setMensaje("Ejecuxion OK");
            request.setAttribute("msj", msjDTO);
        } catch (BusinessException ex) {
            msjDTO.setId(ex.getIdException());
            msjDTO.setMensaje(ex.getMensaje());
            request.setAttribute("msj", msjDTO);
        }catch(Exception e)
        {
            e.printStackTrace();
            msjDTO.setId("301");
            msjDTO.setMensaje("Error en la llamada de recursos");
            request.setAttribute("msj", msjDTO);
        }
        finally{
            direccionar = "perfilInteresado.jsp";
        }
    }//fin del metodo listarEventosConfiemdos

    private void modificarPerfil(IPerfilService perfil, HttpServletRequest request, HttpServletResponse response) {
    
        
         MensajesDTO msjDTO = new MensajesDTO();
        Perfil per = new Perfil();
        Usuario usu = new Usuario();
        try {
            per.setNombreper(request.getParameter("nombrep"));
            per.setApellidop(request.getParameter("apellidop"));
            per.setApellidom(request.getParameter("apellidom"));
            per.setTelefono(request.getParameter("tel"));
            per.setEmail(request.getParameter("email"));
            per.setCarrera(request.getParameter("carrera"));
            per.setIdEmpresa(1);
            
            perfil.modificarPerfil(per);
              msjDTO.setId("000");
            msjDTO.setMensaje("Se ha encontrado el evento");
            request.setAttribute("msj", msjDTO);
        
        }catch(BusinessException ex)
        {
            msjDTO.setId(ex.getIdException());
            msjDTO.setMensaje(ex.getMensaje());
            request.setAttribute("mensajeCrear", msjDTO);
        }catch(Exception e){
            e.printStackTrace();
            msjDTO.setId("301");
            msjDTO.setMensaje("Error en la llamada a recursos");
            request.setAttribute("mensajeCrear", msjDTO);
        }
        direccionar = "Perfil?accion=TA";
    }// fin del metodo actualizarEventoConfirmado

    private void listarAlumnosRegistrados(IPerfilService perfil, HttpServletRequest request, HttpServletResponse response) {
 MensajesDTO msjDTO = new MensajesDTO();
        try {
            List<Alumno> listarAlumnosRegistrdaos = perfil.alumnosInscritos();
            request.setAttribute("datosAlumnos", listarAlumnosRegistrdaos); 
            msjDTO.setId("000");
            msjDTO.setMensaje("Ejecuxion OK");
            request.setAttribute("msj", msjDTO);
        } catch (BusinessException ex) {
            msjDTO.setId(ex.getIdException());
            msjDTO.setMensaje(ex.getMensaje());
            request.setAttribute("msj", msjDTO);
        }catch(Exception e)
        {
            e.printStackTrace();
            msjDTO.setId("301");
            msjDTO.setMensaje("Error en la llamada de recursos");
            request.setAttribute("msj", msjDTO);
        }
        finally{
            direccionar = "perfilInteresado.jsp";
        }    }

    private void insertarAlumnos(IPerfilService perfil, HttpServletRequest request, HttpServletResponse response) {

         MensajesDTO msjDTO = new MensajesDTO();
         Alumno alu=new Alumno();
         
         try {
            alu.setNombre(request.getParameter("nombre"));
            alu.setaParterno(request.getParameter("apellidop"));
            alu.setaMaterno(request.getParameter("apellidop"));
            alu.setTelefono(request.getParameter("telefonoa"));
            alu.setEmail(request.getParameter("emaila"));
            alu.setCarrera(request.getParameter("acarrera"));
            alu.setNotbook(request.getParameter("notbook"));
            
            perfil.insertarAlumnos(alu);
         msjDTO.setId("000");
            msjDTO.setMensaje("Se ha encontrado el evento");
            request.setAttribute("msj", msjDTO);
        
        }catch(BusinessException ex)
        {
            msjDTO.setId(ex.getIdException());
            msjDTO.setMensaje(ex.getMensaje());
            request.setAttribute("mensajeCrear", msjDTO);
        }catch(Exception e){
            e.printStackTrace();
            msjDTO.setId("301");
            msjDTO.setMensaje("Error en la llamada a recursos");
            request.setAttribute("mensajeCrear", msjDTO);
        }
        direccionar = "Perfil?accion=TA";
    
    }
    
    
 
}
