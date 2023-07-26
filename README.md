# Documentacion:
Esta es un api que permite añadir, retirar y consultar saldo. 
Este proyecto es una prueba técnica para desarrollador de APIS para Grupo Salinas. En el siguiente link podrás encontrar más detalladamente los requerimientos de mismo.

 **Link:** https://sandovalguicho.com/portfolio/cajero-automatico-prueba-tecnica-grupo-salinas/

## Dependencias Destacadas:
+ spring-boot-starter-data-jpa
+ spring-boot-starter-validation
+ mysql-connector-j


## Probar con Postman:
En la raíz del proyecto encontraras un archivo .json para importar dentro de Postman. Solamente tienes que ejecutar los Endpoinds ya que ya vienen configurados.



## MySQL
El presente proyecto fue desarrollado con la BD MySQL por lo cual asegúrate de tener una base de datos creada, por defecto el proyecto se conecta a la BD con el nombre de: “banco_monedas_billetes”, con usuario: “root” y password:”toor”. Pero recuerda que estas configuraciones las puedes cambiar directamente desde el archivo properties.

**Nota:** El proyecto tiene archivos import.sql para crear registros por defecto. Este arcivo existe en la carpeta main y test.

Dentro de este también se encuentran los PROCEDURES, FUNCTIONSy VIEWS que se utilizaron para este proyecto. Estos vienen comentados por lo cual debes ejecutarlos en tu BD en MySQL.

## FrondEnd:
Este proyecto también  cuenta con una interfaz gráfica, la cual se encuentra en el siguiente enlace: https://github.com/sandovalguichoo/angular-cajero-automatico
