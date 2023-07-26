-- ---------------INSERT--------------------------
 INSERT INTO MONEDAS (denominacion, cantidad) VALUES(5,8);
 INSERT INTO MONEDAS (denominacion, cantidad) VALUES(10,3);
 INSERT INTO MONEDAS (denominacion, cantidad) VALUES(20,1);
 INSERT INTO BILLETES (denominacion, cantidad) VALUES(20,70);
 INSERT INTO BILLETES (denominacion, cantidad) VALUES(50,100);
 INSERT INTO BILLETES (denominacion, cantidad) VALUES(100,10);
 INSERT INTO BILLETES (denominacion, cantidad) VALUES(200,10);
 
 
 
 // --- FUCTIONES, VIEWS AND PROCEDURES

 /*
-- Lista Denominaciones + Cantidad de Billetes y Monedas
CREATE OR REPLACE VIEW listar_saldo_actual_y_denominaciones AS
SELECT	
m.denominacion AS mo_denominacion,
m.cantidad AS mo_cantidad,
b.denominacion AS bi_denominacion,
b.cantidad AS bi_cantidad
FROM monedas m RIGHT JOIN billetes b ON id_moneda = id_billete;

-- -----------------------------------------------------
-- Obtiene el saldo actal
DROP FUNCTION get_saldo_actual;
DELIMITER $$
CREATE FUNCTION get_saldo_actual ( )
RETURNS INT 
deterministic
	BEGIN	
		DECLARE saldo_actual_monedas INT;
		DECLARE saldo_actual_billetes INT;
        DECLARE saldo_total INT;
        
        SELECT SUM(denominacion * cantidad) FROM monedas INTO saldo_actual_monedas;
        SELECT SUM(denominacion* cantidad) FROM billetes INTO saldo_actual_billetes;
        SET saldo_total= saldo_actual_monedas + saldo_actual_billetes;
	    RETURN saldo_total;
END $$
DELIMITER ;
-- select get_saldo_actual();


-- -----------------------------------------------------
-- Actualiza cantidad de las monedas y billetes
	DELIMITER $$
		CREATE PROCEDURE updateMonedasBilletes( bi_20 INT, bi_50 INT, bi_100 INT, bi_200 INT, mo_5 INT, mo_10 INT, mo_20 INT  )
        BEGIN
			UPDATE billetes SET cantidad = (cantidad + bi_20) WHERE denominacion = 20;
            UPDATE billetes SET cantidad = (cantidad + bi_50) WHERE denominacion = 50;
            UPDATE billetes SET cantidad = (cantidad + bi_100) WHERE denominacion = 100;
            UPDATE billetes SET cantidad = (cantidad + bi_200) WHERE denominacion = 200;
            
            UPDATE monedas SET cantidad = (cantidad + mo_5) WHERE denominacion=5;
			UPDATE monedas SET cantidad = (cantidad + mo_10) WHERE denominacion=10;
            UPDATE monedas SET cantidad = (cantidad + mo_20) WHERE denominacion=20;
            
        END $$
	DELIMITER ;
    
    DROP PROCEDURE updateMonedasBilletes;
    call updateMonedasBilletes(1, 1, 1, 1, 1, 1, 1);





-- -----------------------------------------------------
-- Retirar dinero
		-- Validar que tenga saldo disponible
		-- Solicitar la cantidad a retirar
		-- Posterior a la confirmación indicar en listado como será entregada la cantidad solicitada (denominaciones de monedas y billetes)

DELIMITER $$
	CREATE PROCEDURE retirar_dinero(in_cantidad INT)
   
    BEGIN
          DECLARE exception_saldo_insuficiente CONDITION FOR SQLSTATE '22003';
          DECLARE exception_monedas_o_billetes_insuficientes CONDITION FOR SQLSTATE '22004';
     
		-- Variables y cursores: OK
		DECLARE _denominacion, _cantidad, saldo_total_actual, saldo_acumulado INT default 0; -- Validar saldo
        DECLARE _done INT;										 -- Recorrer cursor
        DECLARE bi_20, bi_50, bi_100, bi_200 INT default 0;		-- Cantidad billetes
        DECLARE mo_5, mo_10, mo_20 INT default 0;				-- Cantidad monedas
        DECLARE aux_loop_cantidad INT DEFAULT 0;

        DECLARE cursor_billetes CURSOR FOR SELECT denominacion, cantidad FROM billetes ORDER BY denominacion DESC;
        DECLARE cursor_monedas CURSOR FOR SELECT denominacion, cantidad FROM monedas ORDER BY denominacion DESC;
		DECLARE CONTINUE HANDLER FOR NOT FOUND SET _done = 1; 
        
        -- == Validando saldo: OK
        SET saldo_total_actual:= get_saldo_actual();
        IF saldo_total_actual < in_cantidad THEN
			  SIGNAL SQLSTATE '22003';
        END IF;
        

         OPEN cursor_billetes;
         bucle_billetes: LOOP  
         FETCH cursor_billetes INTO _denominacion, _cantidad;
         
			 -- Termina: Cuando el cursor se completo o Cuando se alcanzo el dinero
				IF _done = 1 THEN
					LEAVE  bucle_billetes;
				END IF;
	
						-- Loop: Nos sirve para iterar el numero de veces sobre la cantidad disponible
						bucle_billetes_cantidad: LOOP
							       
                                -- VALIDA: que hayan iterado el numero de cantidad
				 				IF aux_loop_cantidad >= _cantidad  THEN
 									LEAVE  bucle_billetes_cantidad;
                                 END IF;
                                
                                
                                -- VALIDA: Si el saldo ya se alcanzo
								IF saldo_acumulado >= in_cantidad   THEN
 									LEAVE  bucle_billetes_cantidad;
                                END IF;
                                

                                
                                -- Valida: que la denominacion sea igual o no se pase de que resta
								IF   (in_cantidad - saldo_acumulado) < _denominacion  THEN
									LEAVE  bucle_billetes_cantidad;
                                END IF;
                                
                                
								-- Sumamos cantidad
								SET saldo_acumulado= saldo_acumulado + _denominacion;


								-- Incrementamos contador depndiendo de la denominacion
								IF _denominacion = 20 THEN
									SET bi_20= bi_20+1;
								END IF;
								
								IF _denominacion = 50 THEN
									SET bi_50= bi_50+1;
								END IF; 
								
								IF _denominacion = 100 THEN
									SET bi_100= bi_100+1;
								END IF;       
								
								IF _denominacion = 200 THEN
									SET bi_200 = bi_200+1;
								END IF;
                                
							
							SET aux_loop_cantidad= aux_loop_cantidad + 1;
						END LOOP bucle_billetes_cantidad;
                        
			SET aux_loop_cantidad= 0;
         END LOOP bucle_billetes; 
         CLOSE cursor_billetes;
         
         -- Validar si ya se alcanzo la cantidad a retirar si no continuar con las monedas
		 SET aux_loop_cantidad= 0;
         SET _done = 02; 
         
         IF saldo_acumulado < in_cantidad THEN
				
				 OPEN cursor_monedas;
				 bucle_monedas: LOOP  
				 FETCH cursor_monedas INTO _denominacion, _cantidad;
				 
					 -- Termina: Cuando el cursor se completo o Cuando se alcanzo el dinero
						IF _done = 1 THEN
							LEAVE  bucle_monedas;
						END IF;

			
						-- Loop: Nos sirve para iterar el numero de veces sobre la cantidad disponible
								bucle_monedas_cantidad: LOOP
										   
										-- VALIDA: que hayan iterado el numero de cantidad
										IF aux_loop_cantidad >= _cantidad  THEN
											LEAVE  bucle_monedas_cantidad;
										 END IF;
										
										
										-- VALIDA: Si el saldo ya se alcanzo
										IF saldo_acumulado >= in_cantidad   THEN
											LEAVE  bucle_monedas_cantidad;
										END IF;
										

										
										-- Valida: que la denominacion sea igual o no se pase de que resta
										IF   (in_cantidad - saldo_acumulado) < _denominacion  THEN
											LEAVE  bucle_monedas_cantidad;
										END IF;
										
										
										-- Sumamos cantidad
										SET saldo_acumulado = saldo_acumulado + _denominacion;


										-- Incrementamos contador depndiendo de la denominacion
										IF _denominacion = 5 THEN
											SET mo_5 = mo_5 + 1;
										END IF;
										
										IF _denominacion = 10 THEN
											SET mo_10 = mo_10 + 1;
										END IF; 
										
  										IF _denominacion = 20 THEN
											SET mo_20 = mo_20 + 1;
										END IF;       
										
									SET aux_loop_cantidad= aux_loop_cantidad + 1;
								END LOOP bucle_monedas_cantidad;
								
					SET aux_loop_cantidad= 0;
				 END LOOP bucle_monedas; 
				 CLOSE cursor_monedas;
                 
         END IF;
         
    -- Si el saldo acumulado es igual al saldo a retirar realiza la actualizacion

    
    IF saldo_acumulado = in_cantidad THEN
		-- Actualizar monedas
		UPDATE billetes SET cantidad= (cantidad - bi_20) WHERE denominacion=20;
		UPDATE billetes SET cantidad= (cantidad - bi_50) WHERE denominacion=50;
		UPDATE billetes SET cantidad= (cantidad - bi_100) WHERE denominacion=100;
		UPDATE billetes SET cantidad= (cantidad - bi_200) WHERE denominacion=200;
		-- Actualizar billetes
		UPDATE monedas SET cantidad= (cantidad - mo_5) WHERE denominacion=5;
		UPDATE monedas SET cantidad= (cantidad - mo_10) WHERE denominacion=10;
		UPDATE monedas SET cantidad= (cantidad - mo_20) WHERE denominacion=20;
		
		
		 SELECT 
			 bi_20 AS billete20,
			 bi_50 AS billete50,
			 bi_100 AS billete100,
			 bi_200 AS billete200,
			 mo_5 AS moneda5,
			 mo_10 AS moneda10,
			 mo_20 AS moneda20;
	ELSE
		  SELECT saldo_acumulado , in_cantidad ;
    END IF;
         
         
    END $$
DELIMITER ;
-- DROP PROCEDURE retirar_dinero;
-- CALL retirar_dinero(125);

*/
 