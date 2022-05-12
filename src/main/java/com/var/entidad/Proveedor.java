package com.var.entidad;

public class Proveedor {
	private int codProv;
	private String rzSoc, estado, condic, direc, codDis,nroRuc,telf;
	
	public String getNroRuc() {
		return nroRuc;
	}
	public void setNroRuc(String nroRuc) {
		this.nroRuc = nroRuc;
	}
	public int getCodProv() {
		return codProv;
	}
	public void setCodProv(int codProv) {
		this.codProv = codProv;
	}
	public String getTelf() {
		return telf;
	}
	public void setTelf(String telf) {
		this.telf = telf;
	}
	public String getRzSoc() {
		return rzSoc;
	}
	public void setRzSoc(String rzSoc) {
		this.rzSoc = rzSoc;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCondic() {
		return condic;
	}
	public void setCondic(String condic) {
		this.condic = condic;
	}
	public String getDirec() {
		return direc;
	}
	public void setDirec(String direc) {
		this.direc = direc;
	}
	public String getCodDis() {
		return codDis;
	}
	public void setCodDis(String codDis) {
		this.codDis = codDis;
	}
	
}
