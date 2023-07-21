package com.spring.cajero.automatico.model.repositories;


import org.springframework.web.bind.annotation.PathVariable;



public interface IRepositoryEntityManager {
	
	
	public Object listarSaldoDenominacionCantidad();
	public void updateCantidadbyMonedasBilletes(@PathVariable String tipo, @PathVariable Integer denominacion, @PathVariable Integer cantidad);
	public  Object retirarSaldo(@PathVariable Integer cantidad);
	public Object getSaldoActual();

}
