USE users;

CREATE TABLE user_table (
    id BIGINT AUTO_INCREMENT NOT NULL,
    username VARCHAR(255),
    password VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE role_table (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(255),
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user_table (id)
);