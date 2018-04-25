drop table IF EXISTS cinema;

CREATE TABLE cinema(
id INTEGER,
movie VARCHAR(15),
description  VARCHAR(15),
rating DECIMAL(2,1)
);


INSERT INTO cinema (id, movie, description, rating) VALUES(1, 'War', 'great 3D', 8.9);
INSERT INTO cinema (id, movie, description, rating) VALUES(2, 'Science', 'fiction', 8.5);
INSERT INTO cinema (id, movie, description, rating) VALUES(3, 'irish', 'boring', 6.2);
INSERT INTO cinema (id, movie, description, rating) VALUES(4, 'Ice song', 'Fantacy', 8.6);
INSERT INTO cinema (id, movie, description, rating) VALUES(5, 'House card', 'Interesting', 9.1);