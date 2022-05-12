package com.var.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.var.entidad.Proveedor;
import com.var.interfaces.ProveedorDAO;
import com.var.utils.MySqlConexion;



public class MySqlProveedorDAO implements ProveedorDAO{

	@Override
	public int save(Proveedor bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConectar();
			//2 Modificar para agregar codprov
			String sql="insert into bwinfxi4ncz6ryqu6s48.tb_proveedores values(?,?,?,?,?,?,?)";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setString(1, bean.getNroRuc());
			pstm.setString(2, bean.getRzSoc());
			pstm.setString(3, bean.getEstado());
			pstm.setString(4, bean.getCondic());
			pstm.setString(5, bean.getDirec());
			pstm.setInt(6, bean.getTelf());
			pstm.setString(7, bean.getCodDis());
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
	public int update(Proveedor bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConectar();
			//2 Falta modificar para la nueva estructuracion de tabla proveedores
			String sql="update bwinfxi4ncz6ryqu6s48.tb_proveedores set nroRuc=?,rzonSoc=?,estado=?,condic=?,direc=?,telf=?,codDis=? wheren nroRuc=?";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			//pstm.setString(1, bean.getNroRuc());
			pstm.setString(1, bean.getRzSoc());
			pstm.setString(2, bean.getEstado());
			pstm.setString(3, bean.getCondic());
			pstm.setString(4, bean.getDirec());
			pstm.setInt(5, bean.getTelf());
			pstm.setString(6, bean.getCodDis());
			pstm.setString(7, bean.getNroRuc());
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
			//2 Falta modificar para la nueva estructuracion de tabla proveedores
			String sql="delete from bwinfxi4ncz6ryqu6s48.tb_proveedores where nroRuc=?";
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
	public Proveedor findById(int cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proveedor> listAll() {
		List<Proveedor> data=new ArrayList<Proveedor>();
		Proveedor bean;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1
			cn=MySqlConexion.getConectar();
			//2 Falta modificar para la nueva estructuracion de tabla proveedores
			String sql="SELECT * FROM bwinfxi4ncz6ryqu6s48.tb_proveedores";
			//3
			pstm=cn.prepareStatement(sql);
			//4 parámetros
			
			//5
			rs=pstm.executeQuery();
			//6 bucle
			while(rs.next()) {
				//7 crear bean
				bean=new Proveedor();
				//8
				bean.setNroRuc(rs.getString(1));
				bean.setRzSoc(rs.getString(2));
				bean.setEstado(rs.getString(3));
				bean.setCondic(rs.getString(4));
				bean.setDirec(rs.getString(5));
				bean.setTelf(rs.getInt(6));
				bean.setCodDis(rs.getString(7));
				//9
				data.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERROR: MySqlProveedor");
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












