package com.var.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.var.entidad.Bien;

import com.var.interfaces.BienesDAO;
import com.var.utils.MySqlConexion;

public class MySqlBienesDAO implements BienesDAO{

	@Override
	public int save(Bien bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConectar();
			//2 Modificar para agregar codprov
			String sql="insert into tb_bienes values(null,?,?,?,?,?,CURDATE())";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setString(1, bean.getDescBien());
			pstm.setString(2, bean.getUniMed());
			pstm.setDouble(3, bean.getPrecUni());
			pstm.setString(4, bean.getCategoria());
			pstm.setInt(5, bean.getStockDisponible());
			//5
			salida=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	@Override
	public int update(Bien bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConectar();
			//2 
			String sql="update tb_bienes set descripcion=?,unidMed=?,precUni=?,idCategoria=?,stockDisponible=?,fecIngreso=CURDATE() where codBien=?";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setString(1, bean.getDescBien());
			pstm.setString(2, bean.getUniMed());
			pstm.setDouble(3, bean.getPrecUni());
			pstm.setString(4, bean.getCategoria());
			pstm.setInt(5, bean.getStockDisponible());
			pstm.setInt(6, bean.getCodBien());
			//5
			salida=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	@Override
	public int deleteById(int cod) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConectar();
			//2 
			String sql="delete from tb_bienes where codBien=?";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setInt(1, cod);
			//5
			salida=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return salida;
	}
	

	@Override
	public List<Bien> listAll() {
		List<Bien> lista = new ArrayList<Bien>();
		Bien bean;
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
				
				bie.setCodBien(rs.getInt(1));
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
	public List<Bien> lisreq() {
		List<Bien> data=new ArrayList<Bien>();
		Bien bean;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			
			cn=MySqlConexion.getConectar();
			
			String sql="select *from tb_bienes";
			
			pstm=cn.prepareStatement(sql);	
			
		
			rs=pstm.executeQuery();
		
			while(rs.next()) {
				
				bean=new Bien();
				
				bean.setCodBien(rs.getInt(1));     				
				bean.setDescBien(rs.getString(2));
				bean.setUniMed(rs.getString(3));
			
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

	@Override
	public Bien findById(int cod) {
		Bien bean = null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql;
		sql="select * from tb_bienes where codBien=?";
		try {
		cn=MySqlConexion.getConectar();
		pstm=cn.prepareStatement(sql);
		pstm.setInt(1, cod);
		rs=pstm.executeQuery();
		if(rs.next()) {
			bean = new Bien();
			bean.setCodBien(rs.getInt(1));
			bean.setDescBien(rs.getString(2));
			bean.setUniMed(rs.getString(3));
			bean.setPrecUni(rs.getDouble(4));
			bean.setCategoria(rs.getString(5));
			bean.setStockDisponible(rs.getInt(6));
		}	
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.print("Error en FindById Bien");
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
	
	
	
}
