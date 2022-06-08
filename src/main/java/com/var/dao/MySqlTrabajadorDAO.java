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
		if(isDNIRepeat(bean) != true) {
			try {
				cn=MySqlConexion.getConectar();
				String sql="insert into tb_trabajadores values(null,?,?,?,?,?)";
				pstm=cn.prepareStatement(sql);
				pstm.setString(1, bean.getDni());
				pstm.setString(2, bean.getNomApe());
				pstm.setString(3, bean.getSexo());
				pstm.setString(4, bean.getCodUnidadOrga());
				pstm.setString(5, bean.getCargo());
				
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
	public int update(Trabajador bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlConexion.getConectar();
			String sql="update tb_trabajadores set dniTrabajador=?,apeNomTrabajador=?,cargo=?,sexo=?,codUniOrg=? where codTrab=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, bean.getDni());
			pstm.setString(2, bean.getNomApe());
			pstm.setString(3, bean.getCargo());
			pstm.setString(4, bean.getSexo());
			pstm.setString(5, bean.getCodUnidadOrga());
			pstm.setInt(6, bean.getCodTrab());
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
			cn=MySqlConexion.getConectar();
			String sql="delete from tb_trabajadores where codTrab=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
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
		Trabajador bean = null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql;
		sql="select * from tb_trabajadores where codTrab=?";
		try {
		cn=MySqlConexion.getConectar();
		pstm=cn.prepareStatement(sql);
		pstm.setInt(1, cod);
		rs=pstm.executeQuery();
		if(rs.next()) {
			bean = new Trabajador();
			bean.setCodTrab(rs.getInt(1));
			bean.setDni(rs.getString(2));
			bean.setNomApe(rs.getString(3));
			bean.setSexo(rs.getString(4));
			bean.setCodUnidadOrga(rs.getString(5));
			bean.setCargo(rs.getString(6));
		}	
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.print("Error en FindById Trabajador");
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
	public List<Trabajador> listAll() {
		List<Trabajador> data=new ArrayList<Trabajador>();
		Trabajador bean;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlConexion.getConectar();
			String sql="call usp_listar_trabajadores";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				bean=new Trabajador();
				bean.setCodTrab(rs.getInt(1));
				bean.setDni(rs.getString(2));
				bean.setNomApe(rs.getString(3));
				bean.setSexo(rs.getString(4));
				bean.setCodUnidadOrga(rs.getString(5));
				bean.setCargo(rs.getString(6));
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
	private boolean isDNIRepeat(Trabajador bean) {
		List<Trabajador> data = this.listAll();
		for(int i = 0; i < data.size(); i++) {
			if(bean.getDni().equals(data.get(i).getDni())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Trabajador> findByCriterios(String dni, String nomApe, String UnidadOrg) {
		List<Trabajador> data = new ArrayList<Trabajador>();
		Trabajador bean = null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql;
		sql="call usp_buscar_trabajador(?,?,?);";
		try {
		cn=MySqlConexion.getConectar();
		pstm=cn.prepareStatement(sql);
		pstm.setString(1, dni);
		pstm.setString(2, nomApe);
		pstm.setString(3, UnidadOrg);
		rs=pstm.executeQuery();
		while(rs.next()) {
			bean=new Trabajador();
			bean.setDni(rs.getString(1));
			bean.setNomApe(rs.getString(2));
			bean.setCodUnidadOrga(rs.getString(3));
			bean.setCodTrab(rs.getInt(4));
			data.add(bean);
		}
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.print("Error en findByCriterios => Trabajador");
		}finally {
			try {
				if(cn!=null) cn.close();
				if(pstm!=null)pstm.close();
				if(rs!=null)rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}
}












