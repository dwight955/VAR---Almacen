package com.var.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.var.dao.MySqlBienesDAO;
import com.var.entidad.Bien;
import com.var.entidad.Proveedor;

/**
 * Servlet implementation class ServletBien
 */
@WebServlet("/ServletBien")
public class ServletBien extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MySqlBienesDAO bienesDAO;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBien() {
        super();
        bienesDAO = new MySqlBienesDAO();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("tipo");
		if(accion.equals("LISTAR")) {
			listarBienes(request, response);
		}
	}

	private void listarBienes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Bien> lista = bienesDAO.ListAll();
		//crear un atributo y guardar el valor de "lista"
		request.setAttribute("bienes", lista);
		//enviar atributo "docentes" a la página docente.jsp
		request.getRequestDispatcher("/Bienes.jsp").forward(request, response);
	}

}
