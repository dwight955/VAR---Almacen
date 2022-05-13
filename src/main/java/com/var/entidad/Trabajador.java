package com.var.entidad;

public class Trabajador {
	private String nomApe,cargo,sexo,codUnidadOrga,dni;
	private int codTrab ;
	
	
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getCodTrab() {
		return codTrab;
	}
	public void setCodTrab(int codTrab) {
		this.codTrab = codTrab;
	}

}
