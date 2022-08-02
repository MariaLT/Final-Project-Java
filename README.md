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
    
- Ejecutar los siguientes scripts para la creación de las tablas e insertar contenido de demostración:

    
-- Para books

```
USE books;

CREATE TABLE book
(
    ean             BIGINT,
    title            VARCHAR(250),
    author           VARCHAR(250),
    genre            VARCHAR(250),
    pag_number       int,
    lang             VARCHAR(250),
    publication_year int,
    publisher        VARCHAR(250),
    url              VARCHAR(250),
    plot             VARCHAR(1500),
    PRIMARY KEY (ean)
);

INSERT INTO book (ean, title, author, genre, pag_number, lang, publication_year, publisher, url, plot)
VALUES (9788445009598, 'El Señor de los Anillos nº 01/03 La Comunidad del Anillo', 'J.R.R. Tolkien', 'Fantasía épica',
        488, 'Español', 2022, 'Minotauro',
        'https://planetadelibroscom.cdnstatics2.com/usuaris/libros/fotos/325/m_libros/portada_el-senor-de-los-anillos-n-0103-la-comunidad-del-anillo-ne_j-r-r-tolkien_202203111219.jpg',
        'En la adormecida e idílica Comarca, un joven hobbit recibe un encargo: custodiar el Anillo Único y emprender el viaje para su destrucción en
        la Grieta del Destino.
        Acompañado por magos, hombres, elfos y enanos, atravesará la Tierra Media y se internará en las sombras de Mordor, perseguido siempre
        por las huestes de Sauron, el Señor Oscuro, dispuesto a recuperar su creación para establecer el dominio definitivo del Mal'),

       (9788445009604, 'El Señor de los Anillos nº 02/03 Las Dos Torres', 'J.R.R. Tolkien', 'Fantasía épica', 408,
        'Español', 2022, 'Minotauro',
        'https://planetadelibroscom.cdnstatics2.com/usuaris/libros/fotos/325/m_libros/portada_el-senor-de-los-anillos-n-0203-las-dos-torres-ne_j-r-r-tolkien_202203111314.jpg',
        'La Compañía se ha disuelto y sus integrantes emprenden caminos separados. Frodo y Sam continúan solos su viaje a lo largo del gran río
        Anduin, perseguidos por la sombra misteriosa de un ser extraño que también ambiciona la posesión del Anillo. Mientras los hobbits
        deben enfrentarse al horror y tomar graves decisiones a las puertas del País Oscuro, hombres, elfos y enanos se preparan para la batalla
        final con las fuerzas del Señor del Mal.'),

       (9788445009611, 'El Señor de los Anillos nº 03/03 El Retorno del Rey', 'J.R.R. Tolkien', 'Fantasía épica', 520,
        'Español', 2022, 'Minotauro',
        'https://images-na.ssl-images-amazon.com/images/I/91CZONTFNgL.jpg',
        'Los ejércitos del Señor Oscuro van extendiendo cada vez más su maléfica sombra por la Tierra Media. Hombres, elfos y enanos unen sus
        fuerzas para presentar batalla a Sauron y sus huestes. Ajenos a estos preparativos, Frodo y Sam siguen adentrándose en el país de
        Mordor en su heroico viaje para destruir el Anillo de Poder en las Grietas del Destino.'),

       (9788417529369, 'Dumbo. El circo de los sueños', 'Disney', 'Fantasía', 336, 'Español', 2019, 'Libros Disney',
        'https://planetadelibroscom.cdnstatics2.com/usuaris/libros/fotos/288/m_libros/portada_dumbo-el-circo-de-los-suenos_disney_201812281524.jpg',
        'El circo ambulante de los hermanos Medici está formado por personas de todo tipo, desde hombres forzudos hasta sirenas.
        Pero todo cambia cuando un pequeño elefante con un talento único entra en sus vidas. Pronto, el pequeño circo ambulante llama
        la atención del poderoso empresario V. A. Vandevere, que tiene una tentadora oferta para el pequeño Dumbo y sus cuidadores.
        Sin embargo, no es oro todo lo que reluce.'),

       (9780194620918, 'A Christmas Carol', 'Charles Dickens', 'Foreign Language Study', 80, 'English',
        2016, 'Oxford University Press España',
        'https://pictures.abebooks.com/inventory/19509601968.jpg',
        'Ideal for intermediate learners of English looking to improve or practise their English. The book is filled with useful vocabulary
        that is carefully graded and easy to understand, it also comes with audio, so that you can listen to the story at the same time as
        reading. Christmas is humbug, Scrooge says - just a time when you find yourself a year older and not a penny richer. The only thing
        that matters to Scrooge is business, and making money. But on Christmas Eve three spirits come to visit him. They take him travelling on
        the wings of the night to see the shadows of Christmas past, present, and future - and Scrooge learns a lesson that he will never forget.'),

       (9788401027710, 'Cuento de hadas', 'Stephen King', 'Aventura Fantástica', 856, 'Español', 2022, 'PLAZA & JANES',
        'https://www.penguinlibros.com/es/1790174-large_default/cuento-de-hadas.webp',
        'Charlie Reade parece un estudiante de instituto normal y corriente, pero carga con un gran peso sobre los hombros. Cuando él solo tenía
        diez años, su madre fue víctima de un atropello y la pena empujó a su padre a la bebida. Aunque era demasiado joven, Charlie tuvo
        que aprender a cuidarse solo... y también a ocuparse de su padre.
        Ahora, con diecisiete años, Charlie encuentra dos amigos inesperados: una perra llamada Radar y Howard Bowditch, su anciano dueño.
        El señor Bowditch es un ermitaño que vive en una colina enorme, en una casa enorme que tiene un cobertizo cerrado a cal y canto en
        el patio trasero. A veces, sonidos extraños emergen de él.'),

    (9788424672775, 'El león sobre la puerta', 'Onjali Q. Raúf', 'Juvenil',
        360, 'Español', 2022, 'La Galera',
        'https://www.lagaleraeditorial.com//uploads/20220729/9788424672775_imatge_portada_llibre_detall_9788424672775.jpg',
        'Desde que tengo uso de la razón, la gente siempre se nos ha quedado mirando, a mi familia y a mí. Mi padre dice que es
        porque somos «especiales». Nunca hay nadie que se parezca a nosotros, o a mi amiga Sangeeta, en mis libros de historia
        del colegio. Sin embargo, este año es diferente. Porque en una excusión escolar para estudiar la Segunda Guerra Mundial,
        he visto mi nombre esculpido encima de una de las puertas de la iglesia, bajo un león dorado. Todavía no sé quién fue
        esta persona que compartía mi nombre, pero lo que sí que sé es que fue un héroe. Y eso lo cambia todo. De hecho, es
        posible que, con mi ayuda, sea capaz de cambiar la historia. El león sobre la puerta pone el foco en los testimonios
        que nuestros libros de historia han olvidado, y en el poder de la amistad a través de las generaciones.'),

    (9788418002496, '1. Sombra y hueso', 'Leigh Bardugo', 'Fantasía y magia', 416, 'Español', 2019,
        'Hidra', 'https://images-na.ssl-images-amazon.com/images/I/71ApA-ao6RL.jpg', 'Alina Starkov no espera mucho de la vida. Se quedó
huérfana después de la guerra y lo único que tiene en el mundo es a su amigo Mal. A raíz de un ataque que recibe Mal 
al entrar en La Sombra, una oscuridad antinatural repleta de monstruos que ha aislado el país, Alina revela un poder 
latente que ni ella misma sabía que tenía. Tras ese episodio, Alina es conducida a la fuerza hasta la corte real para 
ser entrenada como un miembro de los Grisha, un grupo de magos de élite comandado por un individuo misterioso que se 
hace llamar El Oscuro.'),

    (9788418002502, '2. Asedio y tormenta', 'Leigh Bardugo', 'Fantasía y magia', 448, 'Español', 2019,
        'Hidra', 'https://imagessl2.casadellibro.com/a/l/t7/02/9788418002502.jpg', 'En su intento por huir de Ravka y dejar
atrás a los Grisha, Alina y Malyen se embarcan en un viaje a través del Mar Auténtico. Pero por mucho que lo deseen, 
hay tres cosas de las que Alina jamás podrá escapar: Su pasado. Su poder. Y su destino. Alina pronto va a tener que 
enfrentarse a una terrible verdad. LA OSCURIDAD NUNCA MUERE. Perseguida a través del Mar Auténtico, atormentada por 
las vidas con las que acabó en la Sombra, Alina trata de sobrevivir junto a Mal en una tierra extraña, a la vez que 
mantiene en secreto su identidad como Invocadora del Sol. Pero no podrá huir durante mucho tiempo ni de su pasado ni 
de su destino.'),

       (9788418002519, '3. Ruina y ascenso', 'Leigh Bardugo', 'Fantasía y magia', 448, 'Español', 2019,
        'Hidra', 'https://imagessl9.casadellibro.com/a/l/t7/19/9788418002519.jpg', 'Bajo tierra, en la red de túneles y cuevas
que forman la Catedral Blanca, Alina es a la vez prisionera y objeto de adoración. Está muy débil, y la idea 
de embarcarse en un nuevo viaje en busca del tercer amplificador, el pájaro de fuego, parece una locura. Pero 
su poder ha cambiado desde la última batalla, y sus nuevas habilidades podrían aterrorizar incluso a sus propios 
aliados.');
```

-- Para info_books

```
USE info_books;

DROP TABLE info_loaned_book;

CREATE SCHEMA info_books;

CREATE TABLE info_loaned_book
(
    ean         BIGINT,
    loan_state  VARCHAR(250),
    loan_date   DATE,
    return_date DATE,
    picked_up VARCHAR(250),
    user_id     BIGINT,
    PRIMARY KEY (ean)
);

INSERT INTO info_loaned_book (ean, loan_state, loan_date,return_date,picked_up,user_id)
VALUES (9788445009598,'LOANED', '2022-05-01', '2022-05-30', 'YES', 1),
       (9788445009604,'AVAILABLE', null, null, null, null),
       (9788445009611,'AVAILABLE', null, null, null, null),
       (9788417529369,'AVAILABLE', null, null, null, null),
       (9780194620918,'AVAILABLE', null, null, null, null),
       (9788401027710,'AVAILABLE', null, null, null, null),
       (9788424672775, 'LOST', null, null, null, null),
       (9788418002496,'AVAILABLE', null, null, null, null),
       (9788418002502, 'AVAILABLE', null, null, null, null),
       (9788418002519, 'LOST', null, null, null, null);
```


    
-- Para users
```
USE users;

DROP TABLE role_table;
DROP TABLE user_table;

CREATE TABLE user_table (
                            id BIGINT AUTO_INCREMENT NOT NULL,
                            username VARCHAR(255),
                            user_password VARCHAR(255),
                            PRIMARY KEY (id)
);

CREATE TABLE role_table (
                            id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
                            role_name VARCHAR(255),
                            user_id BIGINT,
                            FOREIGN KEY (user_id) REFERENCES user_table (id)
);

INSERT INTO user_table (username, user_password)
VALUES ('estudiante', '$2a$10$vf4cAtFPZf3IEeHxJeCwzeFdozEyiFKgPN2viPY6Crk1qL4HZqnjm'),
       ('admin','$2a$10$vf4cAtFPZf3IEeHxJeCwzeFdozEyiFKgPN2viPY6Crk1qL4HZqnjm' );
INSERT INTO role_table (role_name, user_id)
VALUES ('STUDENT', 1),
       ('LIBRARIAN',2);
```
