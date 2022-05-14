package com.var.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.var.entidad.Trabajador;
import com.var.interfaces.TrabajadorDAO;
import com.var.utils.MySqlConexion;


public class MySqlTrabajadorDAO implements TrabajadorDAO{

	@Override
	public int save(Trabajador bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConectar();
			//2
			String sql="insert into bwinfxi4ncz6ryqu6s48.tb_trabajadores values(null,?,?,?,?,?)";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setString(1, bean.getDni());
			pstm.setString(2, bean.getNomApe());
			pstm.setString(3, bean.getCargo());
			pstm.setString(4, bean.getSexo());
			pstm.setString(5, bean.getCodUnidadOrga());
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
	public int update(Trabajador bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConectar();
			//2
			String sql="update bwinfxi4ncz6ryqu6s48.tb_trabajadores set dniTrabajador=?,apeNomTrabajador=?,cargoTrabajador=?,sexo=?,codUniOrg=? where codTrab=?";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setString(1, bean.getDni());
			pstm.setString(2, bean.getNomApe());
			pstm.setString(3, bean.getCargo());
			pstm.setString(4, bean.getSexo());
			pstm.setString(5, bean.getCodUnidadOrga());
			pstm.setInt(6, bean.getCodTrab());
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
			String sql="delete from bwinfxi4ncz6ryqu6s48.tb_trabajadores where codTrab=?";
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
	public Trabajador findById(int cod) {
	 
		List<Trabajador> lista=new ArrayList<>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql;
		
		sql="select * from bwinfxi4ncz6ryqu6s48.tb_trabajadores where codTrab=?";
		
		
		try {
			
		
		cn=MySqlConexion.getConectar();
		pstm=cn.prepareStatement(sql);
		rs=pstm.executeQuery();
		while(rs.next()) {
			Trabajador tr=new Trabajador();
			tr.setCodTrab(rs.getInt("Codigo"));
			tr.setDni(rs.getString("DNI"));
			tr.setNomApe(rs.getString("Nombres y Apellidos"));
			tr.setCargo(rs.getString("Cargo"));
			tr.setSexo(rs.getString("Sexo"));
			tr.setCodUnidadOrga(rs.getString("CodUni"));
		lista.add(tr);
		
		}
		
				
		}catch (Exception e) {
			
			
		}
		
	
		return  (Trabajador) lista;
		
	}

	@Override
	public List<Trabajador> listAll() {
		List<Trabajador> data=new ArrayList<Trabajador>();
		Trabajador bean;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1
			cn=MySqlConexion.getConectar();
			//2
			String sql="select *from bwinfxi4ncz6ryqu6s48.tb_trabajadores";
			//3
			pstm=cn.prepareStatement(sql);
			//4 parámetros
			
			//5
			rs=pstm.executeQuery();
			//6 bucle
			while(rs.next()) {
				//7 crear bean
				bean=new Trabajador();
				//8
				bean.setCodTrab(rs.getInt(1));
				bean.setDni(rs.getString(2));
				bean.setNomApe(rs.getString(3));
				bean.setCargo(rs.getString(4));
				bean.setSexo(rs.getString(5));
				bean.setCodUnidadOrga(rs.getString(6));
				//9
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












