package com.var.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.google.gson.Gson;
import com.var.entidad.DetalleRequerimientos;


@WebServlet("/ServletRequerimiento")
public class ServletRequerimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletRequerimiento() {
        super();
       
    }

		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String tipo=request.getParameter("accion");
			if(tipo.equals("ADICIONAR"))
				adicionarBien(request,response);
			else if(tipo.equals("ELIMINAR"))
				eliminarBien(request,response);
			
	}

		private void eliminarBien(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
			List<DetalleRequerimientos> info=(List<DetalleRequerimientos>) request.getSession().getAttribute("data");
			
			String cod=request.getParameter("codigo");
			
			for(DetalleRequerimientos d:info) {
				
				if(d.getCodBien()==Integer.parseInt(cod)) {
					info.remove(d);
					break;
				}
			}
			
			
			request.getSession().setAttribute("data",info);
					
			
			Gson gson=new Gson();
			
			String json=gson.toJson(info);
			
			response.setContentType("application/json;charset=UTF-8");
			
			PrintWriter salida=response.getWriter();
			salida.println(json);				
			
		}

		private void adicionarBien(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
			
			List<DetalleRequerimientos> lista=null;
			
			HttpSession session=request.getSession();
			 
			if(session.getAttribute("data")==null) {
				
				lista=new ArrayList<DetalleRequerimientos>();
			}
			else {
				
				lista=(List<DetalleRequerimientos>) session.getAttribute("data");
			}	
			
			
			String cod,des,uni,can;
			cod=request.getParameter("codigo");
			des=request.getParameter("descripcion");
			uni=request.getParameter("unidad");
			can=request.getParameter("cantidad");
			
			DetalleRequerimientos det=new DetalleRequerimientos();
			
			det.setCodBien(Integer.parseInt(cod));
			det.setDescripcion(des);
			det.setUniMed(uni);
			det.setCant(Integer.parseInt(can));
		
			lista.add(det);
			
			session.setAttribute("data",lista);
			
			
			Gson gson=new Gson();
			
			String json=gson.toJson(lista);
			
			response.setContentType("application/json;charset=UTF-8");
			
			PrintWriter salida=response.getWriter();
			salida.println(json);		
		}

}
