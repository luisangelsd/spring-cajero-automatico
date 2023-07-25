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
@Table(name = "billetes")
public class EntityBillete implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_billete;

	
	@NotNull(message = "La Denominación no puede estar vacia")
	@Column(unique = true)
	private Long denominacion;
	

	private Long cantidad;
	
	
	
	//-- Getters and Setters
	public Long getDenominacion() {return denominacion;	}
	public void setDenominacion(Long denominacion) {this.denominacion = denominacion;	}
	public Long getCantidad() {	return cantidad;	}
	public void setCantidad(Long cantidad) {		this.cantidad = cantidad;	}
	public Long getId_billete() {	return id_billete;	}
	public void setId_billete(Long id_billete) {	this.id_billete = id_billete;}


	private static final long serialVersionUID = 1L;


	
	//-- Constructores
	
	public EntityBillete(@NotNull(message = "La Denominación no puede estar vacia") Long denominacion,
			Long cantidad) {
		this.denominacion = denominacion;
		this.cantidad = cantidad;
	}
	
	
	
	public EntityBillete() {
		
	}

	

}
