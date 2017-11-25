/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import extras.Convierte;
import dto.MensajesDTO;
import dto.curso;
import dto.instructor;
import exception.BusinessException;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.Implements.PreInscripcion.PreInscripcionService;
import service.Interface.IPreInscripcion.IPreInscripcionService;
import service.Interface.Instructor.IInstructorService;

/**
 *
 * @author alma
 */
@WebServlet({ "/crearInstructor", "/vistas/administrador/crearInstructor" })
public class ServletInstructor extends HttpServlet {
    private String direccionar=null;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String mensaje = null;
		
		
        IInstructorService service = new IInstructorService() {
            @Override
            public void crearInstructor(instructor instructor) throws BusinessException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public List<instructor> listarInstructor() throws BusinessException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public curso buscarInstructor(int idinstructor) throws BusinessException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String eliminarInstructor(int idinstructor) throws BusinessException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String getMensaje() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        switch (accion)
        {
            case "LI":
                DatosIns( service, request, response);
                break;	
            case "INS":
                nuevoInstructor(service,mensaje, request, response);
                break;	
            default:
                mensaje = "Accion no reconicida";
                break;
        }
		
	if (mensaje != null) {
            String msg = "<div class=\"col-md-5 col-md-offset-3\" style=\"text-align: center\">";
            msg += "<div class=\"alert alert-danger\">";
            msg += "<button class=\"close\" data-dismiss=\"alert\"><span>&times;</span></button>";
            msg += "<strong>Alerta!!</strong><br/>";
            msg += mensaje;
            msg += "</div></div>";
            request.setAttribute("mensaje", msg);
	}
	
	RequestDispatcher despachador = request.getRequestDispatcher(direccionar);
	despachador.forward(request, response);
    }

       /*Metodo para cargar los datos de los eventos necesarios para hacer el registro
     * de un nuevo evento, los datos cargados son ciudad, pais, instructor, templete
    * promociones*/
    private void DatosCur(IInstructorService InsService, HttpServletRequest request, HttpServletResponse response) {
        MensajesDTO msjDTO = new MensajesDTO();
        try {
            curso DatosIns = InsService.buscarInstructor(0);
            request.setAttribute("DatosIns", DatosIns);
            msjDTO.setId("000");
            msjDTO.setMensaje("Exceute OK");
            request.setAttribute("msj", msjDTO);
            //eventoService.crearEvento(evento);
        }catch(Exception e){
            e.printStackTrace();
            msjDTO.setId("301");
            msjDTO.setMensaje("Error en la llamada a recursos");
            request.setAttribute("msj", msjDTO);
        }
        finally{
            direccionar = "crearCurso.jsp";
        }
    }//cargarDatosEvento
    private String verificar(HttpServletRequest request, instructor ins) {
        
	String mensaje = "<ul>";
	Integer idinstructor = Convierte.aInteger(request.getParameter("idinstructor"));
	String iNombre = request.getParameter("iNombre");	        
	String iMaterno = request.getParameter("iMaterno");
	String iPaterno = request.getParameter("iPaterno");
        String carrera = request.getParameter("carrera");
        String especialidad = request.getParameter("especialidad");
        String iEmail = request.getParameter("iEmail");
        String iTelefono = request.getParameter("iTelefono");
        String iDireccion = request.getParameter("iDireccion");
	        
	if ((iNombre == null) || (iNombre.trim().length() == 0)) {
	    mensaje += "<li>Verifique que halla ingresado correctamente el nombre</li>";
	}
	if ((iMaterno == null) || (iMaterno.trim().length() == 0)) {
	    mensaje += "<li>Verifique que halla ingresado correctamente el apellido</li>";
	}
	if ((iPaterno == null) || (iPaterno.trim().length() == 0)) {
	    mensaje += "<li>Verifique que halla ingresado correctamente el telefono</li>";
	}
	if ((carrera == null) || (carrera.trim().length() == 0)) {
	    mensaje += "<li>Verifique que halla ingresado correctamente el email</li>";
	}
        if ((especialidad == null) || (especialidad.trim().length() == 0)) {
	    mensaje += "<li>Verifique que halla ingresado correctamente la carrera</li>";
	}
        if ((iEmail == null) || (iEmail.trim().length() == 0)) {
	    mensaje += "<li>Verifique que halla ingresado correctamente confirmado</li>";
	}
        if ((iTelefono == null) || (iTelefono.trim().length() == 0)) {
	    mensaje += "<li>Verifique que halla ingresado correctamente confirmado</li>";
	}
        if ((iDireccion == null) || (iDireccion.trim().length() == 0)) {
	    mensaje += "<li>Verifique que halla ingresado correctamente confirmado</li>";
	}
	ins.setIdinstructor(idinstructor);
	ins.setiNombre(iNombre);
	ins.setiMaterno(iMaterno);
	ins.setiPaterno(iPaterno);
        ins.setCarrera(carrera);
        ins.setEspecialidad(especialidad);
        ins.setiEmail(iEmail);
        ins.setiTelefono(iTelefono);
        ins.setiDireccion(iDireccion);
               
	if (mensaje.equals("<ul>")) {
	    mensaje = null;
	} else {
	    mensaje += "</ul>";
	}
	return mensaje;
    }

    private void nuevoInstructor(IInstructorService service, String mensaje, HttpServletRequest request, HttpServletResponse response) {
        MensajesDTO msjDTO = new MensajesDTO();
        instructor ins = new instructor();
        mensaje = verificar(request, ins);
        if (mensaje == null)
        {
            try {
                service.crearInstructor(ins);
                mensaje = service.getMensaje();
                if (mensaje != null)
                {
                    request.setAttribute("cur", ins);
                    direccionar = "crearInstructor.jsp";
                }
                else
                {
                    direccionar = "instructor?accion=CI";  
                }
            }catch(Exception e)
            {
                e.printStackTrace();
                msjDTO.setId("301");
                msjDTO.setMensaje("Error en la llamada de recursos");
                request.setAttribute("msj", msjDTO);
            }
        } 
        else 
        {
            request.setAttribute("inst", ins);
            direccionar = "curso?accion=CR";
        }
    }

    private void DatosIns(IInstructorService service, HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
