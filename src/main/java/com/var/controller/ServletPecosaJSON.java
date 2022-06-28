package com.var.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.var.entidad.Pecosa;
import com.var.services.PecosaService;

/**
 * Servlet implementation class ServletPecosaJSON
 */
@WebServlet("/ServletPecosaJSON")
public class ServletPecosaJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PecosaService servicio;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPecosaJSON() {
        super();
        servicio = new PecosaService();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("accion");
		if(tipo.equals("CORRELATIVO"))
			correlativo(request,response);
		if(tipo.equals("BUSCARbyNum"))
			buscarByNum(request,response);
	}

	private void buscarByNum(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String numPec = request.getParameter("numpec");
		Pecosa pecosa = servicio.buscarNumPecosa(numPec);
		Gson gson=new Gson();
		String json = gson.toJson(pecosa);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void correlativo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String codeCorrelative = servicio.codeCorrelative();
		Gson gson=new Gson();
		String json = gson.toJson(codeCorrelative);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

}
