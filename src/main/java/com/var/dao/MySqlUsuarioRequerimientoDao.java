package com.var.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.var.entidad.CuadroRequerimientos;
import com.var.entidad.Usuario;
import com.var.interfaces.UsuarioRequerimientoDAO;
import com.var.utils.MySqlConexion;

public class MySqlUsuarioRequerimientoDao implements UsuarioRequerimientoDAO {

	@Override
	public boolean insertar(Usuario usuario, CuadroRequerimientos requerimiento) {
		boolean salida = false;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlConexion.getConectar();
			String sql = "INSERT INTO tb_usuario_cuadroreq VALUES (?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, usuario.getCodUsuario());
			pstm.setString(2, requerimiento.getNumreq());
			salida = pstm.executeUpdate() > 0;
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
		return salida;
	}

}
