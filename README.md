#  Aplicación Web 

Aplicación web desarrollada con **React + Vite** para el frontend y **Spring Boot** para el backend.

---

## ️ Tecnologías utilizadas

### ️ Frontend
- TypeScript  
- React + Vite  

### Backend
- Java 17  
- Spring Boot  
- Spring Data JPA  
- Lombok  
- Docker  
- PostgreSQL  

---

## ⚙️ Instrucciones de instalación

Sigue estos pasos para configurar y ejecutar el proyecto en tu entorno local.

### 1. Clonar el repositorio

```bash
git clone https://github.com/msxd26/prueba-civa/
cd prueba-civa
```

### 2. Configurar y levantar el backend

El `docker-compose.yml` está dentro del directorio del backend: `back-api-buses/`.

#### Navega al directorio del backend

```bash
cd back-api-buses
```

#### Configura la conexión a la base de datos

Abre el archivo `src/main/resources/application.properties` modifica las siguientes líneas con tus credenciales de PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/civa_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

#### Actualiza el `docker-compose.yml`

Asegúrate de que el usuario y contraseña en `docker-compose.yml` para PostgreSQL coincidan con las credenciales que configuraste en `application.properties`.

#### Levanta la base de datos con Docker

Ejecuta (desde `back-api-buses/`):

```bash
docker compose up -d
```

Verifica que el contenedor esté corriendo:

```bash
docker ps
```

#### Inicia el backend

 Por defecto el backend estará disponible en:

```
http://localhost:8080
```

---

### 3. Configurar y levantar el frontend

#### Navega al directorio del frontend

```bash
cd ../frontend-civabus
```

#### Instala las dependencias

```bash
npm install
```

#### Inicia la aplicación frontend

```bash
npm run dev
```

Por defecto Vite sirve el frontend en:

```
http://localhost:5173
```
  
