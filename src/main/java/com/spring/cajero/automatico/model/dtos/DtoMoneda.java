package com.spring.cajero.automatico.model.dtos;

import java.io.Serializable;

public class DtoMoneda implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long mo_denominacion;
	private Long mo_cantidad;
	
	//--
	public DtoMoneda(Long mo_denominacion, Long mo_cantidad) {
		super();
		this.mo_denominacion = mo_denominacion;
		this.mo_cantidad = mo_cantidad;
	}
	
	public DtoMoneda() {}
	
	//----
	public Long getMo_denominacion() {
		return mo_denominacion;
	}

	public void setMo_denominacion(Long mo_denominacion) {
		this.mo_denominacion = mo_denominacion;
	}
	public Long getMo_cantidad() {
		return mo_cantidad;
	}
	public void setMo_cantidad(Long mo_cantidad) {
		this.mo_cantidad = mo_cantidad;
	}
	
	

}
