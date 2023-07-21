package com.spring.cajero.automatico.model.dtos;

import java.io.Serializable;

public class DtoBillete implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private Integer bi_denominacion;
	private Integer bi_cantidad;
	
	
	//--
	public DtoBillete(Integer bi_denominacion, Integer bi_cantidad) {
		super();
		this.bi_denominacion = bi_denominacion;
		this.bi_cantidad = bi_cantidad;
	}

	//--
	public Integer getBi_denominacion() {
		return bi_denominacion;
	}


	public void setBi_denominacion(Integer bi_denominacion) {
		this.bi_denominacion = bi_denominacion;
	}


	public Integer getBi_cantidad() {
		return bi_cantidad;
	}


	public void setBi_cantidad(Integer bi_cantidad) {
		this.bi_cantidad = bi_cantidad;
	}
	

	
	

}
