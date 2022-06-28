package com.var.services;

import java.util.List;

import com.var.dto.PecosaDTO;
import com.var.entidad.Pecosa;
import com.var.fabrica.DAOFactory;
import com.var.interfaces.PecosaDAO;

public class PecosaService {
	private DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	private PecosaDAO objPecosaDAO = fabrica.getPecosaDAO();

	public String codeCorrelative() {
		return objPecosaDAO.codigoCorrelativo();
	}

	public List<PecosaDTO> listarTodo() {
		return objPecosaDAO.listAll();
	}

	public boolean registrar(Pecosa pecosa) {
		return objPecosaDAO.registrar(pecosa);
	}
	public Pecosa buscarNumPecosa(String numPec) {
		return objPecosaDAO.buscar(numPec);
	}
	public int ActualizarEstado(String numPec, String estado) {
		return objPecosaDAO.ActualizarEstado(numPec, estado);
	}
}
