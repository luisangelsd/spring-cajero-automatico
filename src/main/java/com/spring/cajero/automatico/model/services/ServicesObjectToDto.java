package com.spring.cajero.automatico.model.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.cajero.automatico.model.dtos.DtoBillete;
import com.spring.cajero.automatico.model.dtos.DtoMoneda;
import com.spring.cajero.automatico.model.dtos.DtoRetirarSaldo;

@Service(value = "servicesObjectToDto")
public class ServicesObjectToDto implements IServicesObjectToDto {

	
	ObjectMapper mapper = new ObjectMapper();
	
	//-------------------
	

	
	
	@Override
	public Map<String, Object> objectToListObjectListarDenominacionesYCantidad(Object object) throws JsonProcessingException {
		
		
		String datos = this.mapper.writeValueAsString(object);
		
		datos = datos.replace("[", "");
		datos = datos.replace("]", "");
		String [] arrayDatos = datos.split(",");
		
		
		Map<String, Object> map=new HashMap<>();
		List<DtoBillete> listDtoBilletes= new ArrayList<>();
		List<DtoMoneda> listMonedas= new ArrayList<>();
		String [] fila= new String[2];
		
		Boolean estado = true;
		int contadorFila=0;
		
		//-- Aqui recorreremos nuestro arreglo completo para ir creando DTOS (dtosBillete y dtoMoneda) he añadirlos a un List<Object>
		//-- Los datos bienen alternados, los primeros 2 son para dtoMoneda y los otros 2 para un dtoBillete
		//-- Los datos se ven de la siguiente manera, el orden va del 5-8, 20-70, 10-3, etc...
		/*
		 	5	8		20	70
			10	3		50	100
			20	1		100	10
			null null 200	10
		  *
		  */
		for(int i =0; i < arrayDatos.length; i++) {
			
		
			//-- Asignamos valores a la fila
			fila[contadorFila] = arrayDatos[i];
			
			
				//-- Cuando el contador de la Fila llegue a "1" significa que llegamos al numero de elementos que contiene un DTO
				if(contadorFila == 1) {
					
					//-- Aquí nos saltamos el llenar un DTO en caso de que haya valores nulos, pero cambiamos el estado del DTO a llenar
					if (fila[0].equals("null")) {
						
						estado = (estado==true)? false : true;
								
					}else {
							//-- Si es true significa que llenaremos un dtoMoneda
							if (estado==true) {				
								
								DtoMoneda dtoMoneda=new DtoMoneda( Long.parseLong(fila[0]), Long.parseLong(fila[1]));
								listMonedas.add(dtoMoneda);
								estado=false;
								
							}else {
								//-- Si es false significa que llenaremos un dtoBillete
								DtoBillete dtoBillete = new DtoBillete( Long.parseLong(fila[0]), Long.parseLong(fila[1]));
								listDtoBilletes.add(dtoBillete);
								estado=true;
							}
					}
					
					//-- Restauramos contador, para comenzar con una nueva fila fila
					contadorFila = 0;
				}else {
					//-- Aumentamos el contador de la fila
					contadorFila++;
				}
	
		}
		
		map.put("monedas", listMonedas);
		map.put("billetes", listDtoBilletes);
		return map;
	}



	@Override
	public DtoRetirarSaldo objectToDtoRetirarSaldo(Object object) throws JsonProcessingException {
		
		
		DtoRetirarSaldo retirarSaldo = new DtoRetirarSaldo();
		String datos = mapper.writeValueAsString(object);
		
		datos = datos.replace("[", "");
		datos = datos.replace("]", "");
		String[] arrayDatos= datos.split(",");
		
		retirarSaldo.setBillete20(arrayDatos[0]);
		retirarSaldo.setBillete50(arrayDatos[1]);
		retirarSaldo.setBillete100(arrayDatos[2]);
		retirarSaldo.setBillete200(arrayDatos[3]);
		retirarSaldo.setMoneda5(arrayDatos[4]);
		retirarSaldo.setMoneda10(arrayDatos[5]);
		retirarSaldo.setMoneda20(arrayDatos[6]);
		
		return retirarSaldo;
	}



	@Override
	public Long objectToIntegerSaldoActual(Object object) throws JsonProcessingException {
		String dato = mapper.writeValueAsString(object);
		Long saldoActual= Long.valueOf(dato);
		return saldoActual;
	}
	
	
}


