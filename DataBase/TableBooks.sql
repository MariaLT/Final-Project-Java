DROP
DATABASE books;
DROP TABLE info_loaned_book;
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
    plot             LONGTEXT,
    PRIMARY KEY (isbn)
);

CREATE TABLE info_loaned_book
(
    ean         BIGINT,
    loan_state  VARCHAR(250),
    loan_date   DATE,
    return_date DATE,
    user_id     BIGINT,
    PRIMARY KEY (ean),
);
