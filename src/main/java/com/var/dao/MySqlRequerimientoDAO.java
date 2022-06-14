package com.var.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.var.entidad.CuadroRequerimientos;
import com.var.entidad.Trabajador;
import com.var.interfaces.RequerimientoDAO;
import com.var.utils.MySqlConexion;

public class MySqlRequerimientoDAO implements RequerimientoDAO {

	@Override
	public String codigoCorrelativo() {
		List<CuadroRequerimientos> data = listAll();
		String codigoSerial;
		if(data.size()==0) {
			codigoSerial = "000001";
		}else {
			int num = Integer.parseInt(data.get(data.size()-1).getNumreq()) + 1;
			codigoSerial = String.format("%06d", num);
		}
		return codigoSerial;
	}
	@Override
	public List<CuadroRequerimientos> listAll() {
		List<CuadroRequerimientos> data=new ArrayList<CuadroRequerimientos>();
		CuadroRequerimientos bean;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlConexion.getConectar();
			String sql="select * from tb_cabecreq";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				bean=new CuadroRequerimientos();
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
