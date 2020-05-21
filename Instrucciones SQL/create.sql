CREATE TABLE IF NOT EXISTS FOTO(
	fot_id				int PRIMARY KEY,
	fot_titol			varchar(255) NOT NULL,
	fot_url				text NOT NULL
);

CREATE TABLE IF NOT EXISTS CATEGORIA(
	cat_id				int PRIMARY KEY,
	cat_nom				varchar(255) NOT NULL,
	cat_pare			int REFERENCES CATEGORIA(cat_id)
);

CREATE TABLE IF NOT EXISTS RUTA(
	rut_id				int PRIMARY KEY,
	rut_titol			varchar(255) NOT NULL,
	rut_cat_id			int NOT NULL REFERENCES CATEGORIA (cat_id),
	rut_desc_markdown	text NOT NULL,
	rut_desnivell		int NOT NULL,
	rut_alcada_max		int NOT NULL,
	rut_alcada_min		int NOT NULL,
	rut_distancia_km	float NOT NULL,
	rut_temps_aprox		datetime NOT NULL,
	rut_circular		boolean NOT NULL,
	rut_dificultat_5	int NOT NULL,
	rut_gpx_File_URL	text,
	rut_foto			int NOT NULL UNIQUE REFERENCES FOTO (fot_id)
);

CREATE TABLE IF NOT EXISTS PUNT(
	pun_id				int REFERENCES RUTA(id),
	pun_numero			int,
	pun_nom				varchar(255) NOT NULL,
	pun_descripcio		varchar(255) NOT NULL,
	pun_hora			datetime,
	pun_latitud			double,
	pun_longitud		double,
	pun_elevacio		int,
	pun_foto			int NOT NULL UNIQUE REFERENCES FOTO (id),
	PRIMARY KEY (pun_id, pun_numero)
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