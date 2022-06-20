package com.var.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.var.entidad.CuadroRequerimientos;
import com.var.entidad.DetalleRequerimientos;
import com.var.interfaces.DetalleRequerimientoDAO;
import com.var.utils.MySqlConexion;

public class MySqlDetalleRequerimientoDAO implements DetalleRequerimientoDAO {

	@Override
	public boolean insertarMuchos(CuadroRequerimientos requerimiento,
			List<DetalleRequerimientos> detalleRequerimientos) {
		int salida[] = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlConexion.getConectar();
			String sql = "INSERT INTO tb_detallecreq VALUES (?,?,?)";
			pstm = cn.prepareStatement(sql);
			for (DetalleRequerimientos detalle : detalleRequerimientos) {
				pstm.setInt(1, detalle.getCodBien());
				pstm.setInt(2, detalle.getCant());
				pstm.setInt(3, requerimiento.getCodReq());
				pstm.addBatch();
			}
			salida = pstm.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return salida.length == detalleRequerimientos.size();
	}

	@Override
	public List<DetalleRequerimientos> listarByNumReq(String numreq) {
		List<DetalleRequerimientos> data = new ArrayList<>();
		Connection cn = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConectar();
			String sql = "call usp_buscar_detalleReqPorNum(?)";
			cstm = cn.prepareCall(sql);
			cstm.setString(1, numreq);
			rs = cstm.executeQuery();
			while(rs.next()) {
				DetalleRequerimientos bean = new DetalleRequerimientos();
				bean.setCodBien(rs.getInt(1));
				bean.setDescripcion(rs.getString(2));
				bean.setUniMed(rs.getString(3));
				bean.setCant(rs.getInt(4));
				bean.setPreUni(rs.getDouble(5));
				bean.setSubTotal(rs.getDouble(6));
				data.add(bean);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(cn!=null)cn.close();
				if(cstm!=null)cstm.close();
				if(rs!=null)rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}

}
