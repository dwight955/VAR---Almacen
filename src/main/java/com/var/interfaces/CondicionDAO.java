package com.var.interfaces;

import java.util.List;

import com.var.entidad.Condicion;

public interface CondicionDAO {
	//Rellenar ComboBox
	List<Condicion> listarCondicion(String table);
}
