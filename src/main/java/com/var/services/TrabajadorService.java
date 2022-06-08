package com.var.services;

import java.util.List;

import com.var.entidad.Condicion;
import com.var.entidad.Trabajador;
import com.var.fabrica.DAOFactory;
import com.var.interfaces.CondicionDAO;
import com.var.interfaces.TrabajadorDAO;

public class TrabajadorService {
	private DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	private TrabajadorDAO objTrabajador = fabrica.getTrabajadorDAO();
	private CondicionDAO objCondicion = fabrica.getCondicionDAO();
	
	public int registrar(Trabajador bean) {
		return objTrabajador.save(bean);
	}
	public int actualizar(Trabajador bean) {
		return objTrabajador.update(bean);
	}
	public int eliminarPorId(int cod) {
		return objTrabajador.deleteById(cod);
	}
	public Trabajador buscarPorId(int cod) {
		return objTrabajador.findById(cod);
	}
	public List<Trabajador> listarTodo(){
		return objTrabajador.listAll();
	}
	public List<Condicion> listCondition(String table){
		return objCondicion.listarCondicion(table);
	}
	public List<Trabajador> findByCriterios(String dni, String nomApe, String UnidadOrg) {
		return objTrabajador.findByCriterios(dni, nomApe, UnidadOrg);
	}
}
