package com.example.rutapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ruta {

    private Integer rut_id;
    private String rut_titol;
    private Integer cat_id;
    private String cat_nom;
    private String rut_desc_markdown;
    private Integer rut_desnivell;
    private Integer rut_alcada_max;
    private Integer rut_alcada_min;
    private Float rut_distancia_km;
    private Long rut_temps_aprox;
    private Boolean rut_circular;
    private Integer rut_dificultat_5;
    private String rut_gpx_File_URL;
    private String fot_titol;
    private String fot_url;

    public Ruta(Integer rut_id, String rut_titol, Integer cat_id, String cat_nom, String rut_desc_markdown, Integer rut_desnivell, Integer rut_alcada_max, Integer rut_alcada_min, Float rut_distancia_km, Long rut_temps_aprox, Boolean rut_circular, Integer rut_dificultat_5, String rut_gpx_File_URL, String fot_titol, String fot_url) {
        this.rut_id = rut_id;
        this.rut_titol = rut_titol;
        this.cat_id = cat_id;
        this.cat_nom = cat_nom;
        this.rut_desc_markdown = rut_desc_markdown;
        this.rut_desnivell = rut_desnivell;
        this.rut_alcada_max = rut_alcada_max;
        this.rut_alcada_min = rut_alcada_min;
        this.rut_distancia_km = rut_distancia_km;
        this.rut_temps_aprox = rut_temps_aprox;
        this.rut_circular = rut_circular;
        this.rut_dificultat_5 = rut_dificultat_5;
        this.rut_gpx_File_URL = rut_gpx_File_URL;
        this.fot_titol = fot_titol;
        this.fot_url = fot_url;
    }

    public Integer getId() {
        return rut_id;
    }

    public void setId(Integer rut_id) {
        this.rut_id = rut_id;
    }

    public String getTitol() {
        return rut_titol;
    }

    public void setTitol(String rut_titol) {
        this.rut_titol = rut_titol;
    }

    public Integer getCatId() {
        return cat_id;
    }

    public void setCatId(Integer cat_id) {
        this.cat_id = cat_id;
    }

    public String getCatNom() {
        return cat_nom;
    }

    public void setCatNom(String cat_nom) {
        this.cat_nom = cat_nom;
    }

    public String getDescMarkdown() {
        return rut_desc_markdown;
    }

    public void setDescMarkdown(String rut_desc_markdown) {
        this.rut_desc_markdown = rut_desc_markdown;
    }

    public Integer getDesnivell() {
        return rut_desnivell;
    }

    public void setDesnivell(Integer rut_desnivell) {
        this.rut_desnivell = rut_desnivell;
    }

    public Integer getAlcadaMax() {
        return rut_alcada_max;
    }

    public void setAlcadaMax(Integer rut_alcada_max) {
        this.rut_alcada_max = rut_alcada_max;
    }

    public Integer getAlcadaMin() {
        return rut_alcada_min;
    }

    public void setAlcadaMin(Integer rut_alcada_min) {
        this.rut_alcada_min = rut_alcada_min;
    }

    public Float getDistanciaKm() {
        return rut_distancia_km;
    }

    public void setDistanciaKm(Float rut_distancia_km) {
        this.rut_distancia_km = rut_distancia_km;
    }

    public Long getTempsAproxLong() {
        return rut_temps_aprox;
    }

    public String getTempsAproxString(){
        return String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(rut_temps_aprox),
                TimeUnit.MILLISECONDS.toMinutes(rut_temps_aprox) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(rut_temps_aprox)),
                TimeUnit.MILLISECONDS.toSeconds(rut_temps_aprox) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(rut_temps_aprox)));
    }

    public void setTempsAprox(Long rut_temps_aprox) {
        this.rut_temps_aprox = rut_temps_aprox;
    }

    public Boolean getCircular() {
        return rut_circular;
    }

    public void setCircular(Boolean rut_circular) {
        this.rut_circular = rut_circular;
    }

    public Integer getDificultat() {
        return rut_dificultat_5;
    }

    public void setDificultat(Integer rut_dificultat_5) {
        this.rut_dificultat_5 = rut_dificultat_5;
    }

    public String getGpxFileURL() {
        return rut_gpx_File_URL;
    }

    public void setGpxFileURL(String rut_gpx_File_URL) {
        this.rut_gpx_File_URL = rut_gpx_File_URL;
    }

    public String getFotTitol() {
        return fot_titol;
    }

    public void setFotTitol(String fot_titol) {
        this.fot_titol = fot_titol;
    }

    public String getFotUrl() {
        return fot_url;
    }

    public void setFotUrl(String fot_url) {
        this.fot_url = fot_url;
    }

}