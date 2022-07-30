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
