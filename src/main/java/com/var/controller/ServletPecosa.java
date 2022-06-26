package com.var.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Pecosa pecosa = new Pecosa();
		pecosa.setNumPec(request.getParameter("numero"));
		pecosa.setEstado(request.getParameter("estado"));
		pecosa.setFecform(request.getParameter("fecha"));
		pecosa.setReferencia(request.getParameter("referencia"));
		pecosa.setCodUsu(Integer.parseInt(request.getSession().getAttribute("CODIGO").toString()));
		pecosa.setTotal(Double.parseDouble(request.getParameter("total").substring(3)));
		CuadroRequerimientos req = requerimientoService.FindByNumreq(request.getParameter("numeroReq"));
		pecosa.setCodReq(req.getCodReq());
		if (pecosaService.registrar(pecosa)) {
			request.setAttribute("MENSAJE", "Pecosa registrada...");
		} else {
			request.setAttribute("MENSAJE", "Error al registrar pecosa");
		}
		request.getRequestDispatcher("/GenerarPECOSA.jsp").forward(request, response);
	}
}
