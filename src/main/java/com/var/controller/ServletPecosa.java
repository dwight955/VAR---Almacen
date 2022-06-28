package com.var.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.var.dto.PecosaDTO;
import com.var.entidad.CuadroRequerimientos;
import com.var.entidad.Pecosa;
import com.var.services.PecosaService;
import com.var.services.RequerimientoService;

@WebServlet("/ServletPecosa")
public class ServletPecosa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PecosaService pecosaService;
	private RequerimientoService requerimientoService;

	public ServletPecosa() {
		super();
		pecosaService = new PecosaService();
		requerimientoService = new RequerimientoService();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String tipo = request.getParameter("accion");
		if(tipo.equals("GENERAR"))
			generar(request,response);
		if(tipo.equals("LISTAR"))
			listarTodo(request,response);
		if(tipo.equals("ACTUALIZAR_ESTADO"))
			actualizarEstado(request,response);
	}
	private void actualizarEstado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numPec, estado, numReq;
		numPec = request.getParameter("numeroPec");
		estado = request.getParameter("btnEstado");
		numReq = request.getParameter("numeroReq");
		int salida = pecosaService.ActualizarEstado(numPec, estado);
		if(salida>0) {
			request.setAttribute("MENSAJE", "Se actualizo su estado a "+estado);
			listarTodo(request,response);
		}else {
			request.setAttribute("MENSAJE", "No se actualizo estado de la PECOSA");
			listarTodo(request,response);
		}
	}

	private void listarTodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PecosaDTO> lista = pecosaService.listarTodo();
		String page = request.getParameter("page");
		request.setAttribute("PECOSA", lista);
		if(page.equals("bdjPecosa")) {
			request.getRequestDispatcher("/bdjPecosas.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/GenerarPECOSA.jsp").forward(request, response);
		}
	}

	private void generar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pecosa pecosa = new Pecosa();
		String pec, numreq;
		pec = request.getParameter("numero");
		pecosa.setNumPec(request.getParameter("numero"));
		numreq = request.getParameter("numeroReq");
		pecosa.setEstado(request.getParameter("estado"));
		pecosa.setFecform(request.getParameter("fecha"));
		pecosa.setReferencia(request.getParameter("referencia"));
		pecosa.setCodUsu(Integer.parseInt(request.getSession().getAttribute("CODIGO").toString()));
		pecosa.setTotal(Double.parseDouble(request.getParameter("total").substring(3)));
		CuadroRequerimientos req = requerimientoService.FindByNumreq(request.getParameter("numeroReq"));
		pecosa.setCodReq(req.getCodReq());
		if (pecosaService.registrar(pecosa)) {
			request.setAttribute("MENSAJE", "Pecosa registrada...");
			listarTodo(request, response);
			requerimientoService.ActualizarEstado(numreq, "FORMULADO");
		} else {
			request.setAttribute("MENSAJE", "Error al registrar pecosa");
			listarTodo(request, response);
		}
		
	}
}
