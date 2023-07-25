package com.spring.cajero.automatico.model.dtos;

import java.io.Serializable;

public class DtoRequestUpdateMonedasBilletes implements Serializable{
	
	
	
	private static final long serialVersionUID = 1L;
	
	private Long billete20;
	private Long billete50;
	private Long billete100;
	private Long billete200;
	private Long moneda5;
	private Long moneda10;
	private Long moneda20;
	
	//--
	public Long getBillete20() {
		return billete20;
	}
	public void setBillete20(Long billete20) {
		this.billete20 = billete20;
	}
	public Long getBillete50() {
		return billete50;
	}
	public void setBillete50(Long billete50) {
		this.billete50 = billete50;
	}
	public Long getBillete100() {
		return billete100;
	}
	public void setBillete100(Long billete100) {
		this.billete100 = billete100;
	}
	public Long getBillete200() {
		return billete200;
	}
	public void setBillete200(Long billete200) {
		this.billete200 = billete200;
	}
	public Long getMoneda5() {
		return moneda5;
	}
	public void setMoneda5(Long moneda5) {
		this.moneda5 = moneda5;
	}
	public Long getMoneda10() {
		return moneda10;
	}
	public void setMoneda10(Long moneda10) {
		this.moneda10 = moneda10;
	}
	public Long getMoneda20() {
		return moneda20;
	}
	public void setMoneda20(Long moneda20) {
		this.moneda20 = moneda20;
	}
	
	//--
	
	
	

}
