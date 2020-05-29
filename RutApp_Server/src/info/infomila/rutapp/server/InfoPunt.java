package info.infomila.rutapp.server;

import java.util.concurrent.TimeUnit;

public class InfoPunt {
    
    private Integer rut_id;
    private Integer pun_numero;
    private String pun_nom;
    private String pun_descripcio;
    private Long pun_hora;
    private Double pun_latitud;
    private Double pun_longitud;
    private Integer pun_elevacio;
    private String fot_titol;
    private String fot_url;

    public InfoPunt(Integer rut_id, Integer pun_numero, String pun_nom, String pun_descripcio, Long pun_hora, Double pun_latitud, Double pun_longitud, Integer pun_elevacio, String fot_titol, String fot_url) {
        this.rut_id = rut_id;
        this.pun_numero = pun_numero;
        this.pun_nom = pun_nom;
        this.pun_descripcio = pun_descripcio;
        this.pun_hora = pun_hora;
        this.pun_latitud = pun_latitud;
        this.pun_longitud = pun_longitud;
        this.pun_elevacio = pun_elevacio;
        this.fot_titol = fot_titol;
        this.fot_url = fot_url;
    }

    public Integer getId() {
        return rut_id;
    }

    public void setId(Integer rut_id) {
        this.rut_id = rut_id;
    }

    public Integer getNumero() {
        return pun_numero;
    }

    public void setNumero(Integer pun_numero) {
        this.pun_numero = pun_numero;
    }

    public String getNom() {
        return pun_nom;
    }

    public void setNom(String pun_nom) {
        this.pun_nom = pun_nom;
    }

    public String getDescripcio() {
        return pun_descripcio;
    }

    public void setDescripcio(String pun_descripcio) {
        this.pun_descripcio = pun_descripcio;
    }

    public Long getHoraLong() {
        return pun_hora;
    }
    
    public String getHoraString(){
        return String.format("%02d:%02d:%02d", 
        TimeUnit.MILLISECONDS.toHours(pun_hora),
        TimeUnit.MILLISECONDS.toMinutes(pun_hora) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(pun_hora)),
        TimeUnit.MILLISECONDS.toSeconds(pun_hora) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(pun_hora)));
    }
    
    public void setHora(Long pun_hora) {
        this.pun_hora = pun_hora;
    }

    public Double getLatitud() {
        return pun_latitud;
    }

    public void setLatitud(Double pun_latitud) {
        this.pun_latitud = pun_latitud;
    }

    public Double getLongitud() {
        return pun_longitud;
    }

    public void setLongitud(Double pun_longitud) {
        this.pun_longitud = pun_longitud;
    }

    public Integer getElevacio() {
        return pun_elevacio;
    }

    public void setEelevacio(Integer pun_elevacio) {
        this.pun_elevacio = pun_elevacio;
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
