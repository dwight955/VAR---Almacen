package com.var.interfaces;

import java.util.List;

import com.var.dto.RequerimientoDTO;
import com.var.entidad.CuadroRequerimientos;
import com.var.entidad.Usuario;


public interface RequerimientoDAO {
	public List<CuadroRequerimientos> listAll();
	public String codigoCorrelativo();
	CuadroRequerimientos registrar(CuadroRequerimientos requerimiento, Usuario usuario);
	List<RequerimientoDTO> listarRequerimietoDTOs();
	public List<RequerimientoDTO> listByEstadoDTOs(String estado); 
}
