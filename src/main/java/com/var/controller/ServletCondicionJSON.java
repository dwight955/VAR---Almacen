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
import com.var.entidad.Condicion;
import com.var.services.BienService;
import com.var.services.ProveedorService;
import com.var.services.TrabajadorService;

/**
 * Servlet implementation class ServletCondicion
 */
@WebServlet("/ServletCondicionJSON")
public class ServletCondicionJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCondicionJSON() {
        super();
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
				if(accion.equals("CATEGORIAS")) {
					cargarCategorias(request, response);
				}
				if(accion.equals("DISTRITOS")) {
					cargarDistritos(request, response);
				}
	}

	private void cargarDistritos(HttpServletRequest request, HttpServletResponse response) throws IOException {
			List<Condicion> data = new ProveedorService().listCondition("tb_distrito"); 
			Gson gson=new Gson();
			String json = gson.toJson(data);
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter salida=response.getWriter();
			salida.println(json);
	}

	private void cargarCategorias(HttpServletRequest request, HttpServletResponse response) throws IOException {
			List<Condicion> data = new BienService().listCondition("tb_categorias"); 
			Gson gson=new Gson();
			String json = gson.toJson(data);
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter salida=response.getWriter();
			salida.println(json);
	}

	private void cargarUO(HttpServletRequest request, HttpServletResponse response) throws IOException {
			List<Condicion> data = new TrabajadorService().listCondition("tb_unidadorganica"); 
			Gson gson=new Gson();
			String json = gson.toJson(data);
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter salida=response.getWriter();
			salida.println(json);
	}

	private void cargarCargos(HttpServletRequest request, HttpServletResponse response) throws IOException {
			List<Condicion> data = new TrabajadorService().listCondition("tb_cargos"); 
			Gson gson=new Gson();
			String json = gson.toJson(data);
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter salida=response.getWriter();
			salida.println(json);
	} 
}
