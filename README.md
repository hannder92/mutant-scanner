# Mutant Dna Scanner

- ### Enunciado:
Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Mens.
Te ha contratado a ti para que desarrolles un proyecto que detecte si un humano es mutante basándose en su secuencia de ADN.
Para eso te ha pedido crear un programa con un método o función con la siguiente firma:

##### boolean isMutant(String[] dna);

En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las cuales representa cada base nitrogenada del ADN.

###### NO MUTANTE

| A | T | G | C | G | A |
|---|---|---|---|---|---|
| C | A | G | T | G | C |
| T | T | A | T | T | T |
| A | G | A | C | G | G |
| G | C | G | T | C | A |
| T | C | A | C | T | G |

###### MUTANTE

| A | T | G | C | G | A |
|---|---|---|---|---|---|
| C | A | G | T | G | C |
| T | T | A | T | G | T |
| A | G | A | A | G | G |
| C | C | C | C | T | A |
| T | C | A | C | T | G |

Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras iguales , de forma oblicua, horizontal o vertical.

Ejemplo (Caso mutante):

##### String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

En este caso el llamado a la función isMutant(dna) devuelve “true”.
Desarrolla el algoritmo de la manera más eficiente posible.

##### Desafíos:

### Nivel 1:

Programa (en cualquier lenguaje de programación) que cumpla con el método pedido por
Magneto.

### Nivel 2:

Crear una API REST, hostear esa API en un cloud computing libre (Google App Engine,
Amazon AWS, etc), crear el servicio “/mutant/” en donde se pueda detectar si un humano es
mutante enviando la secuencia de ADN mediante un HTTP POST con un Json el cual tenga el
siguiente formato:

```sh
POST → /mutant/
{
“dna”:["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
```

En caso de verificar un mutante, debería devolver un HTTP 200-OK, en caso contrario un 403-Forbidden

### Nivel 3:

Anexar una base de datos, la cual guarde los ADN’s verificados con la API.
Solo 1 registro por ADN.
Exponer un servicio extra “/stats” que devuelva un Json con las estadísticas de las verificaciones de ADN: {“count_mutant_dna”:40, “count_human_dna”: 100: “ratio”:0.4}
Tener en cuenta que la API puede recibir fluctuaciones agresivas de tráfico (Entre 100 y 1 millón de peticiones por segundo).
Test-Automáticos, Code coverage > 80%, Diagrama de Secuencia / Arquitectura del sistema.

## Características
##### Tecnología:
- Java
- Spring Boot
- SpringJPA
- Postgres
- AWS EC2
- AWS S3
- AWS RDS

##### Testing
- JUnit 5
- Mockito

## Requerimientos
- Java >= 11
- Spring Boot 2.4.2
- Postgres >= 13.0
- Gradle 6.7

## Instalacion
- Clonar Repositorio
- Instalar dependencias
  - ```gradle clean build --refresh-dependencies```
- Instalar PostgreSQL
  - Crear base de datos xmen-project (usuario: admin, contraseña: admin)
  - Ejecutar esquema de base de datos https://github.com/hannder92/mutant-scanner/blob/master/src/main/resources/scheme.sql
  - Insertar datos de prueba https://github.com/hannder92/mutant-scanner/blob/master/src/main/resources/data.sql

## Desplegar API
### Development
- Ejecutar CMD o Git Bash dentro de la carpeta del proyecto
- Ejecutar el comando ```gradle clean build```
- Ejecutar el comando ```java -jar build/libs/mutant-scanner-1.0.0.jar```
- El API se ejecutara en http://localhost:8090/xmen-project/api
- El API esta documentado y se puede consumir a traves de: http://localhost:8090/xmen-project/api/swagger-ui.html

## Testing y cobertura de codigo
```
gradle test
```
- https://htmlpreview.github.io/?https://github.com/hannder92/mutant-scanner/blob/master/coverage/index.html

## Documentacion API (SWAGGER)
- Desde el SWAGGER-UI se puede ver como consumir y que responde el API, a su vez se puede realizar consumo y pruebas a traves del mismo
  - URL Local: http://localhost:8090/xmen-project/api/swagger-ui.html

## API en la nube
- URL WEB: http://ec2-52-90-228-61.compute-1.amazonaws.com:8090/xmen-project/api/
- URL SWAGGER: http://ec2-52-90-228-61.compute-1.amazonaws.com:8090/xmen-project/api/swagger-ui.html

##Gracias

  
