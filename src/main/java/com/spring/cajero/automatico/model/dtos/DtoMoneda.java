package com.spring.cajero.automatico.model.dtos;

import java.io.Serializable;

public class DtoMoneda implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer mo_denominacion;
	private Integer mo_cantidad;
	
	//--
	public DtoMoneda(Integer mo_denominacion, Integer mo_cantidad) {
		super();
		this.mo_denominacion = mo_denominacion;
		this.mo_cantidad = mo_cantidad;
	}
	
	public DtoMoneda() {}
	
	//----
	public Integer getMo_denominacion() {
		return mo_denominacion;
	}

	public void setMo_denominacion(Integer mo_denominacion) {
		this.mo_denominacion = mo_denominacion;
	}
	public Integer getMo_cantidad() {
		return mo_cantidad;
	}
	public void setMo_cantidad(Integer mo_cantidad) {
		this.mo_cantidad = mo_cantidad;
	}
	
	

}
