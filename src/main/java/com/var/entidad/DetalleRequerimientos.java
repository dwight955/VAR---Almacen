package com.var.entidad;

public class DetalleRequerimientos{
	private int  cant;
	private String  codBien,numReq,uniMed;
	
	//varibales extras
	private String descripcion;
	private double importe,preUni,subTotal;
	
	public String getNumReq() {
		return numReq;
	}
	public void setNumReq(String numReq) {
		this.numReq = numReq;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public int getCant() {
		return cant;
	}
	public void setCant(int cant) {
		this.cant = cant;
	}
	public String getCodBien() {
		return codBien;
	}
	public void setCodBien(String codBien) {
		this.codBien = codBien;
	}
	public double getPreUni() {
		return preUni;
	}
	public void setPreUni(double preUni) {
		this.preUni = preUni;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public String getUniMed() {
		return uniMed;
	}
	public void setUniMed(String uniMed) {
		this.uniMed = uniMed;
	}
	
	
}
