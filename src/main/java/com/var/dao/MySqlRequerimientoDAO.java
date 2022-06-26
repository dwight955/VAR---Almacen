package com.var.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.var.dto.RequerimientoDTO;
import com.var.entidad.CuadroRequerimientos;
import com.var.entidad.Usuario;
import com.var.interfaces.RequerimientoDAO;
import com.var.utils.MySqlConexion;


public class MySqlRequerimientoDAO implements RequerimientoDAO {

	@Override
	public String codigoCorrelativo() {
		List<CuadroRequerimientos> data = listAll();
		String codigoSerial;
		if (data.size() == 0) {
			codigoSerial = "000001";
		} else {
			int num = Integer.parseInt(data.get(data.size() - 1).getNumreq()) + 1;
			codigoSerial = String.format("%06d", num);
		}
		return codigoSerial;
	}

	@Override
	public List<CuadroRequerimientos> listAll() {
		List<CuadroRequerimientos> data = new ArrayList<CuadroRequerimientos>();
		CuadroRequerimientos bean;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConectar();
			String sql = "select * from tb_cabecreq";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				bean = new CuadroRequerimientos();
				bean.setNumreq(rs.getString(1));
				bean.setEstado(rs.getString(2));
				bean.setFechaEmi(rs.getString(3));
				bean.setCodSoli(rs.getInt(4));
				bean.setCodEntr(rs.getInt(5));
				bean.setCodReq(rs.getInt(6));
				data.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}

	@Override
	public CuadroRequerimientos registrar(CuadroRequerimientos requerimiento, Usuario usuario) {
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConectar();
			String sql = "INSERT INTO tb_cabecreq VALUES (?,?,?,?,?,DEFAULT)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, requerimiento.getNumreq());
			pstm.setString(2, requerimiento.getEstado());
			pstm.setString(3, requerimiento.getFechaEmi());
			pstm.setInt(4, usuario.getCodUsuario());
			pstm.setInt(5, requerimiento.getCodEntr());
			if (!pstm.execute()) {
				cn.close();
				pstm.close();
				cn = MySqlConexion.getConectar();
				sql = "SELECT codreq from tb_cabecreq order by codreq desc limit 1";
				pstm = cn.prepareStatement(sql);
				rs = pstm.executeQuery();
				while (rs.next()) {
					requerimiento.setCodReq(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return requerimiento;
	}

	@Override
	public List<RequerimientoDTO> listarRequerimietoDTOs() {
		List<RequerimientoDTO> data = new ArrayList<>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConectar();
			String sql = "select cab.numreq,tra.dniTrabajador,tra.apeNomTrabajador,cab.estado,cab.fechaEmision from tb_cabecreq cab "
					+ "join tb_trabajadores tra on tra.codTrab = cab.destinatario_codTrab order by cab.codreq desc";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				
				RequerimientoDTO bean = new RequerimientoDTO();
				bean.setNumero(rs.getString(1));
				bean.setDni(rs.getString(2));
				bean.setRemitente(rs.getString(3));
				bean.setEstado(rs.getString(4));
				bean.setFecha(rs.getString(5));
				data.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}

	@Override
	public List<CuadroRequerimientos> listByEstado(String estado) {
		List<CuadroRequerimientos> data = new ArrayList<>();
		Connection cn = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConectar();
			String sql = "call usp_listar_requerimiento_estado(?)";
			cstm = cn.prepareCall(sql);
			cstm.setString(1, estado);
			rs = cstm.executeQuery();
			while (rs.next()) {
				CuadroRequerimientos bean = new CuadroRequerimientos();
				bean.setNumreq(rs.getString(1));
				bean.setDniSoli(rs.getString(2));
				bean.setApenomSoli(rs.getString(3));
				bean.setApenomEntre(rs.getString(4));
				bean.setEstado(rs.getString(5));
				bean.setFechaEmi(rs.getString(6));
				data.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstm != null)
					cstm.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
				System.out.print("ERROR en servlet requerimiento");
			}
		}
		return data;
	}

	@Override
	public List<CuadroRequerimientos> consultarJUFA(String dest, String Soli, String fecha, String estado, int cant,
			String uni, String numreq) {
		List<CuadroRequerimientos> data = new ArrayList<>();
		Connection cn = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConectar();
			String sql = "call usp_sonsultaCR_JUFA(?,?,?,?,?,?,?);";
			cstm = cn.prepareCall(sql);
			cstm.setString(1, dest);
			cstm.setString(2, Soli);
			cstm.setString(3, fecha);
			cstm.setString(4, estado);
			cstm.setInt(5, cant);
			cstm.setString(6, uni);
			cstm.setString(7, numreq);
			rs = cstm.executeQuery();
			while (rs.next()) {
				CuadroRequerimientos bean = new CuadroRequerimientos();
				bean.setNumreq(rs.getString(1));
				bean.setApenomEntre(rs.getString(2));
				bean.setApenomSoli(rs.getString(3));
				bean.setNomUniEntr(rs.getString(4));
				bean.setCantidad(rs.getInt(5));
				bean.setFechaEmi(rs.getString(6));
				data.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstm != null)
					cstm.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
				System.out.print("ERROR en servlet requerimiento - CONSULTA JUFA");
			}
		}
		return data;
	}

	@Override
	public CuadroRequerimientos FindByNumreq(String cod) {
		CuadroRequerimientos bean = null;
		Connection cn = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConectar();
			String sql = "call usp_buscar_requePorNum(?)";
			cstm = cn.prepareCall(sql);
			cstm.setString(1, cod);
			rs = cstm.executeQuery();
			if(rs.next()) {
				bean = new CuadroRequerimientos();
				bean.setNumreq(rs.getString(1));
				bean.setDniSoli(rs.getString(2));
				bean.setApenomSoli(rs.getString(3));
				bean.setApenomEntre(rs.getString(4));
				bean.setEstado(rs.getString(5));
				bean.setFechaEmi(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstm != null)
					cstm.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
				System.out.print("ERROR en servlet requerimiento - BuscarPorNumreq");
			}
		}
		return bean;
	}

	@Override
	public List<CuadroRequerimientos> consultarAC(String dest,String fecha,String estado,int cant)
	{
		List<CuadroRequerimientos> data = new ArrayList<>();
		Connection cn = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConectar();
			String sql = "call usp_consultar_DirectivoUni(?,?,?,?);";
			cstm = cn.prepareCall(sql);
			cstm.setString(1, dest);
			cstm.setString(2, fecha);
			cstm.setString(3, estado);
			cstm.setInt(4, cant);
	
			rs = cstm.executeQuery();
			while (rs.next()) {
				CuadroRequerimientos bean = new CuadroRequerimientos();
				bean.setApenomEntre(rs.getString(1));
				bean.setFechaEmi(rs.getString(2));
				bean.setEstado(rs.getString(3));
				bean.setCantidad(rs.getInt(4));								
				data.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstm != null)
					cstm.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
				System.out.print("ERROR en servlet requerimiento - CONSULTA");
			}
		}
		return data;
	}	
	
}
