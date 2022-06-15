package com.var.interfaces;

import com.var.entidad.CuadroRequerimientos;
import com.var.entidad.Usuario;

public interface UsuarioRequerimientoDAO {
	boolean insertar(Usuario usuario, CuadroRequerimientos requerimiento);
}
