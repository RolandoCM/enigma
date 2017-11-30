/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dto.Alumno;
import dto.MensajesDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.Implements.Pais.PaisService;
import service.Interface.IPais.IPaisService;

/**
 *
 * @author Dell
 */
@WebServlet( name="/Pais", urlPatterns ={"/vistas/administrador/Pais" })
public class ServletPais extends HttpServlet {

     private String direccionar = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String accion = request.getParameter("accion");
            
            
            IPaisService pais = new PaisService();
            
            switch(accion)
            {
                // INSERTAR PAIS
                case "LDP":
                    insertarPais(pais , request, response);
                    break;
                    //CREAR EVENTOS 
               case "MP":
                  // modificarPerfil(perfil , request, response);
                   break;
                    //todos los alumnos registrados
                   case "TA":
                   // listarAlumnosRegistrados(perfil , request, response);
                   break;
                   //INSERTAR ALUMNOS
                    case "IA":
                   // insertarAlumnos(perfil , request, response);
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

    private void insertarPais(IPaisService pais, HttpServletRequest request, HttpServletResponse response) {
        MensajesDTO msjDTO = new MensajesDTO();
        Alumno alu = new Alumno();
         
        

    }
    
        
    }


