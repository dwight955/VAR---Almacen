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
	public List<CuadroRequerimientos> listByEstado(String estado);
	public CuadroRequerimientos FindByNumreq(String cod);
	public List<CuadroRequerimientos> consultarJUFA(String dest, String Soli, String fecha, String estado, int cant, String uni, String numreq);
	public List<CuadroRequerimientos>consultarAC(String dest,String fecha,String estado,int cant,String uni);
	boolean ActualizarEstado(int codRequerimiento, String estado);
}
