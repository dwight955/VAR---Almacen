package com.var.services;

import com.var.interfaces.BienesDAO;
import com.var.interfaces.RequerimientoDAO;

import java.util.List;

import com.var.entidad.Bien;
import com.var.entidad.CuadroRequerimientos;
import com.var.fabrica.DAOFactory;

public class RequerimientoService {

	private DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	private BienesDAO objBie=fabrica.getBienesDAO();
	private RequerimientoDAO objReq = fabrica.getRequerimientoDAO();
	
	public List<Bien> lisreq () {
		return objBie.lisreq();
	}
	public String CodCorrelativoReq() {
		return objReq.codigoCorrelativo();
	}
	public List<CuadroRequerimientos> listarReq(){
		return objReq.listAll();
	}
}
