/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.Interface.Iperfil.IPerfil;
import dto.Evento;
import dto.MensajesDTO;
import dto.preInscripcion;
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

/**
 *
 * @author JorgeLuna
 */

@WebServlet({ "/Perfil", "/vistas/administrador/Perfil" })
public class ServletPerfil extends HttpServlet{
    private String direccionar = null;
    @Override
    protected void service (HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException
    {
        try {
            String accion = request.getParameter("accion");
            
            
            IPerfil perfil new = 
            
            switch(accion)
            {
                // LISTAR DATOS PERFIL
                case "LDP":
                    listarDatosPerfil(perfil , request, response);
                    break;
                    //CREAR EVENTOS 
               
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
    private void listarDatosPerfil(IPerfil perfil, HttpServletRequest request, HttpServletResponse response) 
    {
       MensajesDTO msjDTO = new MensajesDTO();
        try {
            List<preInscripcion> listaDatosPer = perfil.listaDatosPerfil();
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
    
    
}
