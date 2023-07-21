package com.spring.cajero.automatico.model.dtos;

import java.io.Serializable;

public class DtoRequestUpdateMonedasBilletes implements Serializable{
	
	
	
	private static final long serialVersionUID = 1L;
	
	private Integer billete20;
	private Integer billete50;
	private Integer billete100;
	private Integer billete200;
	private Integer moneda5;
	private Integer moneda10;
	private Integer moneda20;
	
	//--
	public Integer getBillete20() {
		return billete20;
	}
	public void setBillete20(Integer billete20) {
		this.billete20 = billete20;
	}
	public Integer getBillete50() {
		return billete50;
	}
	public void setBillete50(Integer billete50) {
		this.billete50 = billete50;
	}
	public Integer getBillete100() {
		return billete100;
	}
	public void setBillete100(Integer billete100) {
		this.billete100 = billete100;
	}
	public Integer getBillete200() {
		return billete200;
	}
	public void setBillete200(Integer billete200) {
		this.billete200 = billete200;
	}
	public Integer getMoneda5() {
		return moneda5;
	}
	public void setMoneda5(Integer moneda5) {
		this.moneda5 = moneda5;
	}
	public Integer getMoneda10() {
		return moneda10;
	}
	public void setMoneda10(Integer moneda10) {
		this.moneda10 = moneda10;
	}
	public Integer getMoneda20() {
		return moneda20;
	}
	public void setMoneda20(Integer moneda20) {
		this.moneda20 = moneda20;
	}
	
	//--
	
	
	

}
