# 🏥 Sistema de Gestión de Pacientes - Hospital VM

Este proyecto es una API REST desarrollada con **Spring Boot**, orientada a la gestión de pacientes en un entorno hospitalario. 
Permite realizar operaciones CRUD sobre la entidad Paciente y se conecta a una base de datos relacional MySQL para persistencia.

## 🚀 Tecnologías utilizadas

- **Java 17** – Lenguaje principal del proyecto.
- **Spring Boot 3** – Framework para construir la aplicación web.
- **Spring Data JPA** – Manejo de la persistencia de datos.
- **Lombok** – Simplifica la escritura de código reduciendo la verbosidad (getters, setters, constructores, etc.).
- **MySQL** – Sistema de gestión de base de datos relacional.
- **H2** (solo para pruebas) – Base de datos en memoria utilizada en ambientes de testing.
- **Postman** – Herramienta utilizada para probar los endpoints de la API.

## ⚙️ Configuración del entorno

1. **Clonar el repositorio**  
   ```bash
   git clone https://github.com/tu-usuario/hospital-vm.git
   cd hospital-vm
   ```

2. **Configurar la base de datos MySQL**
Asegúrate de tener una base de datos creada (por ejemplo, hospital_vm)
y configura el acceso en el archivo application.properties:

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_vm
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
   ```
3. **Compilar el proyecto**
Usa Maven para compilar e instalar las dependencias:

```bash
mvn clean install
   ```
4. **Ejecutar la aplicación**
Puedes ejecutar la API con el siguiente comando:

```bash
mvn spring-boot:run
   ```
O si usas un IDE como IntelliJ o VSCode, simplemente ejecuta la clase HospitalVmApplication.java.

##🧪 Pruebas de la API
Puedes utilizar Postman o cualquier otra herramienta de cliente HTTP para probar los endpoints, por ejemplo:


GET /api/v1/pacientes → Lista todos los pacientes.

POST /api/v1/pacientes → Crea un nuevo paciente.

DELETE /api/v1/pacientes/{id} → Elimina un paciente por su ID (retorna "Paciente eliminado" si es exitoso).

PUT /api/v1/pacientes/{id} → Actualiza los datos de un paciente.



##📌 Notas adicionales

La base de datos se genera automáticamente al iniciar el proyecto gracias a la configuración de JPA.

Recuerda usar el header Content-Type: application/json al enviar datos en POST o PUT.

Este proyecto es ideal como base para agregar más funcionalidades, como seguridad, historial médico, o autenticación de usuarios.


## Estructura del Proyecto
```bash
hospital-vm/
├── src/
│   ├── main/
│   │   ├── java/com/hospital_vm/cl/hospital_vm/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   └── service/
│   └── resources/
│       ├── application.properties
├── pom.xml
└── README.md
```
