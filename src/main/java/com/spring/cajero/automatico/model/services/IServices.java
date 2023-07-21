package com.spring.cajero.automatico.model.services;



public interface IServices {
	
	public void updateCantidadbyMonedasBilletes(String tipo, Integer denominacion, Integer cantidad);
	public Object listarSaldoDenominacionCantidad();
	public Object retirarSaldo(Integer cantidad);
	public Object getSaldoActual();


}
