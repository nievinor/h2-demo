INSERT INTO AUTHORS (name, surname) VALUES
('Stephen', 'King'),
('Fyodor', 'Dostoyevsky'),
('Iuliana', 'Cosmina');

INSERT INTO GENRE (genre) VALUES ( 'Classic' );
INSERT INTO GENRE (genre) VALUES ( 'Horror' );
INSERT INTO GENRE (genre) VALUES ( 'Computer science' );

INSERT INTO BOOKS (name, author_id, genre_id) VALUES ( 'Crime and punishment ', 2, 1 );
INSERT INTO BOOKS (name, author_id, genre_id) VALUES ( 'The Shining', 1, 2 );
INSERT INTO BOOKS (name, author_id, genre_id) VALUES ( 'Pro Spring 5', 3, 3 );