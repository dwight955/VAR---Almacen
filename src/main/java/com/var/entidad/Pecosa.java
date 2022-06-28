package com.var.entidad;

public class Pecosa {
	private String referencia,estado,numPec, fecform, fechApro;
	private int codPec, codUsu, codReq; 
	private double total;
	private DetalleRequerimientos detalleReq;
	public DetalleRequerimientos getRequerimientos() {
		return detalleReq;
	}
	public DetalleRequerimientos getDetalleReq() {
		return detalleReq;
	}
	public void setDetalleReq(DetalleRequerimientos detalleReq) {
		this.detalleReq = detalleReq;
	}
	//variables para el listado
	private String nomUnidadSoli,nomUnidadEntr, nombreFormulo, numReq;
	public String getReferencia() {
		return referencia;
	}
	public String getNumReq() {
		return numReq;
	}
	public void setNumReq(String numReq) {
		this.numReq = numReq;
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNumPec() {
		return numPec;
	}
	public void setNumPec(String numPec) {
		this.numPec = numPec;
	}
	public String getFecform() {
		return fecform;
	}
	public void setFecform(String fecform) {
		this.fecform = fecform;
	}
	public String getFechApro() {
		return fechApro;
	}
	public void setFechApro(String fechApro) {
		this.fechApro = fechApro;
	}
	public int getCodPec() {
		return codPec;
	}
	public void setCodPec(int codPec) {
		this.codPec = codPec;
	}
	public int getCodReq() {
		return codReq;
	}
	public void setCodReq(int codReq) {
		this.codReq = codReq;
	}
	public int getCodUsu() {
		return codUsu;
	}
	public void setCodUsu(int codUsu) {
		this.codUsu = codUsu;
	}
	
}
