package com.spring.cajero.automatico.model.repositories;


import org.springframework.web.bind.annotation.PathVariable;




public interface IRepositoryEntityManager {
	
	
	public Object listarSaldoDenominacionCantidad();
	public void updateCantidadbyMonedasBilletes(@PathVariable String tipo, @PathVariable Integer denominacion, @PathVariable Integer cantidad);
	public  Object retirarSaldo(@PathVariable Integer cantidad);
	public Object getSaldoActual();
	public void  updateMonedasBilletes(@PathVariable Integer bi20, @PathVariable Integer bi50 ,@PathVariable Integer bi100, @PathVariable Integer bi200,
									@PathVariable Integer mo5, @PathVariable Integer mo10, @PathVariable Integer mo20);

}
