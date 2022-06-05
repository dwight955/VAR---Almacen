package com.var.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.var.entidad.Bien;
import com.var.services.BienService;

/**
 * Servlet implementation class ServletBienJSON
 */
@WebServlet("/ServletBienJSON")
public class ServletBienJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BienService servicio;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBienJSON() {
        super();
        servicio = new BienService();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		Bien data = servicio.buscarPorId(Integer.parseInt(codigo));
		
		Gson gson=new Gson();
		String json = gson.toJson(data);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

}
