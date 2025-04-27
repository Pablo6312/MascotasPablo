# Registro de Mascotas para Adopción

API Rest con SpringBoot, que permite la gestión de un registro de mascotas, para la adopción, y de personas interesadas en adortar.

## Tecnologías utilizadas

- **Spring Boot**
- **Spring Data JPA**
- **H2 Database**
- **Maven**
- **Lombok**
- **Postman**

## Funcionalidades

1. **Mostrar Mascota por ID**
2. **Subir una Mascota**
3. **Listar todas las mascotas**
4. **Listar mascotas por raza**
5. **Listar las 20 mascotas más jóvenes**
6. **Mostrar mascotas en páginas de 5**
7. **Eliminar una Mascota**
8. **Mostrar mascotas de un propietario**
9. **Mostrar propietario de una mascota**

## Configuración
1. Clona el repositorio (en este caso a Eclipse IDE)
2. Al usar H2 para la base de datos, se podrá ver y manejar desde `http://localhost:8080/h2-console` 
    - Las tablas se crearan solas mediante hibernate.
    - Las tablas estarán creadas pero vacias, dejo un fichero `data.sql` para que se rellene desde la consola.  
3. Inicia el proyecto como `Spring Boot App` y ya estará la API funcionando.  
4. Ahora podras usarla tanto en tu navegador favorito en `http://localhost:8080/api` o en Postman si lo prefieres.  
5. Mediante los endpoints que se encuentran en la API podrás realizar las diferentes funcionalidades.

## Endpoints

- **GET /api/mascota/{id}**: Obtener mascota por ID.
- **POST /api/mascota**: Crear nueva mascota.
- **GET /api/mascota/raza/{raza}**: Listar mascotas por raza.
- **GET /api/mascota/mas-jovenes**: Listar las 20 mascotas más jóvenes.
- **DELETE /api/mascota/{id}**: Eliminar una mascota.
- **GET /api/propietario/{id}/mascotas**: Obtener todas las mascotas de un propietario.
- **GET /api/mascota/{id}/propietario**: Obtener propietario de una mascota.

## Observaciones
- En el endpoint de mostrar todas las mascotas de un propietario, el mapping lo puse como "/propitario/{id}/mascotas" para diferenciar y que quedará más claro a la hora de entender su función pero se encuentra en MascotasController.
- Todo el tema de las clases de `Propietario` están vacias porque en el ejercicio no se pide nada en concreto con este, pero los creé por si en el futuro en este programa se desea añadir funcionalidades para los propietarios.
- He tenido vacios problemas para hacer que la base de datos esté un poco rellena cuando se inicia el programa así que he dejado unas lineas hechas a mano para que se metan directamente desde la consola y no este vacia.
- Además de que al no haber hecho las funcionalidades de `Propietario` no existe un endpoint para crearlos, y hace falta crearlos a mano.
