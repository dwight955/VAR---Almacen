package com.var.entidad;

public class DetallePecosa {
	private String codBien,desc,uniMed;
	private int numPecosa,nroOC,cant;
	private double precUnit,subTotal;
	
	public String getCodBien() {
		return codBien;
	}
	public void setCodBien(String codBien) {
		this.codBien = codBien;
	}
	public String getUniMed() {
		return uniMed;
	}
	public void setUniMed(String uniMed) {
		this.uniMed = uniMed;
	}
	public int getNumPecosa() {
		return numPecosa;
	}
	public void setNumPecosa(int numPecosa) {
		this.numPecosa = numPecosa;
	}
	public int getNroOC() {
		return nroOC;
	}
	public void setNroOC(int nroOC) {
		this.nroOC = nroOC;
	}
	public int getCant() {
		return cant;
	}
	public void setCant(int cant) {
		this.cant = cant;
	}
	public double getPrecUnit() {
		return precUnit;
	}
	public void setPrecUnit(double precUnit) {
		this.precUnit = precUnit;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
}
