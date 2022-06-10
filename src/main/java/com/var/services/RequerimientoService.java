package com.var.services;

import com.var.interfaces.BienesDAO;

import java.util.List;

import com.var.entidad.Bien;
import com.var.fabrica.DAOFactory;

public class RequerimientoService {

	private DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	private BienesDAO objBie=fabrica.getBienesDAO();
	
	public List<Bien> lisreq () {
		return objBie.lisreq();
	}
	
	
}
