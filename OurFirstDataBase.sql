CREATE DATABASE test;

CREATE TABLE test.items(
	nombre VARCHAR(50) NOT NULL,
    category VARCHAR(50) NOT NULL,
	stock INT unsigned,
    id INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id)
);

INSERT INTO test.items(nombre, category, stock)
values ("Fideos", "Harina", 20), ("Leche", "Lacteos", 30), ("Crema", "Lacteos", 15);

SELECT * FROM test.items;

DELETE FROM test.items WHERE id=1;

UPDATE test.items SET stock = 45 WHERE id = 2;

SELECT * FROM test.items;