package com.var.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.var.entidad.Bien;
import com.var.entidad.Proveedor;
import com.var.interfaces.ProveedorDAO;
import com.var.utils.MySqlConexion;



public class MySqlProveedorDAO implements ProveedorDAO{

	@Override
	public int save(Proveedor bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		if(isRucRepeat(bean) != true) {
			try {
				cn=MySqlConexion.getConectar();
				String sql="insert into tb_proveedores values(null,?,?,?,?,?,?,?)";
				pstm=cn.prepareStatement(sql);
				pstm.setString(1, bean.getNroRuc());
				pstm.setString(2, bean.getRzSoc());
				pstm.setString(3, bean.getEstado());
				pstm.setString(4, bean.getCondic());
				pstm.setString(5, bean.getDirec());
				pstm.setString(6, bean.getTelf());
				pstm.setString(7, bean.getCodDis());

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
			//2 
			String sql="update tb_proveedores set nroRuc=?,rzonSoc=?,estado=?,condic=?,direc=?,telf=?,codDis=? where codProv=?";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setString(1, bean.getNroRuc());
			pstm.setString(2, bean.getRzSoc());
			pstm.setString(3, bean.getEstado());
			pstm.setString(4, bean.getCondic());
			pstm.setString(5, bean.getDirec());
			pstm.setString(6, bean.getTelf());
			pstm.setString(7, bean.getCodDis());
			pstm.setInt(8, bean.getCodProv());
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
			String sql="delete from tb_proveedores where codProv=?";
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
		Proveedor bean = null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql;
		sql="select * from tb_proveedores where codProv =?";
		try {
		cn=MySqlConexion.getConectar();
		pstm=cn.prepareStatement(sql);
		pstm.setInt(1, cod);
		rs=pstm.executeQuery();
		if(rs.next()) {
			bean = new Proveedor();
			bean.setCodProv(rs.getInt(1));
			bean.setNroRuc(rs.getString(2));
			bean.setRzSoc(rs.getString(3));
			bean.setEstado(rs.getString(4));
			bean.setCondic(rs.getString(5));
			bean.setDirec(rs.getString(6));
			bean.setTelf(rs.getString(7));
			bean.setCodDis(rs.getString(8));
		}	
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.print("Error en FindById Proveedor");
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
	public List<Proveedor> listAll() {
		List<Proveedor> data=new ArrayList<Proveedor>();
		Proveedor bean;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			//1
			cn=MySqlConexion.getConectar();
			//2 Falta modificar para la nueva estructuracion de tabla proveedores
			String sql="call usp_listar_proveedores";
			//3
			cstm= cn.prepareCall(sql);
			//4 parámetros
			
			//5
			rs=cstm.executeQuery();
			//6 bucle
			while(rs.next()) {
				//7 crear bean
				bean=new Proveedor();
				//8
				bean.setCodProv(rs.getInt(1));
				bean.setNroRuc(rs.getString(2));
				bean.setRzSoc(rs.getString(3));
				bean.setEstado(rs.getString(4));
				bean.setCondic(rs.getString(5));
				bean.setDirec(rs.getString(6));
				bean.setTelf(rs.getString(7));
				bean.setCodDis(rs.getString(8));
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
				if(cstm!=null) cstm.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}
	private boolean isRucRepeat(Proveedor bean) {
		List<Proveedor> data = this.listAll();
		for(int i = 0; i<data.size(); i++) {
			if(bean.getNroRuc().equals(data.get(i).getNroRuc())){ 
				return true;
			}
		}
		return false;
	}
}












