package com.spring.cajero.automatico.model.dtos;

import java.io.Serializable;

public class DtoBillete implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private Long bi_denominacion;
	private Long bi_cantidad;
	
	
	//--
	public DtoBillete(Long bi_denominacion, Long bi_cantidad) {
		super();
		this.bi_denominacion = bi_denominacion;
		this.bi_cantidad = bi_cantidad;
	}

	//--
	public Long getBi_denominacion() {
		return bi_denominacion;
	}


	public void setBi_denominacion(Long bi_denominacion) {
		this.bi_denominacion = bi_denominacion;
	}


	public Long getBi_cantidad() {
		return bi_cantidad;
	}


	public void setBi_cantidad(Long bi_cantidad) {
		this.bi_cantidad = bi_cantidad;
	}
	

	
	

}
