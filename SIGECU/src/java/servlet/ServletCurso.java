/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import extras.Convierte;
import dto.MensajesDTO;
import dto.Curso;
import dto.Instructor;
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
import service.Interface.Curso.ICursoService;
import service.Interface.IPreInscripcion.IPreInscripcionService;

/**
 *
 * @author alma
 */
@WebServlet({ "/crearCurso", "/vistas/administrador/crearCurso" })
public class ServletCurso extends HttpServlet {
    private String direccionar=null;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String mensaje = null;
		
		
        ICursoService service = new ICursoService() {
            @Override
            public void crearCurso(Curso curso) throws BusinessException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public List<Curso> listarEventoConfirmado() throws BusinessException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Curso buscarCurso(int idCurso) throws BusinessException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String eliminarCurso(int idcurso) throws BusinessException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Curso detallesCurso(int idCurso) throws BusinessException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public List<Curso> listarCursos() throws BusinessException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String getMensaje() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void crearInstructor(Instructor ins) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        switch (accion)
        {
            case "LC":
                DatosCur( service, request, response);
                break;	
            case "INS":
                nuevoCurso(service,mensaje, request, response);
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
    private void DatosCur(ICursoService curInsService, HttpServletRequest request, HttpServletResponse response) {
        MensajesDTO msjDTO = new MensajesDTO();
        try {
            Curso DatosCur = curInsService.buscarCurso(0);
            request.setAttribute("DatosCur", DatosCur);
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
    private String verificar(HttpServletRequest request, Curso cur) {
        
	String mensaje = "<ul>";
	Integer idcurso = Convierte.aInteger(request.getParameter("id_curso"));
	String nombre = request.getParameter("nombre");	        
	String horario = request.getParameter("horario");
	String fechaInicio = request.getParameter("fechaInicio");
        String fechaFin = request.getParameter("fechaFin");
        String tipo = request.getParameter("tipo");
        String i_idinstructor = request.getParameter("i_idinstructor");
	        
	if ((nombre == null) || (nombre.trim().length() == 0)) {
	    mensaje += "<li>Verifique que halla ingresado correctamente el nombre</li>";
	}
	if ((horario == null) || (horario.trim().length() == 0)) {
	    mensaje += "<li>Verifique que halla ingresado correctamente el apellido</li>";
	}
	if ((fechaInicio == null) || (fechaInicio.trim().length() == 0)) {
	    mensaje += "<li>Verifique que halla ingresado correctamente el telefono</li>";
	}
	if ((fechaFin == null) || (fechaFin.trim().length() == 0)) {
	    mensaje += "<li>Verifique que halla ingresado correctamente el email</li>";
	}
        if ((tipo == null) || (tipo.trim().length() == 0)) {
	    mensaje += "<li>Verifique que halla ingresado correctamente la carrera</li>";
	}
        if ((i_idinstructor == null) || (i_idinstructor.trim().length() == 0)) {
	    mensaje += "<li>Verifique que halla ingresado correctamente confirmado</li>";
	}       
	cur.setIdcurso(idcurso);
	cur.setNombrecur(nombre);
	cur.setHorario(horario);
	cur.setFechaInicio(fechaInicio);
        cur.setFechaFin(fechaFin);
        cur.setTipo(tipo);
        cur.setI_idinstructor(i_idinstructor);
               
	if (mensaje.equals("<ul>")) {
	    mensaje = null;
	} else {
	    mensaje += "</ul>";
	}
	return mensaje;
    }

    private void nuevoCurso(ICursoService service, String mensaje, HttpServletRequest request, HttpServletResponse response) {
        MensajesDTO msjDTO = new MensajesDTO();
        Curso cur = new Curso();
        mensaje = verificar(request, cur);
        if (mensaje == null)
        {
            try {
                service.crearCurso(cur);
                mensaje = service.getMensaje();
                if (mensaje != null)
                {
                    request.setAttribute("cur", cur);
                    direccionar = "crearCurso.jsp";
                }
                else
                {
                    direccionar = "curso?accion=CR";  
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
            request.setAttribute("cur", cur);
            direccionar = "curso?accion=CR";
        }
    }

}
