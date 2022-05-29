package com.var.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.var.dao.MySqlTrabajadorDAO;
import com.var.entidad.Trabajador;
import com.var.services.TrabajadorService;

/**
 * Servlet implementation class ServletDocente
 */
@WebServlet("/ServletTrabajador")
public class ServletTrabajador extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //declarar objeto de la clase MySqlDocenteDAO
	private TrabajadorService servicio;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTrabajador() {
        super();
        //crear
        servicio=new TrabajadorService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//tipo de acción que debe realizar el servlet
		String accion;
		//obtener la acción que viene de la página Trabajadores.jsp
		accion=request.getParameter("tipo");
		//validar accion
		if(accion.equals("LISTAR"))
			listarTrabajadores(request,response);
		else if(accion.equals("REGISTRAR"))
			registrarTrabajador(request,response);
		else if(accion.equals("ELIMINAR"))
			eliminarTrabajador(request,response);	
		else if(accion.equals("BUSCAR"))
			buscarTrabajador(request,response);	
		
	}

	

	private void eliminarTrabajador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperar el código a eliminar
		String cod;
		cod=request.getParameter("codigoEliminar");
		//invocar al método deleteById y enviar la variable cod
		int salida;
		salida=servicio.eliminarPorId(Integer.parseInt(cod));
		//
		if(salida>0) {
			//crear atributo MENSAJE
			request.setAttribute("MENSAJE", "Trabajador eliminado...");
			
			//request.getRequestDispatcher("/Trabajadores.jsp").forward(request, response);
			listarTrabajadores(request,response);
		}
		else {
			//crear atributo MENSAJE
			request.setAttribute("MENSAJE", "Este trabajador esta en uso...");
			
			//request.getRequestDispatcher("/Trabajadores.jsp").forward(request, response);
			listarTrabajadores(request,response);
		}
		
	}

	private void registrarTrabajador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//variables
		String codigo,dni,nombrecom,cargo,sexo,unidadorg;
		//leer los controles del formulario que se encuentra en la página Trabajador.jsp "usar el name de cada control"
		codigo=request.getParameter("codigo");
		dni=request.getParameter("dni");
		nombrecom=request.getParameter("nombrecom");
		cargo=request.getParameter("cargo");
		sexo=request.getParameter("sexo");
		unidadorg=request.getParameter("coduo");
		//crear un objeto de la clase Docente
		Trabajador bean=new Trabajador();
		//setear objeto con las variables
		bean.setDni(dni);
		bean.setNomApe(nombrecom);
		bean.setCargo(cargo);
		bean.setSexo(sexo);
		bean.setCodUnidadOrga(unidadorg);
		//validar variable codigo
		if(Integer.parseInt(codigo)==0) {
			//invocar al mètodo save y enviar el objeto "bean"
			int salida;
			salida=servicio.registrar(bean);
			if(salida>0) {
				//crear atributo MENSAJE
				request.setAttribute("MENSAJE", "Trabajador registrado...");
				//
				//request.getRequestDispatcher("/Trabajadores.jsp").forward(request, response);
				listarTrabajadores(request,response);
			}
			else {
				//crear atributo MENSAJE
				request.setAttribute("MENSAJE", "Error en el registro...");
				//
				//request.getRequestDispatcher("/Trabajadores.jsp").forward(request, response);
				listarTrabajadores(request,response);
			}
		}
		else {
			bean.setCodTrab(Integer.parseInt(codigo));
			int salida;
			salida=servicio.actualizar(bean);			
			if(salida>0) {
				request.setAttribute("MENSAJE", "Trabajador actualizado...");
				listarTrabajadores(request,response);
			}
			else {
				request.setAttribute("MENSAJE", "Error en la actualización...");
				listarTrabajadores(request,response);
			}
		}
		
	}

	private void buscarTrabajador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod =request.getParameter("codigo");
		List<Trabajador>lista=(List<Trabajador>) servicio.buscarPorId(Integer.parseInt(cod));
		request.setAttribute("trabajadores", lista);
		request.getRequestDispatcher("/Trabajadores.jsp").forward(request, response);
	}
	
	private void listarTrabajadores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Trabajador> lista=servicio.listarTodo();
		request.setAttribute("trabajadores", lista);
		request.getRequestDispatcher("/Trabajadores.jsp").forward(request, response);
	}

}




















