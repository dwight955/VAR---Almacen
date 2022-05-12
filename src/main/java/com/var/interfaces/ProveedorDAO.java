package com.var.interfaces;

import java.util.List;

import com.var.entidad.Proveedor;

public interface ProveedorDAO {
	public int save(Proveedor bean);
	public int update(Proveedor bean);
	public int deleteById(int cod);
	public Proveedor findById(int cod);
	public List<Proveedor> listAll();
	
}
