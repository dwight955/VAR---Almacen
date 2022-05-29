package com.var.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.var.dao.MySqlProveedorDAO;
import com.var.entidad.Proveedor;
import com.var.services.ProveedorService;

/**
 * Servlet implementation class ServletDocente
 */
@WebServlet("/ServletProveedor")
public class ServletProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //declarar objeto de la clase MySqlProveedorDAO
	private ProveedorService servicio;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProveedor() {
        super();
        servicio = new ProveedorService();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//tipo de acción que debe realizar el servlet
		String accion;
		//obtener la acción que viene de la página proveedores.jsp
		accion=request.getParameter("tipo");
		//validar accion
		if(accion.equals("LISTAR"))
			listarProveedores(request,response);
		else if(accion.equals("REGISTRAR"))
			registrarProveedor(request,response);
		else if(accion.equals("ELIMINAR"))
			eliminarProveedor(request,response);
		
	}

	private void eliminarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperar el código a eliminar
		String cod;
		cod=request.getParameter("codigoEliminar");
		//invocar al método deleteById y enviar la variable cod
		int salida;
		salida = servicio.eliminarPorId(Integer.parseInt(cod));
		//
		if(salida>0) {
			//crear atributo MENSAJE
			request.setAttribute("MENSAJE", "Proveedor eliminado...");
			//
			//request.getRequestDispatcher("/Proveedor.jsp").forward(request, response);
			listarProveedores(request,response);
		}
		else {
			//crear atributo MENSAJE
			request.setAttribute("MENSAJE", "Error en la eliminación...");
			//
			//request.getRequestDispatcher("/Proveedor.jsp").forward(request, response);
			listarProveedores(request,response);
		}
		
	}

	private void registrarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//variables
		String codProv,nroRuc,rzonSoc,estado,condic,direc,telf,codDis;
		//leer los controles del formulario que se encuentra en la página proveedores.jsp "usar el name de cada control"
		codProv=request.getParameter("codigo");
		nroRuc=request.getParameter("nroRuc");
		rzonSoc=request.getParameter("razonSocial");
		estado=request.getParameter("estado");
		condic=request.getParameter("condicion");
		direc=request.getParameter("direccion");
		telf=request.getParameter("telefono");
		codDis=request.getParameter("distrito");
		//crear un objeto de la clase Proveedor
		Proveedor bean=new Proveedor();
		//setear objeto con las variables
		bean.setNroRuc(nroRuc);
		bean.setRzSoc(rzonSoc);
		bean.setEstado(estado);
		bean.setCondic(condic);
		bean.setDirec(direc);
		bean.setTelf(telf);
		bean.setCodDis(codDis);
		//validar variable codigo proveedor (cambiar)
		if(Integer.parseInt(codProv)==0) {
			//invocar al mètodo save y enviar el objeto "bean"
			int salida;
			salida=servicio.registrar(bean);
			if(salida>0) {
				//crear atributo MENSAJE
				request.setAttribute("MENSAJE", "Proveedor registrado...");
				
				//request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
				listarProveedores(request,response);
			}
			else {
		//		//crear atributo MENSAJE
				request.setAttribute("MENSAJE", "Error en el registro...");
				
				//request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
				listarProveedores(request,response);
			}
		}
		else {
			//setear el atributo codigo
			bean.setCodProv(Integer.parseInt(codProv));
			//invocar al mètodo update y enviar el objeto "bean"
			int salida;
			salida=servicio.actualizar(bean);			
			if(salida>0) {
				//crear atributo MENSAJE
				request.setAttribute("MENSAJE", "Proveedor actualizado...");
				
				//request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
				listarProveedores(request,response);
			}
			else {
				//crear atributo MENSAJE
				request.setAttribute("MENSAJE", "Error en la actualización...");
				
				//request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
				listarProveedores(request,response);
			}
		}
		
	}

	private void listarProveedores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//invocar al método listAll
		List<Proveedor> lista=servicio.listarTodo();
		//crear un atributo y guardar el valor de "lista"
		request.setAttribute("proveedores", lista);
		//enviar atributo "docentes" a la página docente.jsp
		request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
	}

}




















