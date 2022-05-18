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
import com.var.dao.MySqlTrabajadorDAO;
import com.var.entidad.Condicion;
import com.var.entidad.Trabajador;

/**
 * Servlet implementation class ServletTrabajadorJSON
 */
@WebServlet("/ServletTrabajadorJSON")
public class ServletTrabajadorJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MySqlTrabajadorDAO trabajadorDAO;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTrabajadorJSON() {
        super();
        trabajadorDAO = new MySqlTrabajadorDAO();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		Trabajador data = trabajadorDAO.findById(Integer.parseInt(codigo)); 
		
		Gson gson=new Gson();
		String json = gson.toJson(data);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

}
