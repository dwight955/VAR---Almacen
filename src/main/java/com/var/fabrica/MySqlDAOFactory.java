package com.var.fabrica;

import com.var.dao.MySqlBienesDAO;
import com.var.dao.MySqlCondicionDAO;
import com.var.dao.MySqlDetalleRequerimientoDAO;
import com.var.dao.MySqlProveedorDAO;
import com.var.dao.MySqlRequerimientoDAO;
import com.var.dao.MySqlTrabajadorDAO;
import com.var.dao.MySqlUsuarioDAO;
import com.var.dao.MySqlUsuarioRequerimientoDao;
import com.var.interfaces.BienesDAO;
import com.var.interfaces.CondicionDAO;
import com.var.interfaces.DetalleRequerimientoDAO;
import com.var.interfaces.ProveedorDAO;
import com.var.interfaces.RequerimientoDAO;
import com.var.interfaces.TrabajadorDAO;
import com.var.interfaces.UsuarioDAO;
import com.var.interfaces.UsuarioRequerimientoDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public BienesDAO getBienesDAO() {
		// TODO Auto-generated method stub
		return new MySqlBienesDAO();
	}

	@Override
	public ProveedorDAO getProveedorDAO() {
		// TODO Auto-generated method stub
		return new MySqlProveedorDAO();
	}

	@Override
	public TrabajadorDAO getTrabajadorDAO() {
		// TODO Auto-generated method stub
		return new MySqlTrabajadorDAO();
	}

	@Override
	public CondicionDAO getCondicionDAO() {
		// TODO Auto-generated method stub
		return new MySqlCondicionDAO();
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new MySqlUsuarioDAO();
	}

	@Override
	public RequerimientoDAO getRequerimientoDAO() {
		return new MySqlRequerimientoDAO();
	}

	@Override
	public DetalleRequerimientoDAO getDetalleRequerimientoDAO() {
		return new MySqlDetalleRequerimientoDAO();
	}

	@Override
	public UsuarioRequerimientoDAO getUsuarioRequerimientoDAO() {
		return new MySqlUsuarioRequerimientoDao();
	}

}
