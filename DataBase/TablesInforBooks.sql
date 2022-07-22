DROP
DATABASE info_books;
DROP TABLE info_loaned_book;

CREATE SCHEMA info_books;

CREATE TABLE info_loaned_book
(
    loaned_book_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    ean         BIGINT,
    loan_state  VARCHAR(250),
    loan_date   DATE,
    return_date DATE,
    user_id     BIGINT,
    PRIMARY KEY (ean),
);
