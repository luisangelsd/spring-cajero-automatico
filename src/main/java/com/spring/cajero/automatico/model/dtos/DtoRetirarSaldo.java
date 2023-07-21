package com.spring.cajero.automatico.model.dtos;

import java.io.Serializable;

public class DtoRetirarSaldo implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private Object billete20;
	private Object billete50;
	private Object billete100;
	private Object billete200;
	private Object moneda5;
	private Object moneda10;
	private Object moneda20;
	
	//-- Constructors
	public DtoRetirarSaldo() {
		
	}
	
	
	//-- Getters and Setters
	public Object getBillete20() {
		return billete20;
	}
	public void setBillete20(Object billete20) {
		this.billete20 = billete20;
	}
	public Object getBillete50() {
		return billete50;
	}
	public void setBillete50(Object billete50) {
		this.billete50 = billete50;
	}
	public Object getBillete100() {
		return billete100;
	}
	public void setBillete100(Object billete100) {
		this.billete100 = billete100;
	}
	public Object getBillete200() {
		return billete200;
	}
	public void setBillete200(Object billete200) {
		this.billete200 = billete200;
	}
	public Object getMoneda5() {
		return moneda5;
	}
	public void setMoneda5(Object moneda5) {
		this.moneda5 = moneda5;
	}
	public Object getMoneda10() {
		return moneda10;
	}
	public void setMoneda10(Object moneda10) {
		this.moneda10 = moneda10;
	}
	public Object getMoneda20() {
		return moneda20;
	}
	public void setMoneda20(Object moneda20) {
		this.moneda20 = moneda20;
	}
	
	

	

}
