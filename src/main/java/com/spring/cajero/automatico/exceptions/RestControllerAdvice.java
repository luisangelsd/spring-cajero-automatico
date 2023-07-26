package com.spring.cajero.automatico.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {
	
	//-- Variables Globales
		Map<String, Object> errors;
		Map<String, Object> responseBody;
		

		
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(ExceptionSaldoInsuficiente.class)
	public Map<String, Object > exceptionSaldoInsuficiente(ExceptionSaldoInsuficiente e){
		
		this.responseBody=new HashMap<>();
        this.errors=new HashMap<>();
        
        //-- Preparando Errores
        errors.put("mensaje", e.getMessage());
        
        //-- Preparando ResponseBody
        this.responseBody.put("errors", errors);
		this.responseBody.put("timestamp", LocalDateTime.now());
		this.responseBody.put("code", e.hashCode());
		this.responseBody.put("send", "RestControllerAdvice");	
        return  this.responseBody;
	}
	
	//---------------
	
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(RuntimeException.class)
	public Map<String, Object> RuntimeException(Exception e){
		
		this.responseBody=new HashMap<>();
        this.errors=new HashMap<>();
        
        //-- Preparando Errores
        errors.put("mensaje", e.getMessage());
        errors.put("localizedMessage", e.getLocalizedMessage());
        
        //-- Preparando ResponseBody
        this.responseBody.put("errors", errors);
		this.responseBody.put("timestamp", LocalDateTime.now());
		this.responseBody.put("code", e.hashCode());
		this.responseBody.put("send", "RestControllerAdvice");	
        return  this.responseBody;
	}
	
	//---------------
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public Map<String, Object> exception(Exception e){
		
		this.responseBody=new HashMap<>();
        this.errors=new HashMap<>();
        
        //-- Preparando Errores
        errors.put("mensaje", e.getMessage());
        errors.put("localizedMessage", e.getLocalizedMessage());
        
        //-- Preparando ResponseBody
        this.responseBody.put("errors", errors);
		this.responseBody.put("timestamp", LocalDateTime.now());
		this.responseBody.put("code", e.hashCode());
		this.responseBody.put("send", "RestControllerAdvice");	
        return  this.responseBody;
	}

}
