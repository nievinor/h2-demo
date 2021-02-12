DROP TABLE IF EXISTS AUTHORS;
DROP TABLE IF EXISTS GENRE;
DROP TABLE IF EXISTS BOOKS;

CREATE TABLE AUTHORS (
                         id INT AUTO_INCREMENT  PRIMARY KEY,
                         name VARCHAR(250) NOT NULL,
                         surname VARCHAR(250) NOT NULL
);

INSERT INTO AUTHORS (name, surname) VALUES
('Stephen', 'King'),
('Fyodor', 'Dostoyevsky'),
('Iuliana', 'Cosmina');

CREATE TABLE GENRE (
                       id INT AUTO_INCREMENT  PRIMARY KEY,
                       genre VARCHAR(100) NOT NULL
);

INSERT INTO GENRE (genre) VALUES ( 'Classic' );
INSERT INTO GENRE (genre) VALUES ( 'Horror' );
INSERT INTO GENRE (genre) VALUES ( 'Computer science' );

CREATE TABLE BOOKS (
                       id INT AUTO_INCREMENT  PRIMARY KEY,
                       name VARCHAR(250) NOT NULL,
                       author_id INT,
                       genre_id INT,
                       FOREIGN KEY (author_id) REFERENCES AUTHORS,
                       FOREIGN KEY (genre_id) REFERENCES GENRE
);

INSERT INTO BOOKS (name, author_id, genre_id) VALUES ( 'Crime and punishment ', 2, 1 );
INSERT INTO BOOKS (name, author_id, genre_id) VALUES ( 'The Shining', 1, 2 );
INSERT INTO BOOKS (name, author_id, genre_id) VALUES ( 'Pro Spring 5', 3, 3 );