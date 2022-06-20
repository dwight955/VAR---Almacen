package com.var.entidad;

public class Pecosa {
	private String referencia,estado,numPec, fecform, fechApro;
	private int codPec, codReq, codUsu; 
	private double total;
	
	//variables para el listado
	private String nomUnidadSoli,nomUnidadEntr, nombreFormulo;
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getNomUnidadEntr() {
		return nomUnidadEntr;
	}
	public void setNomUnidadEntr(String nomUnidadEntr) {
		this.nomUnidadEntr = nomUnidadEntr;
	}
	public String getNomUnidadSoli() {
		return nomUnidadSoli;
	}
	public void setNomUnidadSoli(String nomUnidadSoli) {
		this.nomUnidadSoli = nomUnidadSoli;
	}
	public String getNombreFormulo() {
		return nombreFormulo;
	}
	public void setNombreFormulo(String nombreFormulo) {
		this.nombreFormulo = nombreFormulo;
	}
}
