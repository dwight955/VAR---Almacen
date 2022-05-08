package com.var.entidad;

public class Trabajador {
	private String nomApe, cargo,sexo, codUnidadOrga;
	private int dni;
	
	
	public String getCodUnidadOrga() {
		return codUnidadOrga;
	}
	public void setCodUnidadOrga(String codUnidadOrga) {
		this.codUnidadOrga = codUnidadOrga;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNomApe() {
		return nomApe;
	}
	public void setNomApe(String nomApe) {
		this.nomApe = nomApe;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
}
