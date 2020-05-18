-- Cambios al UML original --
-- 1. Las tablas RUTA y CATEGORIA han cambiado su 'id' long a tipo int auto_increment.
-- 2. En la tabla PUNT se ha cambiado 'numero' int por 'id' de tipo int auto_increment.
-- 3. Se ha suprimido la tabla FOTO por los campos 'urlFoto' y 'titolFoto' en las tablas RUTA y PUNT.
-- 4. En la tabla PUNT se ha cambiado 'desc' por 'descripcio', 'lat' por 'latitud' y 'long' por 'longitud'.  

-- Notas --
-- Como en el UML original la relación reflexiva de categoria apunta a sus hijos y no a su padre, 
-- se ha creado la tabla CATEGORIA_CATEGORIA en lugar de añadir un campo a la tabla CATEGORIA existente.

CREATE TABLE IF NOT EXISTS FOTO(
	id				int auto_increment PRIMARY KEY,
	titol			varchar(255) NOT NULL,
	url				varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS CATEGORIA(
	id				int auto_increment PRIMARY KEY,
	nom				varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS RUTA(
	id				int auto_increment PRIMARY KEY,
	titol			varchar(255) NOT NULL,
	descMarkDown	text NOT NULL,
	desnivell		int NOT NULL,
	alcadaMax		int NOT NULL,
	alcadaMin		int NOT NULL,
	distanciaKm		float NOT NULL,
	tempsApox		datetime NOT NULL,
	circular		boolean NOT NULL,
	dificultat5		int NOT NULL,
	gpxFileURL		varchar(255),
	idFoto			int NOT NULL REFERENCES FOTO (id)
);

CREATE TABLE IF NOT EXISTS PUNT(
	id_ruta			int,
	id_punt			int,
	numero			int NOT NULL,
	nom				varchar(255) NOT NULL,
	descripcio		varchar(255) NOT NULL,
	hora			datetime,
	latitud			double,
	longitud		double,
	elevacio		int,
	idFoto			int NOT NULL REFERENCES FOTO (id),
	PRIMARY KEY (id_ruta, id_punt)
);

CREATE TABLE IF NOT EXISTS CATEGORIA_CATEGORIA(
	id_cat_pare		int REFERENCES CATEGORIA (id),
	id_cat_filla	int REFERENCES CATEGORIA (id),
	PRIMARY KEY (id_cat_pare, id_cat_filla)
);

CREATE TABLE IF NOT EXISTS CATEGORIA_RUTA(
	id_cat			int REFERENCES CATEGORIA (id),
	id_ruta			int REFERENCES RUTA (id),
	PRIMARY KEY (id_cat, id_ruta)
);

-- Trigger para ordenar secuencialmente 'ruta_id' y 'punt_id' (secuencial automatico).
DELIMITER $$
CREATE TRIGGER PUNT_ID_ORDER BEFORE INSERT ON PUNT
FOR EACH ROW BEGIN
    SET NEW.id_punt = (
       SELECT IFNULL(MAX(id_punt), 0) + 1
       FROM PUNT
       WHERE id_ruta = NEW.id_ruta
    );
END $$
DELIMITER ;