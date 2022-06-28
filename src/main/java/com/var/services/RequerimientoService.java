package com.var.services;

import com.var.interfaces.BienesDAO;
import com.var.interfaces.DetalleRequerimientoDAO;
import com.var.interfaces.RequerimientoDAO;
import com.var.interfaces.UsuarioRequerimientoDAO;

import java.util.List;

import com.var.dto.RequerimientoDTO;
import com.var.entidad.Bien;
import com.var.entidad.CuadroRequerimientos;
import com.var.entidad.DetalleRequerimientos;
import com.var.entidad.Usuario;
import com.var.fabrica.DAOFactory;

public class RequerimientoService {

	private DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	private BienesDAO objBie = fabrica.getBienesDAO();
	private RequerimientoDAO objReq = fabrica.getRequerimientoDAO();
	private DetalleRequerimientoDAO detalleReqDao = fabrica.getDetalleRequerimientoDAO();
	private UsuarioRequerimientoDAO usuarioRequerimientoDAO = fabrica.getUsuarioRequerimientoDAO();

	public List<Bien> lisreq() {
		return objBie.lisreq();
	}

	public String CodCorrelativoReq() {
		return objReq.codigoCorrelativo();
	}

	public List<CuadroRequerimientos> listarReq() {
		return objReq.listAll();
	}

	public boolean insertar(CuadroRequerimientos requerimiento, List<DetalleRequerimientos> detalleRequerimientos,
			Usuario usuario) {
		requerimiento = objReq.registrar(requerimiento, usuario);
		boolean seInsertoDetalle = detalleReqDao.insertarMuchos(requerimiento, detalleRequerimientos);
		boolean seInsertoUsuariorequerimiento = usuarioRequerimientoDAO.insertar(usuario, requerimiento);
		return seInsertoDetalle && seInsertoUsuariorequerimiento;
	}

	public List<RequerimientoDTO> listarRequerimietoDTOs() {
		return objReq.listarRequerimietoDTOs();
	}
	public List<CuadroRequerimientos> listByEstado(String estado) {
		return objReq.listByEstado(estado);
	}
	public List<CuadroRequerimientos> consultarJUFA(String dest, String Soli, String fecha, String estado, int cant, String uni, String numreq) {
		return objReq.consultarJUFA(dest, Soli, fecha, estado, cant, uni, numreq);
	} 
	public List<DetalleRequerimientos> listarByNumReqDetalle(String numreq) {
		return detalleReqDao.listarByNumReq(numreq);
	}
	public CuadroRequerimientos FindByNumreq(String cod) {
		return objReq.FindByNumreq(cod);
	}
	public List<CuadroRequerimientos> consultarAC(String dest,String fecha,String estado,int cant, String uni){
		return objReq.consultarAC(dest,fecha,estado,cant, uni);
	} 
	public int ActualizarEstado(String numRequerimiento, String estado) {
		return objReq.ActualizarEstado(numRequerimiento, estado);
	}
}
