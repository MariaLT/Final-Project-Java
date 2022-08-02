# Final-Project-María LT

## Librarium

Se trata de una aplicación para la gestión de una biblioteca escolar, donde:
- Los estudiantes pueden visualizar el catálogo, solicitar préstamos y consultar los 
libros prestados.
- Los administradores pueden añadir y eliminar libros del catálogo, visualizar y gestionar los préstamos.


## Estructura

### Back-end y Front-end

![png](https://github.com/MariaLT/Final-Project-Java/blob/main/schema.png)

### Diagrama de clases

![png](https://github.com/MariaLT/Final-Project-Java/blob/main/diagramaDeClases.png)

### Diagrama casos de uso

### Configuración externalizada

https://github.com/MariaLT/config-repo-final



## Instrucciones para ejecutar la aplicación

### Base de datos

El back-end esta realizado para funcionar con una base de datos de tipo SQL através de MySQL.

- Crear el usuario finalproject o personalizar estos parámetros en el repositorio de configuración.

```
spring.datasource.username=finalproject
spring.datasource.password=finalproject

```

- Es necesario crear las siguientes bases de datos:
    - books
    - info_books
    - users
    - books_test
    - info_books_test
    
- 
    
    
