package com.var.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.var.dao.MySqlUsuarioDAO;
import com.var.entidad.Usuario;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MySqlUsuarioDAO usuarioDAO;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
        super();
        usuarioDAO = new MySqlUsuarioDAO();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("tipo");
		if(accion.equals("INICIAR")) {
			iniciarSesion(request,response);
		}
		
	}

	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username, clave;
		
		username = request.getParameter("username");
		clave = request.getParameter("clave");
		
		Usuario result = usuarioDAO.iniciarSesion(username, clave);
		
		if(result != null) {
			HttpSession session = request.getSession();
			session.setAttribute("dniUsuario", result.getDniUsu());
			session.setAttribute("nomUsuario", result.getNombre());
			session.setAttribute("apeUsuario", result.getApellido());
			session.setAttribute("cargo", result.getCargo());
			session.setAttribute("unidadOrganica", result.getNomUnidadOrganica());
			
			response.sendRedirect("dashboard.jsp"); 
		}else {
			request.setAttribute("msj","Usuario y/o Contraseña Incorrecta");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

}
