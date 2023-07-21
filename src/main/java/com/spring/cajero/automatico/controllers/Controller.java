package com.spring.cajero.automatico.controllers;


import java.util.HashMap;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.cajero.automatico.exceptions.ExceptionSaldoInsuficiente;
import com.spring.cajero.automatico.model.dtos.DtoRetirarSaldo;
import com.spring.cajero.automatico.model.services.IServices;
import com.spring.cajero.automatico.model.services.IServicesObjectToDto;


@CrossOrigin({"*"})
@RestController
public class Controller {
	
	
	//-- Inyección Servicios
	@Autowired
	@Qualifier(value = "services")
	private IServices services;
	
	
	@Autowired
	@Qualifier(value = "servicesObjectToDto")
	private IServicesObjectToDto servicesObjectDto;
	
	
	
	ObjectMapper mapper = new ObjectMapper();
	
	//-- EndPoints
	
	
	@GetMapping("/saldo-actual")
	@ResponseStatus(HttpStatus.OK)
	public Map<String, Object> saldoActual() throws JsonProcessingException{
		
		Object object= this.services.getSaldoActual();
		Integer saldoActual = this.servicesObjectDto.objectToIntegerSaldoActual(object);
		
		Map<String, Object> map =new HashMap<>();
		map.put("saldo_actual", saldoActual);
		return map;
	}
	
	
	
	@GetMapping("/retirar-saldo/{cantidad}")
	@ResponseStatus(HttpStatus.OK)
	public DtoRetirarSaldo retirarSaldo(@PathVariable Integer cantidad) throws JsonProcessingException{	
		
		//-- Validar que cuentes con el saldo suficiente
		Object objectSaldo= this.services.getSaldoActual();
		Integer saldoActual = this.servicesObjectDto.objectToIntegerSaldoActual(objectSaldo);
		
		if( saldoActual < cantidad) {
			throw new ExceptionSaldoInsuficiente("Lo sentimos no tienes saldo suficiente");
		}
		
		Object object = this.services.retirarSaldo(cantidad);
		return this.servicesObjectDto.objectToDtoRetirarSaldo(object);
		
	}
	
	
	
	@GetMapping("/listar-saldo")
	@ResponseStatus(HttpStatus.OK)
	public Map<String, Object> listarSaldo() throws JsonProcessingException{
		Object  object = this.services.listarSaldoDenominacionCantidad();
		return  this.servicesObjectDto.objectToListObjectListarDenominacionesYCantidad(object);
	}
		
	

}
