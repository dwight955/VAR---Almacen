package com.var.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.var.entidad.Bien;
import com.var.services.RequerimientoService;
import com.google.gson.Gson;


@WebServlet("/ServletBienReqJSON")
public class ServletBienReqJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletBienReqJSON() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Bien> lista=new RequerimientoService().lisreq();
		
		Gson gson=new Gson();
		
		String json=gson.toJson(lista);
		
		response.setContentType("application/json;charset=UTF-8");
		
		PrintWriter salida=response.getWriter();
		salida.println(json);
		
	}

}
