package com.spring.cajero.automatico.model.services;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.cajero.automatico.model.dtos.DtoRequestUpdateMonedasBilletes;
import com.spring.cajero.automatico.model.repositories.IRepositoryEntityManager;

@Service(value = "services")
public class Services implements IServices{

	
	//-- Inyección Repository
	@Autowired
	@Qualifier("repositoryEntityManager")
	private IRepositoryEntityManager repositoryEntityManager;
	
	
	
	//-- Metodos
	
	@Override
	public void updateCantidadbyMonedasBilletes(String tipo, Long denominacion, Long cantidad) {
		//this.iCrudRepository.updateCantidadbyMonedasBilletes(tipo, denominacion, cantidad);	
	}

	@Override
	public  Object listarSaldoDenominacionCantidad() {	
		return this.repositoryEntityManager.listarSaldoDenominacionCantidad();		
	}

	@Override
	public Object retirarSaldo(Long cantidad) {
 
		return this.repositoryEntityManager.retirarSaldo(cantidad);
	}

	@Override
	public Object getSaldoActual() {

		return this.repositoryEntityManager.getSaldoActual();
	}

	@Override
	public void updateMonedasBilletes(DtoRequestUpdateMonedasBilletes dto) {
		this.repositoryEntityManager.updateMonedasBilletes(dto.getBillete20(),
				dto.getBillete50(),
				dto.getBillete100(), 
				dto.getBillete200(),
				dto.getMoneda5(),
				dto.getMoneda10(),
				dto.getMoneda20());
		
		
	}

	//--
	Long cantidadRestante = 0L;
	@Override
	public Boolean validaSiLaCantidadEsValida(Long cantidad) {
		
		  List<Long> denominaciones = new ArrayList<>();
	        denominaciones.add(200L);
	        denominaciones.add(100L);
	        denominaciones.add(50L);
	        denominaciones.add(20L);
	        denominaciones.add(10L);
	        denominaciones.add(5L);
	        this.cantidadRestante = cantidad;


	        denominaciones.forEach( valor ->{

	            while(cantidadRestante >= valor) {
	                cantidadRestante = cantidadRestante - valor;
	            }


	        });

	        if (this.cantidadRestante == 0) {
	            return true;
	        }

	        return false;
	}

}
