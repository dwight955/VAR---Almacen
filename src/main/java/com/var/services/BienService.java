package com.var.services;

import java.util.List;

import com.var.entidad.Bien;
import com.var.entidad.Condicion;
import com.var.fabrica.DAOFactory;
import com.var.interfaces.BienesDAO;
import com.var.interfaces.CondicionDAO;

public class BienService {
	//Indicamos la fuente de datos -> 1 MySql
	private DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	// Indicar el DAO a trabajar
	private BienesDAO objBienes = fabrica.getBienesDAO();
	private CondicionDAO objCondicion = fabrica.getCondicionDAO();
	
	public int registrar(Bien bean) {
		return objBienes.save(bean);
	}
	public int actualizar(Bien bean) {
		return objBienes.update(bean);
	}
	public int eliminarPorId(int cod) {
		return objBienes.deleteById(cod);
	}
	public Bien buscarPorId(int cod) {
		return objBienes.findById(cod);
	}
	public List<Bien> listarTodo(){
		return objBienes.listAll();
	}
	public List<Condicion> listCondition(String table){
		return objCondicion.listarCondicion(table);
	}
}
