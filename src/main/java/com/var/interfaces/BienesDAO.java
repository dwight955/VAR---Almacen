package com.var.interfaces;

import java.util.List;

import com.var.entidad.Bien;


public interface BienesDAO {
	public int save(Bien bean);
	public int update(Bien bean);
	public int deleteById(int cod); 
	public Bien findById(int cod);
	public List<Bien> listAll();
	public List<Bien> lisreq();
}
