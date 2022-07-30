DROP
DATABASE info_books;

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
