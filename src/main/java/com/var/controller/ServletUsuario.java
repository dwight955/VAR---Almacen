package com.var.controller;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.var.dao.MySqlUsuarioDAO;
import com.var.entidad.Usuario;
import com.var.services.UsuarioService;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioService servicio;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
        super();
        servicio = new UsuarioService();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("tipo");
		if(accion.equals("INICIAR")) 
			iniciarSesion(request,response);
		else if(accion.equals("CERRAR")) 			
			cerrarSesion(request,response);	
	}

	private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.invalidate();
		request.setAttribute("MENSAJE", "Sesión cerrada correctamente");
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username, clave;
		
		username = request.getParameter("username");
		clave = request.getParameter("clave");
		System.out.println(username + " " + clave);
		
		Usuario result = servicio.SignIn(username, clave);
		
		if(result != null) {
			HttpSession session = request.getSession();
			session.setAttribute("dniUsuario", result.getDniUsu());
			session.setAttribute("nomUsuario", result.getNombre());
			session.setAttribute("apeUsuario", result.getApellido());
			session.setAttribute("cargo", result.getCargo());
			session.setAttribute("unidadOrganica", result.getNomUnidadOrganica());
			
			request.getSession().setAttribute("CODIGO", result.getCodUsuario());
			request.getSession().setAttribute("DATOS", result.getNombre()+" "+result.getApellido());
			request.getSession().setAttribute("UNIDAD_ORGANICA", result.getNomUnidadOrganica());
			
			response.sendRedirect("dashboard.jsp"); 
		}else {
			request.setAttribute("MENSAJE","Usuario y/o Contraseña Incorrecta");			
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			
		}
	}

}
