drop table IF EXISTS Weather;

CREATE TABLE Weather(
id INTEGER,
RecordDate DATE,
Temperature INTEGER
);

INSERT INTO Weather (id, RecordDate, Temperature) VALUES(1, '2015-01-01', 10);
INSERT INTO Weather (id, RecordDate, Temperature) VALUES(2, '2015-01-02', 25);
INSERT INTO Weather (id, RecordDate, Temperature) VALUES(3, '2015-01-03', 20);
INSERT INTO Weather (id, RecordDate, Temperature) VALUES(4, '2015-01-04', 30);