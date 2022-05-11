package com.var.entidad;

public class Usuario {
	private String dniUsu, nombre, apellido, cargo, nomUnidadOrganica;
	private int codUsuario;
	
	public String getDniUsu() {
		return dniUsu;
	}
	public void setDniUsu(String dniTrab) {
		this.dniUsu = dniTrab;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getNomUnidadOrganica() {
		return nomUnidadOrganica;
	}
	public void setNomUnidadOrganica(String codUnidadOrganica) {
		this.nomUnidadOrganica = codUnidadOrganica;
	}
	public int getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}
	
}
