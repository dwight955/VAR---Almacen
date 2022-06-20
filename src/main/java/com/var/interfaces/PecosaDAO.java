package com.var.interfaces;

import java.util.List;

import com.var.dto.PecosaDTO;

public interface PecosaDAO {
	public String codigoCorrelativo();
	public List<PecosaDTO> listAll();
}
