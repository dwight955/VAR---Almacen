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
import com.var.entidad.CuadroRequerimientos;
import com.var.services.RequerimientoService;

/**
 * Servlet implementation class ServletRequerimientoJSON
 */
@WebServlet("/ServletRequerimientoJSON")
public class ServletRequerimientoJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequerimientoService servicio;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRequerimientoJSON() {
        super();
        servicio = new RequerimientoService();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dest, soli, numReq, estado;
		dest = request.getParameter("dest");
		soli = request.getParameter("nombreTrabajador");
		numReq = request.getParameter("numReq");
		estado = request.getParameter("estado");
		if(numReq.equals("")) {numReq = null;}
		System.out.println(dest);
		System.out.println(soli);
		System.out.println(numReq);
		System.out.println(estado);
		List<CuadroRequerimientos> data = servicio.consultarJUFA(dest, soli, null, estado, 0, null, numReq);
		
		Gson gson = new Gson();
		String json = gson.toJson(data);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida = response.getWriter();
		salida.println(json);
	}

}
