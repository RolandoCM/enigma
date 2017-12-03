/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dto.Ciudad;
import dto.MensajesDTO;
import dto.Pais;
import exception.BusinessException;
import extras.Convierte;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
     @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String accion = request.getParameter("accion");
            
            
            IPaisService pais = new PaisService();
            
            switch(accion)
            {
                // INSERTAR PAIS
                case "IP":
                    insertarPais(pais , request, response);
                    break;
                    //Pagina ciudad.jsp
                case "CP":
                    listarPaises(pais , request, response);
                     
                     listarCiudades(pais, request,response);
                     direccionar = "ciudad.jsp";
                    break;
                    //Insertar la ciudad
                case "IC":
                    insertarCiudad(pais,request,response);
                    break;
                    //CREAR EVENTOS 

                    //modificar los paises
               case "MP":
                 modificarPais(pais , request, response);
                   break;
//                    //todos los alumnos registrados
//                   case "TA":
//                   // listarAlumnosRegistrados(perfil , request, response);
//                   break;
                   //INSERTAR ALUMNOS
                   // case "IA":
                   // insertarAlumnos(perfil , request, response);
//    Modificar la ciudad
               case "MC":
                   modificarCiudad(pais , request, response);
                   break;
                    //todos los paises registrados
                   case "TP":
                    listarPaises(pais , request, response);
 direccionar = "pais.jsp";
                   break;
//                   //INSERTAR ALUMNOS
//                    case "IA":
//                    insertarAlumnos(perfil , request, response);
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

    private void insertarPais(IPaisService pais, HttpServletRequest request, HttpServletResponse response) {
        MensajesDTO msjDTO = new MensajesDTO();
        Pais pa= new Pais();
        try {
            pa.setNombrepais(request.getParameter("nombrepais"));
            pa.setRegion(request.getParameter("region"));
            pais.insertar(pa);
          msjDTO.setId("000");
            msjDTO.setMensaje("Se ha encontrado el pais");
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
        direccionar = "Pais?accion=TP";  
    }

    private void listarPaises(IPaisService pais, HttpServletRequest request, HttpServletResponse response) {

         MensajesDTO msjDTO = new MensajesDTO();
        try {
            List<Pais> listaPais = pais.listarPaises();
            request.setAttribute("datosPais", listaPais); 
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
           
        }
    }

    private void insertarCiudad(IPaisService pais, HttpServletRequest request, HttpServletResponse response) {
         MensajesDTO msjDTO = new MensajesDTO();
         Ciudad ci = new Ciudad();
         try {
            ci.setNombreCiudad(request.getParameter("nombreciudad"));
            ci.setIdpais(Convierte.aInteger(request.getParameter("idPais")));
            pais.insertarCiudad(ci);
         msjDTO.setId("000");
            msjDTO.setMensaje("Se ha encontrado el pais");
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
        direccionar = "Pais?accion=CP";  
    }

    private void listarCiudades(IPaisService pais, HttpServletRequest request, HttpServletResponse response) {

        MensajesDTO msjDTO = new MensajesDTO();
        try {
            List<Ciudad> listaCiudad = pais.listarCiudades();
            request.setAttribute("ciudades", listaCiudad);
            msjDTO.setId("000");
            msjDTO.setMensaje("Ejecucion OK");
            request.setAttribute("msj", msjDTO);
        } catch (BusinessException ex) {
            ex.printStackTrace();
            msjDTO.setId("301");
            msjDTO.setMensaje("Error en la llamada de recursos");
            request.setAttribute("msj", msjDTO);
        }
        finally{
            
        }
    }

    private void modificarPais(IPaisService pais, HttpServletRequest request, HttpServletResponse response) {

        MensajesDTO msjDTO = new MensajesDTO();
        Pais paiss= new Pais();
        try {
            paiss.setIdpais(Convierte.aInteger(request.getParameter("idpais")));
            paiss.setNombrepais(request.getParameter("nombrep"));
            paiss.setRegion(request.getParameter("region"));
            pais.modificarPais(paiss);
           msjDTO.setId("000");
            msjDTO.setMensaje("Se ha encontrado el pais");
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
        direccionar = "Pais?accion=TP"; 
    }

    private void modificarCiudad(IPaisService pais, HttpServletRequest request, HttpServletResponse response) {
         MensajesDTO msjDTO = new MensajesDTO();
         Ciudad ci =new Ciudad();
         try {
            ci.setIdCiudad(Convierte.aInteger(request.getParameter("idciudad")));
            ci.setNombreCiudad(request.getParameter("nombreCiudad"));
            ci.setIdpais(Convierte.aInteger(request.getParameter("idPais")));
            pais.modificarCiudad(ci);
        msjDTO.setId("000");
            msjDTO.setMensaje("Se ha encontrado el pais");
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
        direccionar = "Pais?accion=CP"; 
    }
    
        
    }


