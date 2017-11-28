/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dto.Curso;
import dto.Especialidad;
import dto.MensajesDTO;
import exception.BusinessException;
import extras.Convierte;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.Implements.CatalogosService.CursoService;
import service.Interface.ICatalogosService.ICursoService;

/**
 *
 * @author zoro
 */
@WebServlet(name = "ServletCursoCatalogo", urlPatterns = {"/vistas/administrador/ServletCursoCatalogo"})
public class ServletCursoCatalogo extends HttpServlet {
    private String direccionar = null;
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException
    {
        try
        {
            ICursoService serviceCurso = new CursoService();
            String accion = request.getParameter("accion");
            
            switch(accion)
            {
                case "LC":
                    listarCursos(request, response, serviceCurso);
                    break;
                case "CC":
                    crearCurso(request, response, serviceCurso);
                    break;
                case "BE":
                    buscarEspecialidad(request, response, serviceCurso);
                default:break;
            }
        }catch(Exception e)
        {
            
        }
         RequestDispatcher despachador = request.getRequestDispatcher(direccionar);
            despachador.forward(request, response);
    }
    private void listarCursos(HttpServletRequest request, HttpServletResponse response, ICursoService cursoService )
    {
        MensajesDTO msjDTO = new MensajesDTO();
        try {
            List<Curso> listaCurso = cursoService.listarCursos();
            request.setAttribute("listaCurso", listaCurso); 
            /*msjDTO.setId("000");
            msjDTO.setMensaje("Ejecuxion OK");
            request.setAttribute("msj", msjDTO);*/
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
            direccionar = "ListarCursos.jsp";
        }
    }

    private void buscarEspecialidad(HttpServletRequest request, HttpServletResponse response, ICursoService serviceCurso) {
        MensajesDTO msjDTO = new MensajesDTO();
        try {
            List<Especialidad> listaEspecialidad = serviceCurso.buscarEspecialidad();
            request.setAttribute("especialidad", listaEspecialidad); 
            /*msjDTO.setId("000");
            msjDTO.setMensaje("Ejecuxion OK");
            request.setAttribute("msj", msjDTO);*/
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
            direccionar = "CrearCurso.jsp";
        }
    }

    /*Crear un curso nuevo*/
    private void crearCurso(HttpServletRequest request, HttpServletResponse response, ICursoService serviceCurso) {
        MensajesDTO msjDTO = new MensajesDTO();
        try {
            
            Curso curso = new Curso();
            curso.setNombre(request.getParameter("nombre"));
            curso.setDescripcion(request.getParameter("descripcion"));
            curso.setIdEspecialidad(Convierte.aInteger(request.getParameter("idEspecialidad")));
            serviceCurso.crearCurso(curso);
            /*msjDTO.setId("000");
            msjDTO.setMensaje("Ejecuxion OK");
            request.setAttribute("msj", msjDTO);*/
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
            direccionar = "ServletCursoCatalogo?accion=LC";
        }
    }

}
