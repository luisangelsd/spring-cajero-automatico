package com.spring.cajero.automatico.model.repositories;


import org.springframework.web.bind.annotation.PathVariable;




public interface IRepositoryEntityManager {
	
	
	public Object listarSaldoDenominacionCantidad();
	public void updateCantidadbyMonedasBilletes(@PathVariable String tipo, @PathVariable Long denominacion, @PathVariable Long cantidad);
	public  Object retirarSaldo(@PathVariable Long cantidad);
	public Object getSaldoActual();
	public void  updateMonedasBilletes(@PathVariable Long bi20, @PathVariable Long bi50 ,@PathVariable Long bi100, @PathVariable Long bi200,
									@PathVariable Long mo5, @PathVariable Long mo10, @PathVariable Long mo20);

}
