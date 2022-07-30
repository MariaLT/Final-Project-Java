DROP
DATABASE books;

DROP TABLE book;

CREATE SCHEMA books;

USE
books;

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
