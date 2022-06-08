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
import com.var.services.TrabajadorService;

/**
 * Servlet implementation class ServletTrabajadorJSON
 */
@WebServlet("/ServletTrabajadorJSON")
public class ServletTrabajadorJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TrabajadorService servicio;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTrabajadorJSON() {
        super();
        servicio = new TrabajadorService();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		if(codigo!=null) {
			Trabajador data = servicio.buscarPorId(Integer.parseInt(codigo)); 
			
			Gson gson=new Gson();
			String json = gson.toJson(data);
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter salida=response.getWriter();
			salida.println(json);
		}else {
			String dni = request.getParameter("dni");
			String nom_ape = request.getParameter("nomApe");
			String unidadOrg = request.getParameter("unidadOrg");
			
			List<Trabajador> listTrabajador = servicio.findByCriterios(dni, nom_ape, unidadOrg);
			
			Gson gson=new Gson();
			String json = gson.toJson(listTrabajador);
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter salida=response.getWriter();
			salida.println(json);
		}
	}

}
