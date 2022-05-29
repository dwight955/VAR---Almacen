package com.var.services;

import java.util.List;

import com.var.entidad.Condicion;
import com.var.entidad.Proveedor;
import com.var.fabrica.DAOFactory;
import com.var.interfaces.CondicionDAO;
import com.var.interfaces.ProveedorDAO;

public class ProveedorService {
	private DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	private ProveedorDAO objProveedor = fabrica.getProveedorDAO();
	private CondicionDAO objCondicion = fabrica.getCondicionDAO();
	
	public int registrar(Proveedor bean) {
		return objProveedor.save(bean);
	}
	public int actualizar(Proveedor bean) {
		return objProveedor.update(bean);
	}
	public int eliminarPorId(int cod) {
		return objProveedor.deleteById(cod);
	}
	public Proveedor buscarPorId(int cod) {
		return objProveedor.findById(cod);
	}
	public List<Proveedor> listarTodo(){
		return objProveedor.listAll();
	}
	public List<Condicion> listCondition(String table){
		return objCondicion.listarCondicion(table);
	}
}
