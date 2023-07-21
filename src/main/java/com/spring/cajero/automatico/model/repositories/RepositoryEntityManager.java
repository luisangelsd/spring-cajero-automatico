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

	
	@Transactional
	@Override
	public void updateMonedasBilletes(Integer bi20, Integer bi50, Integer bi100, Integer bi200, Integer mo5,
			Integer mo10, Integer mo20) {
		this.entityManager.createNativeQuery("CALL updateMonedasBilletes( :bi_20 , :bi_50, :bi_100, :bi_200, :mo_5, :mo_10, :mo_20) ")
		.setParameter("bi_20", bi20)
		.setParameter("bi_50", bi50)
		.setParameter("bi_100", bi100)
		.setParameter("bi_200", bi200)
		.setParameter("mo_5", mo5)
		.setParameter("mo_10", mo10)
		.setParameter("mo_20", mo20).executeUpdate();
		
	}

}
