package com.var.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.var.entidad.Usuario;
import com.var.interfaces.UsuarioDAO;
import com.var.utils.MySqlConexion;

public class MySqlUsuarioDAO implements UsuarioDAO{

	@Override
	public Usuario iniciarSesion(String username, String clave) {
		Usuario bean = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConectar();
			pstm = cn.prepareStatement("call usp_iniciarSesion_usuario(?, ?)");
			pstm.setString(1, username);
			pstm.setString(2, clave);
			
			rs = pstm.executeQuery();
			if(rs.next()) {
				bean = new Usuario();
				bean.setDniUsu(rs.getString(1));
				bean.setNombre(rs.getString(2));
				bean.setApellido(rs.getString(3));
				bean.setCargo(rs.getString(4));
				bean.setNomUnidadOrganica(rs.getString(5));
				bean.setCodUsuario(rs.getInt(6));
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			System.out.println("ERROR en MySqlUsuarioDAO");
		}finally {
			try {
				if(cn!=null) cn.close();
				if(pstm!=null) cn.close();
				if(rs!=null) cn.close();
			}catch(SQLException ex2) {
				ex2.printStackTrace();
			}
		}
		return bean;
	}

}
