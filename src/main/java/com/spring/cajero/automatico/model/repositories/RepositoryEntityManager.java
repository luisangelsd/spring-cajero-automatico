package com.spring.cajero.automatico.model.repositories;



import org.springframework.stereotype.Repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository(value = "repositoryEntityManager") 
public class RepositoryEntityManager implements IRepositoryEntityManager {

	
	
	// ------- Inyeccion Services
	@PersistenceContext
    private EntityManager entityManager;
	
	
	// ------- Methods
	
	
	@Override
	@Transactional()
	public Object listarSaldoDenominacionCantidad() {
		return  this.entityManager.createNativeQuery(" SELECT * FROM listar_saldo_actual_y_denominaciones").getResultList();
	}

	@Override
	public void updateCantidadbyMonedasBilletes (String tipo, Integer denominacion, Integer cantidad) {
		// TODO Auto-generated method stub
		
	}
	

	
	@Override
	public Object retirarSaldo(Integer cantidad) {	
		return  
				this.entityManager.createNativeQuery("CALL retirar_dinero( :cantidad ); ")
				.setParameter("cantidad", cantidad)
				.getSingleResult();
	}

	
	@Override
	public Object getSaldoActual() {
		Object saldo = this.entityManager.createNativeQuery("select get_saldo_actual()").getSingleResult();
		return saldo;
	}

}
