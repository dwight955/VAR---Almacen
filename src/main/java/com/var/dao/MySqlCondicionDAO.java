package com.var.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.var.entidad.Condicion;
import com.var.entidad.Proveedor;
import com.var.interfaces.CondicionDAO;
import com.var.utils.MySqlConexion;

public class MySqlCondicionDAO implements CondicionDAO{
	//Listado para rellenar ComboBox
	@Override
	public List<Condicion> listarCargo() {
		List<Condicion> data=new ArrayList<Condicion>();
		Condicion bean;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlConexion.getConectar();
			String sql="select * from  tb_cargos";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				bean=new Condicion();
				bean.setCod(rs.getString(1));
				bean.setNom(rs.getString(2));
				data.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print("ERROR al listar cargos");
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}

	@Override
	public List<Condicion> listarUO() {
		List<Condicion> data=new ArrayList<Condicion>();
		Condicion bean;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlConexion.getConectar();
			String sql="select codUniOrg, nomUniOrg from  tb_unidadorganica; ";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				bean=new Condicion();
				bean.setCod(rs.getString(1));
				bean.setNom(rs.getString(2));
				data.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}
	

}
