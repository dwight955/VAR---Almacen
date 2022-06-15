package com.var.interfaces;

import java.util.List;

import com.var.entidad.CuadroRequerimientos;
import com.var.entidad.DetalleRequerimientos;

public interface DetalleRequerimientoDAO {
	boolean insertarMuchos(CuadroRequerimientos requerimiento, List<DetalleRequerimientos> detalleRequerimientos);
}
