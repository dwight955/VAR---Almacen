package com.var.interfaces;

import java.util.List;
import com.var.entidad.CuadroRequerimientos;

public interface RequerimientoDAO {
	public List<CuadroRequerimientos> listAll();
	public String codigoCorrelativo();
	
}
