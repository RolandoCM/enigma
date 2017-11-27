/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dto.Instructor;
import dto.MensajesDTO;
import dto.Usuario;
import exception.BusinessException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.Implements.Instructor.InstructorService;
import service.Interface.Instructor.IInstructorServiceb;

/**
 *
 * @author JorgeLuna
 */
@WebServlet({"/Instructor","/vistas/administrador/Instructor"})
public class ServletInstructorb extends HttpServlet {
private String direccionar = null;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
            String accion = request.getParameter("accion");
            
            
            IInstructorServiceb instructor = new InstructorService();
            
            switch(accion)
            {
                // INSERTAR iNSTRUCTOR
                case "II":
                    insertarInstructor(instructor , request, response);
                    break;
                    //CREAR EVENTOS 
//               case "MP":
//                   modificarPerfil(perfil , request, response);
//                   break;
//                   case "CA":
//                   EventosPorAlumno(perfil , request, response);
//                   break;
                default:
                    break;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher despachador = request.getRequestDispatcher(direccionar);
            despachador.forward(request, response);
    } //fin del metodo service

    private void insertarInstructor(IInstructorServiceb instructor, HttpServletRequest request, HttpServletResponse response) {
       
         MensajesDTO msjDTO = new MensajesDTO();
        Instructor ins = new Instructor();
        Usuario usu = new Usuario();
        try {
            ins.setNombre(request.getParameter("inombre"));
            ins.setPaterno(request.getParameter("iPaterno"));
            ins.setMaterno(request.getParameter("iMaterno"));
            ins.setCarrera(request.getParameter("carrera"));
            ins.setEspecialidad(request.getParameter("especialidad"));
            ins.setEmail(request.getParameter("iEmail"));
            ins.setTelefono(request.getParameter("iTelefono"));
            ins.setDireccion(request.getParameter("iDireccion"));
            
            instructor.nuevoInstructor(ins);
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
        direccionar = "CrearInstructor.jsp";
    }
    
}





    

    


