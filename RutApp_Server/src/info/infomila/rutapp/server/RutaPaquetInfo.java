package info.infomila.rutapp.server;

public class RutaPaquetInfo {
    
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

    public RutaPaquetInfo(Integer rut_id, String rut_titol, Integer cat_id, String cat_nom, String rut_desc_markdown, Integer rut_desnivell, Integer rut_alcada_max, Integer rut_alcada_min, Float rut_distancia_km, Long rut_temps_aprox, Boolean rut_circular, Integer rut_dificultat_5, String rut_gpx_File_URL, String fot_titol, String fot_url) {
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

    public Integer getRut_id() {
        return rut_id;
    }

    public void setRut_id(Integer rut_id) {
        this.rut_id = rut_id;
    }

    public String getRut_titol() {
        return rut_titol;
    }

    public void setRut_titol(String rut_titol) {
        this.rut_titol = rut_titol;
    }

    public Integer getCat_id() {
        return cat_id;
    }

    public void setCat_id(Integer cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_nom() {
        return cat_nom;
    }

    public void setCat_nom(String cat_nom) {
        this.cat_nom = cat_nom;
    }

    public String getRut_desc_markdown() {
        return rut_desc_markdown;
    }

    public void setRut_desc_markdown(String rut_desc_markdown) {
        this.rut_desc_markdown = rut_desc_markdown;
    }

    public Integer getRut_desnivell() {
        return rut_desnivell;
    }

    public void setRut_desnivell(Integer rut_desnivell) {
        this.rut_desnivell = rut_desnivell;
    }

    public Integer getRut_alcada_max() {
        return rut_alcada_max;
    }

    public void setRut_alcada_max(Integer rut_alcada_max) {
        this.rut_alcada_max = rut_alcada_max;
    }

    public Integer getRut_alcada_min() {
        return rut_alcada_min;
    }

    public void setRut_alcada_min(Integer rut_alcada_min) {
        this.rut_alcada_min = rut_alcada_min;
    }

    public Float getRut_distancia_km() {
        return rut_distancia_km;
    }

    public void setRut_distancia_km(Float rut_distancia_km) {
        this.rut_distancia_km = rut_distancia_km;
    }

    public Long getRut_temps_aprox() {
        return rut_temps_aprox;
    }

    public void setRut_temps_aprox(Long rut_temps_aprox) {
        this.rut_temps_aprox = rut_temps_aprox;
    }

    public Boolean getRut_circular() {
        return rut_circular;
    }

    public void setRut_circular(Boolean rut_circular) {
        this.rut_circular = rut_circular;
    }

    public Integer getRut_dificultat_5() {
        return rut_dificultat_5;
    }

    public void setRut_dificultat_5(Integer rut_dificultat_5) {
        this.rut_dificultat_5 = rut_dificultat_5;
    }

    public String getRut_gpx_File_URL() {
        return rut_gpx_File_URL;
    }

    public void setRut_gpx_File_URL(String rut_gpx_File_URL) {
        this.rut_gpx_File_URL = rut_gpx_File_URL;
    }

    public String getFot_titol() {
        return fot_titol;
    }

    public void setFot_titol(String fot_titol) {
        this.fot_titol = fot_titol;
    }

    public String getFot_url() {
        return fot_url;
    }

    public void setFot_url(String fot_url) {
        this.fot_url = fot_url;
    }
    
    
    
}
