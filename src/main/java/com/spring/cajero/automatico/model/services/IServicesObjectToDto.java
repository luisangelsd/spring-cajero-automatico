package com.spring.cajero.automatico.model.services;


import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.cajero.automatico.model.dtos.DtoRetirarSaldo;

public interface IServicesObjectToDto {
	
	 
	public Map<String, Object> objectToListObjectListarDenominacionesYCantidad(Object object) throws JsonProcessingException; 
	public DtoRetirarSaldo objectToDtoRetirarSaldo(Object object) throws JsonProcessingException;
	public Long objectToIntegerSaldoActual(Object object) throws JsonProcessingException;
	

}
