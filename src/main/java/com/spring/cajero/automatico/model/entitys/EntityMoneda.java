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
	private Integer id_moneda;
	
	@NotNull(message = "La denominación no puede estar vacia")
	@Column(unique = true)
	private Integer denominacion;
	
	
	private Integer cantidad;
	
		

	//-- Gettes and Setters
	public Integer getDenominacion() {	return denominacion;	}
	public void setDenominacion(Integer denominacion) {this.denominacion = denominacion;	}
	public Integer getCantidad() {		return cantidad;	}
	public void setCantidad(Integer cantidad) {this.cantidad = cantidad;	}
	public Integer getId_moneda() {	return id_moneda;	}
	public void setId_moneda(Integer id_moneda) {	this.id_moneda = id_moneda;	}

	
	private static final long serialVersionUID = 1L;




	//-- Constructores
	public EntityMoneda(@NotNull(message = "La denominación no puede estar vacia") Integer denominacion,
			@NotNull(message = "La cantidad no puede estar vacia") Integer cantidad) {
		this.denominacion = denominacion;
		this.cantidad = cantidad;
	}
	
	public EntityMoneda() {

	}
	
	
	

	
}
