package com.spring.cajero.automatico.model.services;

import com.spring.cajero.automatico.model.dtos.DtoRequestUpdateMonedasBilletes;

public interface IServices {
	
	public void updateCantidadbyMonedasBilletes(String tipo, Integer denominacion, Integer cantidad);
	public Object listarSaldoDenominacionCantidad();
	public Object retirarSaldo(Integer cantidad);
	public Object getSaldoActual();
	public void updateMonedasBilletes( DtoRequestUpdateMonedasBilletes dto);


}
