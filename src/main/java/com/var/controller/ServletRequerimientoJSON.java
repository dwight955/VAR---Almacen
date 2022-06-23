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
import com.var.entidad.DetalleRequerimientos;
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
		String tipo = request.getParameter("accion");
		if(tipo.equals("BUSCAR")) 
			buscar(request,response);
		if(tipo.equals("BUSCARbyNUMDetalle")) 
			buscarPorNumeroDetalle(request,response);
		if(tipo.equals("BUSCARbyNumreq")) 
			buscarPorNumero(request,response);
		if(tipo.equals("CONSULTAR_JUFA"))
			consultarJUFA(request,response);
	}

	private void buscarPorNumero(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String numreq = request.getParameter("numreq");
		CuadroRequerimientos requerimiento = servicio.FindByNumreq(numreq);
		
		Gson gson = new Gson();
		String json = gson.toJson(requerimiento);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida = response.getWriter();
		salida.println(json);
	}

	private void consultarJUFA(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String soli, dest, estado, fecha, uni;
		int cant;
		soli = request.getParameter("soli");
		dest = request.getParameter("dest");
		estado = request.getParameter("estado");
		fecha = request.getParameter("fecha");
		uni = request.getParameter("uni");
		cant = Integer.parseInt(request.getParameter("cant"));
		
		cant = cant<0?cant=0:cant;
		estado = (estado.equals(""))?estado=null:estado;
		uni = (uni.equals(""))?uni=null:uni;
		fecha = (fecha.equals(""))?fecha=null:fecha;
		
		List<CuadroRequerimientos> data = servicio.consultarJUFA(dest, soli, fecha, estado, cant, uni, null);
		
		Gson gson = new Gson();
		String json = gson.toJson(data);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida = response.getWriter();
		salida.println(json);
	}

	private void buscarPorNumeroDetalle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String numreq = request.getParameter("numreq");
		List<DetalleRequerimientos> data = servicio.listarByNumReqDetalle(numreq);
		
		Gson gson = new Gson();
		String json = gson.toJson(data);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida = response.getWriter();
		salida.println(json);
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String dest, soli, numReq, estado;
		dest = request.getParameter("dest");
		soli = request.getParameter("nombreTrabajador");
		numReq = request.getParameter("numReq");
		estado = request.getParameter("estado");
		if(estado.equals("")) {estado = null;}
		if(numReq.equals("")) {numReq = null;}
		List<CuadroRequerimientos> data = servicio.consultarJUFA(dest, soli, null, estado, 0, null, numReq);
		
		Gson gson = new Gson();
		String json = gson.toJson(data);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida = response.getWriter();
		salida.println(json);
	}

}
