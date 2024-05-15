# LAB | Java Introducción a JPA

## Introducción

Acabamos de aprender cómo crear objetos de entidad y usar repositorios JPA para consultar datos, así que practiquemos un poco más.

<br>

## Requisitos

1. Haz un fork de este repositorio.
2. Clona este repositorio.
3. Añade a tu instructor y a los calificadores de la clase como colaboradores de tu repositorio. Si no estás seguro de quiénes son los calificadores de tu clase, pregunta a tu instructor o consulta la presentación del primer día.
4. En el repositorio, crea un proyecto de Java y añade el código para las siguientes tareas.

## Entrega

Una vez que termines la tarea, envía un enlace URL a tu repositorio o tu solicitud de extracción en el campo de abajo.

<br>

## Instrucciones

Para este trabajo de la tarea, utiliza los datos de la base de datos de aerolíneas del laboratorio 3.02 y la [Documentación de Spring JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation).

Crea tres clases principales y una clase enum: `FlightBooking`, `Customer` y `Flight`. La clase enum se llamará `CustomerStatus`.

<br>  

### Clase enum `CustomerStatus`

Crea una clase enum llamada `CustomerStatus` con los siguientes valores:

- `Gold`
- `Silver`
- `None`

<br>  

### Clase `Customer`

Crea una clase llamada `Customer` con las siguientes variables:

- `customerId` (integer): un identificador único generado automáticamente, miembro privado
- `customerName` (string): miembro privado
- `customerStatus` (string): que representa un enum, miembro privado
- `totalCustomerMileage` (integer): miembro privado
- Agrega un constructor vacío a la clase `Customer` para que Hibernate cree nuevas instancias de la clase.
- Agrega un constructor parametrizado a la clase `Customer` que tome `customerName`, `customerStatus` y `totalCustomerMileage` como parámetros.
- Agrega métodos getter y setter públicos para cada variable en la clase `Customer`.

<br>  

### Clase `Flight`

Crea una clase llamada `Flight` con las siguientes variables:

- `flightId` (integer): un identificador único generado automáticamente, miembro privado
- `flightNumber` (string): un identificador único, miembro privado
- `aircraft` (string): miembro privado
- `totalAircraftSeats` (integer): miembro privado
- `flightMileage` (integer): miembro privado
- Agrega un constructor vacío a la clase `Flight` para que Hibernate pueda crear nuevas instancias de la clase.
- Agrega un constructor parametrizado a la clase `Flight` que tome `flightNumber`, `aircraft`, `totalAircraftSeats` y `flightMileage` como parámetros.
- Agrega métodos getter y setter públicos para cada variable en la clase `Flight`.

<br>  

### Clase `FlightBooking`

Crea una clase llamada `FlightBooking` con las siguientes variables:

- `bookingId` (integer): un identificador único generado automáticamente, miembro privado
- `customerId` (integer): miembro privado
- `flightId` (integer): miembro privado
- Agrega un constructor vacío a la clase `FlightBooking` para que Hibernate pueda crear nuevas instancias de la clase.
- Agrega un constructor parametrizado a la clase `FlightBooking` que tome `customerId` y `flightId` como parámetros.
- Agrega métodos getter y setter públicos para cada variable en la clase `FlightBooking`.
- Agrega restricciones de clave externa en la clase `FlightBooking` para hacer referencia a `customerId` y `flightId` en las tablas customers y flights respectivamente.

<br>  

## Tareas

1. Crea todos los repositorios y entidades necesarias para la tabla `Customer`.
2. Crea todos los repositorios y entidades necesarias para la tabla `Flight`.
3. Crea todos los repositorios y entidades necesarias para la tabla `FlightBooking`.
4. Escribe tests para verificar tu capacidad para crear nuevos clientes.
5. Escribe tests para verificar tu capacidad para crear nuevos vuelos.
6. Escribe tests para verificar tu capacidad para encontrar clientes por nombre.
7. Escribe tests para verificar tu capacidad para encontrar clientes por estatus.
8. Escribe tests para verificar tu capacidad para encontrar vuelos por número de vuelo.
9. Escribe tests para verificar tu capacidad para encontrar aviones con nombres que contengan "Boeing".
10. Escribe tests para verificar tu capacidad para encontrar vuelos con una distancia mayor a 500 millas.


<br>