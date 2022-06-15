package com.var.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
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

}
