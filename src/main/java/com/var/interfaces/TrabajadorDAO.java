package com.var.interfaces;

import java.util.List;

import com.var.entidad.Trabajador;

public interface TrabajadorDAO {
	public int save(Trabajador bean);
	public int update(Trabajador bean);
	public int deleteById(int cod);
	public Trabajador findById(int cod);
	public List<Trabajador> listAll();
	public List<Trabajador> findByCriterios(String dni,String nomApe, String UnidadOrg);
}
