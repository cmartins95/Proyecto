CREATE TABLE IF NOT EXISTS `Foto`(
	fot_id				int PRIMARY KEY,
	fot_titol			varchar(255) NOT NULL,
	fot_url				text NOT NULL
);

CREATE TABLE IF NOT EXISTS `Categoria`(
	cat_id				int PRIMARY KEY,
	cat_nom				varchar(255) NOT NULL,
	cat_pare			int,
	CONSTRAINT CATEGORIA_CATEGORIA_FK FOREIGN KEY (cat_pare) REFERENCES `Categoria` (cat_id)
);

CREATE TABLE IF NOT EXISTS `Ruta`(
	rut_id				int PRIMARY KEY,
	rut_titol			varchar(255) NOT NULL,
	rut_cat_id			int NOT NULL,
	rut_desc_markdown	text NOT NULL,
	rut_desnivell		int NOT NULL,
	rut_alcada_max		int NOT NULL,
	rut_alcada_min		int NOT NULL,
	rut_distancia_km	float NOT NULL,
	rut_temps_aprox		long NOT NULL,
	rut_circular		boolean NOT NULL,
	rut_dificultat_5	int NOT NULL,
	rut_gpx_File_URL	text,
	rut_foto			int NOT NULL UNIQUE,
	CONSTRAINT RUTA_CATEGORIA_FK FOREIGN KEY (rut_cat_id) REFERENCES `Categoria` (cat_id),
	CONSTRAINT RUTA_FOTO_FK FOREIGN KEY (rut_foto) REFERENCES `Foto` (fot_id),
	CONSTRAINT RUTA_DIFICULTAT CHECK (rut_dificultat_5>=0 and rut_dificultat_5<=5)
);

CREATE TABLE IF NOT EXISTS `Punt`(
	pun_id				int,
	pun_numero			int,
	pun_nom				varchar(255) NOT NULL,
	pun_descripcio		varchar(255) NOT NULL,
	pun_hora			long,
	pun_latitud			double,
	pun_longitud		double,
	pun_elevacio		int,
	pun_foto			int NOT NULL,
	PRIMARY KEY (pun_id, pun_numero),
	CONSTRAINT PUNT_RUTA_FK FOREIGN KEY (pun_id) REFERENCES `Ruta` (rut_id),
	CONSTRAINT PUNT_FOTO_FK FOREIGN KEY (pun_foto) REFERENCES `Foto` (fot_id)
);