DROP DATABASE catalogo_libros;
DROP TABLE info_prestamos;
DROP TABLE libros;

CREATE SCHEMA catalogo_libros;

USE catalogo_libros;

CREATE TABLE libros (
isbn BIGINT,
title VARCHAR(250),
author VARCHAR(250),
genre VARCHAR(250),
pag_number int,
lang VARCHAR(250),
publication_year int,
publisher VARCHAR(250),
url VARCHAR(250),
plot LONGTEXT,
PRIMARY KEY (isbn)
 );
 
CREATE TABLE info_prestamos(
isbn BIGINT,
estado VARCHAR(250),
fecha_prestamo DATE,
fecha_devolucion DATE,
user_id BIGINT,
PRIMARY KEY (isbn),
FOREIGN KEY (isbn) REFERENCES libros (isbn)
);
