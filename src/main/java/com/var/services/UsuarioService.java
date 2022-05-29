package com.var.services;

import com.var.entidad.Usuario;
import com.var.fabrica.DAOFactory;
import com.var.interfaces.UsuarioDAO;

public class UsuarioService {
	private DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	private UsuarioDAO objUsuario = fabrica.getUsuarioDAO();
	
	public Usuario SignIn(String username, String clave) {
		return objUsuario.iniciarSesion(username, clave);
	}
}
