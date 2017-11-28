/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;


import dto.Instructor;
import dto.MensajesDTO;
import exception.BusinessException;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.Interface.ICatalogosService.IInstructorService;
import service.Implements.CatalogosService.InstructorService;

/**
 *
 * @author alma
 */
@WebServlet(name = "ServletInstructorCatalogo", urlPatterns = {"/vistas/administrador/ServletInstructorCatalogo"})
public class ServletInstructorCatalogo extends HttpServlet {
    private String direccionar=null;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        try
        {
            IInstructorService iService = new InstructorService();
            switch(accion)
            {
                case "LI":
                    listarInstructor(request, response, iService);
                    break;
                case "CI":
                    crearInstructor(request, response, iService);
                    break;
                default:
                    break;
                    
            }
        }catch(Exception e){
            
        }
        RequestDispatcher despachador = request.getRequestDispatcher(direccionar);
            despachador.forward(request, response);
    }

    private void listarInstructor(HttpServletRequest request, HttpServletResponse response, IInstructorService iService) {
        MensajesDTO msjDTO = new MensajesDTO();
        try {
            List<Instructor> instructor = iService.listarInstructor();
            request.setAttribute("listaInstructor", instructor); 
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
            direccionar = "ListarInstructores.jsp";
        }
    }

    private void crearInstructor(HttpServletRequest request, HttpServletResponse response, IInstructorService iService) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
