INSERT INTO book (ean, title, author, genre, pag_number, lang, publication_year, publisher, url, plot)
VALUES 
(9788445009598, 'El Señor de los Anillos nº 01/03 La Comunidad del Anillo', 'J.R.R. Tolkien', 'Fantasía épica', 488, 
'Español', 2022, 'Minotauro', 'https://planetadelibroscom.cdnstatics2.com/usuaris/libros/fotos/325/m_libros/portada_el-senor-de-los-anillos-n-0103-la-comunidad-del-anillo-ne_j-r-r-tolkien_202203111219.jpg', 
'En la adormecida e idílica Comarca, un joven hobbit recibe un encargo: custodiar el Anillo Único y emprender el viaje para su destrucción en 
la Grieta del Destino.
Acompañado por magos, hombres, elfos y enanos, atravesará la Tierra Media y se internará en las sombras de Mordor, perseguido siempre 
por las huestes de Sauron, el Señor Oscuro, dispuesto a recuperar su creación para establecer el dominio definitivo del Mal'),

(9788445009604, 'El Señor de los Anillos nº 02/03 Las Dos Torres', 'J.R.R. Tolkien', 'Fantasía épica', 408,
'Español', 2022 ,'Minotauro', 
'https://planetadelibroscom.cdnstatics2.com/usuaris/libros/fotos/325/m_libros/portada_el-senor-de-los-anillos-n-0203-las-dos-torres-ne_j-r-r-tolkien_202203111314.jpg', 
'La Compañía se ha disuelto y sus integrantes emprenden caminos separados. Frodo y Sam continúan solos su viaje a lo largo del gran río 
Anduin, perseguidos por la sombra misteriosa de un ser extraño que también ambiciona la posesión del Anillo. Mientras los hobbits 
deben enfrentarse al horror y tomar graves decisiones a las puertas del País Oscuro, hombres, elfos y enanos se preparan para la batalla 
final con las fuerzas del Señor del Mal.'),

(9788445009611, 'El Señor de los Anillos nº 03/03 El Retorno del Rey', 'J.R.R. Tolkien', 'Fantasía épica', 520,
'Español', 2022 ,'Minotauro',
'planetadelibroscom.cdnstatics2.com/usuaris/libros/fotos/325/m_libros/portada_el-senor-de-los-anillos-n-0303-el-retorno-del-rey-ne_j-r-r-tolkien_202203111320.jpg', 
'Los ejércitos del Señor Oscuro van extendiendo cada vez más su maléfica sombra por la Tierra Media. Hombres, elfos y enanos unen sus 
fuerzas para presentar batalla a Sauron y sus huestes. Ajenos a estos preparativos, Frodo y Sam siguen adentrándose en el país de 
Mordor en su heroico viaje para destruir el Anillo de Poder en las Grietas del Destino.'),

(9788417529369, 'Dumbo. El circo de los sueños', 'Disney', 'Fantasía', 336,'Español', 2019, 'Libros Disney', 
'https://planetadelibroscom.cdnstatics2.com/usuaris/libros/fotos/288/m_libros/portada_dumbo-el-circo-de-los-suenos_disney_201812281524.jpg',
'El circo ambulante de los hermanos Medici está formado por personas de todo tipo, desde hombres forzudos hasta sirenas. 
Pero todo cambia cuando un pequeño elefante con un talento único entra en sus vidas. Pronto, el pequeño circo ambulante llama 
la atención del poderoso empresario V. A. Vandevere, que tiene una tentadora oferta para el pequeño Dumbo y sus cuidadores.
Sin embargo, no es oro todo lo que reluce.'),

(9780194620918, 'A Christmas Carol', 'Charles Dickens', 'Foreign Language Study', 80,'English', 
2016, 'Oxford University Press España', 
'https://pictures.abebooks.com/inventory/19509601968.jpg', 
'Ideal for intermediate learners of English looking to improve or practise their English. The book is filled with useful vocabulary 
that is carefully graded and easy to understand, it also comes with audio, so that you can listen to the story at the same time as 
reading. Christmas is humbug, Scrooge says - just a time when you find yourself a year older and not a penny richer. The only thing 
that matters to Scrooge is business, and making money. But on Christmas Eve three spirits come to visit him. They take him travelling on 
the wings of the night to see the shadows of Christmas past, present, and future - and Scrooge learns a lesson that he will never forget.'),

(9788401027710, 'Cuento de hadas','Stephen King', 'Aventura Fantástica', 856, 'Español', 2022, 'PLAZA & JANES', 
'https://www.penguinlibros.com/es/1790174-large_default/cuento-de-hadas.webp', 
'Charlie Reade parece un estudiante de instituto normal y corriente, pero carga con un gran peso sobre los hombros. Cuando él solo tenía 
diez años, su madre fue víctima de un atropello y la pena empujó a su padre a la bebida. Aunque era demasiado joven, Charlie tuvo 
que aprender a cuidarse solo... y también a ocuparse de su padre.
Ahora, con diecisiete años, Charlie encuentra dos amigos inesperados: una perra llamada Radar y Howard Bowditch, su anciano dueño. 
El señor Bowditch es un ermitaño que vive en una colina enorme, en una casa enorme que tiene un cobertizo cerrado a cal y canto en 
el patio trasero. A veces, sonidos extraños emergen de él.');
 
 use books;
 SELECT plot FROM libros where title = 'Dumbo. El circo de los sueños';
 SELECT * FROM book;