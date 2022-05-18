package com.var.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.var.entidad.Bien;
import com.var.interfaces.BienesDAO;
import com.var.utils.MySqlConexion;

public class MySqlBienesDAO implements BienesDAO{

	@Override
	public int Ingresar(Bien bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Actualizar(Bien bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Eliminar(Bien bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Bien> ListAll() {
		ArrayList<Bien> lista = new ArrayList<Bien>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "call usp_listar_Bienes()";
		
		try {
			cn = MySqlConexion.getConectar();
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				Bien bie = new Bien();
				
				bie.setCodBien(rs.getString(1));
				bie.setDescBien(rs.getString(2));
				bie.setUniMed(rs.getString(3));
				bie.setPrecUni(rs.getDouble(4));
				bie.setCategoria(rs.getString(5));
				bie.setStockDisponible(rs.getInt(6));
				bie.setFecIngreso(rs.getString(7));
				lista.add(bie);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(">>Problemas en bienesDAO");
		}
		finally {
			try {
				if (rs != null) rs.close();
				if (cn != null) cn.close();
				if (pstm != null) pstm.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public String[] fieldByCod(String codBien) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
