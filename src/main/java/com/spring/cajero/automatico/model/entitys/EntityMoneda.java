package com.spring.cajero.automatico.model.entitys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;



@Entity
@Table(name = "MONEDAS")
public class EntityMoneda implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_moneda;
	
	@NotNull(message = "La denominación no puede estar vacia")
	@Column(unique = true)
	private Long denominacion;
	
	
	private Long cantidad;
	
		

	//-- Gettes and Setters
	public Long getDenominacion() {	return denominacion;	}
	public void setDenominacion(Long denominacion) {this.denominacion = denominacion;	}
	public Long getCantidad() {		return cantidad;	}
	public void setCantidad(Long cantidad) {this.cantidad = cantidad;	}
	public Long getId_moneda() {	return id_moneda;	}
	public void setId_moneda(Long id_moneda) {	this.id_moneda = id_moneda;	}

	
	private static final long serialVersionUID = 1L;




	//-- Constructores
	public EntityMoneda(@NotNull(message = "La denominación no puede estar vacia") Long denominacion,
			@NotNull(message = "La cantidad no puede estar vacia") Long cantidad) {
		this.denominacion = denominacion;
		this.cantidad = cantidad;
	}
	
	public EntityMoneda() {

	}
	
	
	

	
}
