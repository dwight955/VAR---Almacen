package com.var.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.var.dao.MySqlCondicionDAO;
import com.var.entidad.Condicion;

/**
 * Servlet implementation class ServletCondicion
 */
@WebServlet("/ServletCondicionJSON")
public class ServletCondicionJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MySqlCondicionDAO condicionDAO;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCondicionJSON() {
        super();
        condicionDAO = new MySqlCondicionDAO();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String accion = request.getParameter("comboBox");
				if(accion.equals("CARGO")) {
					cargarCargos(request, response);
				}
				if(accion.equals("UO")) {
					cargarUO(request, response);
				}
	}

	private void cargarUO(HttpServletRequest request, HttpServletResponse response) throws IOException {
			List<Condicion> data = condicionDAO.listarUO(); 
			Gson gson=new Gson();
			String json = gson.toJson(data);
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter salida=response.getWriter();
			salida.println(json);
	}

	private void cargarCargos(HttpServletRequest request, HttpServletResponse response) throws IOException {
			List<Condicion> data = condicionDAO.listarCargo(); 
			Gson gson=new Gson();
			String json = gson.toJson(data);
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter salida=response.getWriter();
			salida.println(json);
	} 
}
