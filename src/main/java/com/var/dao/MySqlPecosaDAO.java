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
import com.var.entidad.Trabajador;
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
			String sql = "select p.nroPecosa, c.numreq, t.apeNomTrabajador as destinatario, p.estado, p.fecForm, concat_ws(' ',u.nom_usu,u.ape_usu)"
					+ " from tb_pecosa as p join tb_cabecreq as c"
					+ " on p.codreq = c.codreq join tb_trabajadores as t"
					+ " on c.destinatario_codTrab = t.codTrab join tb_usuarios u"
					+ " on c.codUsu = u.cod_usu";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				PecosaDTO bean = new PecosaDTO();
				bean.setNroPec(rs.getString(1));
				bean.setNroReq(rs.getString(2));
				bean.setDestinatario(rs.getString(3));
				bean.setEstado(rs.getString(4));
				bean.setFecha(rs.getString(5));
				bean.setResponsable(rs.getString(6));
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

	@Override
	public Pecosa buscar(String numPec) {
		Pecosa bean = null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		//se quito campos UsuArpo y FechFormApro de la sentencia
		String sql ="select p.nroPecosa, "
				+ "p.estado, p.fecForm, p.referencia, "
				+ "c.numreq, p.total, p.codPecosa from tb_pecosa p "
				+ "join tb_cabecreq c on p.codreq = c.codreq "
				+ "where nroPecosa = ?";
		try {
		cn=MySqlConexion.getConectar();
		pstm=cn.prepareStatement(sql);
		pstm.setString(1, numPec);
		rs=pstm.executeQuery();
		if(rs.next()) {
			bean = new Pecosa();
			bean.setNumPec(rs.getString(1));
			bean.setEstado(rs.getString(2));
			bean.setFecform(rs.getString(3));
			bean.setReferencia(rs.getString(4));
			bean.setNumReq(rs.getString(5));;
			bean.setTotal(rs.getDouble(6));
			bean.setCodPec(rs.getInt(7));
		}	
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.print("Error en buscar Pecosa");
		}finally {
			try {
				if(cn!=null) cn.close();
				if(pstm!=null)pstm.close();
				if(rs!=null)rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bean;
	}

	@Override
	public int ActualizarEstado(String numPec, String estado) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlConexion.getConectar();
			pstm = cn.prepareStatement("update tb_pecosa set estado = ? where nroPecosa = ?");
			pstm.setString(1, estado);
			pstm.setString(2, numPec);
			salida = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(cn!=null) cn.close();
				if(pstm!=null)pstm.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

}
