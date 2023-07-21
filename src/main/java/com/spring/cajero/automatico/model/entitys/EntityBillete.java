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
	private Integer id_billete;

	
	@NotNull(message = "La Denominación no puede estar vacia")
	@Column(unique = true)
	private Integer denominacion;
	

	private Integer cantidad;
	
	
	
	//-- Getters and Setters
	public Integer getDenominacion() {return denominacion;	}
	public void setDenominacion(Integer denominacion) {this.denominacion = denominacion;	}
	public Integer getCantidad() {	return cantidad;	}
	public void setCantidad(Integer cantidad) {		this.cantidad = cantidad;	}
	public Integer getId_billete() {	return id_billete;	}
	public void setId_billete(Integer id_billete) {	this.id_billete = id_billete;}


	private static final long serialVersionUID = 1L;


	
	//-- Constructores
	
	public EntityBillete(@NotNull(message = "La Denominación no puede estar vacia") Integer denominacion,
			Integer cantidad) {
		this.denominacion = denominacion;
		this.cantidad = cantidad;
	}
	
	
	
	public EntityBillete() {
		
	}

	

}
