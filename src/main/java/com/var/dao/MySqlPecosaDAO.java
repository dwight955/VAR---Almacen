package com.var.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.var.dto.PecosaDTO;
import com.var.dto.RequerimientoDTO;
import com.var.entidad.CuadroRequerimientos;
import com.var.entidad.Pecosa;
import com.var.interfaces.PecosaDAO;
import com.var.utils.MySqlConexion;

public class MySqlPecosaDAO implements PecosaDAO {

	@Override
	public String codigoCorrelativo() {
		List<PecosaDTO> data = listAll();
		String codigoSerial;
		if (data.size() == 0) {
			codigoSerial = "000001";
		} else {
			int num = Integer.parseInt(data.get(data.size() - 1).getNroPec()) + 1;
			codigoSerial = String.format("%06d", num);
		}
		return codigoSerial;
	}

	@Override
	public List<PecosaDTO> listAll() {
		List<PecosaDTO> data = new ArrayList<>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConectar();
			String sql = "select p.nroPecosa, c.numreq, c.destinatario_codTrab as destinatario, p.estado, p.fecForm "
					+ "from tb_pecosa as p join tb_cabecreq as c " + "on p.codreq = c.codreq";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				PecosaDTO bean = new PecosaDTO();
				bean.setNroPec(rs.getString(1));
				bean.setNroReq(rs.getString(2));
				bean.setDestinatario(rs.getString(3));
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
	public boolean registrar(Pecosa pecosa) {
		int filasAfectadas = 0;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConectar();
			String sql = "INSERT INTO `tb_pecosa` (`nroPecosa`, `estado`, `fecForm`, `referencia`, `codreq`, `cdoUsuApro`, `FechApro`, `total`) VALUES (?, ?, ?, ?, ?, ?, curdate(), ?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, pecosa.getNumPec());
			pstm.setString(2, pecosa.getEstado());
			pstm.setString(3, pecosa.getFecform());
			pstm.setString(4, pecosa.getReferencia());
			pstm.setInt(5, pecosa.getCodReq());
			pstm.setInt(6, pecosa.getCodUsu());
			pstm.setDouble(7, pecosa.getTotal());
			filasAfectadas = pstm.executeUpdate();
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
		return filasAfectadas > 0;
	}

}
