CREATE TABLE IF NOT EXISTS FOTO(
	id				int PRIMARY KEY,
	titol			varchar(255) NOT NULL,
	url				varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS CATEGORIA(
	id				int PRIMARY KEY,
	nom				varchar(255) NOT NULL,
	cat_pare		int REFERENCES CATEGORIA(id)
);

CREATE TABLE IF NOT EXISTS RUTA(
	id				int PRIMARY KEY,
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
	id_ruta			int REFERENCES RUTA(id),
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

/*
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
*/