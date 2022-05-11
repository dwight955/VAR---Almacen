package com.var.interfaces;

import com.var.entidad.Usuario;

public interface UsuarioDAO {
	public Usuario iniciarSesion(String username, String clave);
}
