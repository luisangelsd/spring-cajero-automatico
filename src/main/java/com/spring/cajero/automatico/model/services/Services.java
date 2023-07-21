package com.spring.cajero.automatico.model.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



import com.spring.cajero.automatico.model.repositories.IRepositoryEntityManager;

@Service(value = "services")
public class Services implements IServices{

	
	//-- Inyección Repository
	@Autowired
	@Qualifier("repositoryEntityManager")
	private IRepositoryEntityManager repositoryEntityManager;
	
	
	
	//-- Metodos
	
	@Override
	public void updateCantidadbyMonedasBilletes(String tipo, Integer denominacion, Integer cantidad) {
		//this.iCrudRepository.updateCantidadbyMonedasBilletes(tipo, denominacion, cantidad);	
	}

	@Override
	public  Object listarSaldoDenominacionCantidad() {	
		return this.repositoryEntityManager.listarSaldoDenominacionCantidad();		
	}

	@Override
	public Object retirarSaldo(Integer cantidad) {
 
		return this.repositoryEntityManager.retirarSaldo(cantidad);
	}

	@Override
	public Object getSaldoActual() {

		return this.repositoryEntityManager.getSaldoActual();
	}

}
