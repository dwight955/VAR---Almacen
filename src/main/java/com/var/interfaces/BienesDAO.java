package com.var.interfaces;

import java.util.ArrayList;

import com.var.entidad.Bien;

public interface BienesDAO {
	public int Ingresar(Bien bean);
	public int Actualizar(Bien bean);
	int Eliminar(Bien bean); 
	public ArrayList<Bien> ListAll();
	public String[] fieldByCod(String codBien);
}
