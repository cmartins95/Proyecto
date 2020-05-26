package info.infomila.rutapp.server;

public class PuntPaquetInfo {
    
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

    public PuntPaquetInfo(Integer rut_id, Integer pun_numero, String pun_nom, String pun_descripcio, Long pun_hora, Double pun_latitud, Double pun_longitud, Integer pun_elevacio, String fot_titol, String fot_url) {
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

    public Integer getRut_id() {
        return rut_id;
    }

    public void setRut_id(Integer rut_id) {
        this.rut_id = rut_id;
    }

    public Integer getPun_numero() {
        return pun_numero;
    }

    public void setPun_numero(Integer pun_numero) {
        this.pun_numero = pun_numero;
    }

    public String getPun_nom() {
        return pun_nom;
    }

    public void setPun_nom(String pun_nom) {
        this.pun_nom = pun_nom;
    }

    public String getPun_descripcio() {
        return pun_descripcio;
    }

    public void setPun_descripcio(String pun_descripcio) {
        this.pun_descripcio = pun_descripcio;
    }

    public Long getPun_hora() {
        return pun_hora;
    }

    public void setPun_hora(Long pun_hora) {
        this.pun_hora = pun_hora;
    }

    public Double getPun_latitud() {
        return pun_latitud;
    }

    public void setPun_latitud(Double pun_latitud) {
        this.pun_latitud = pun_latitud;
    }

    public Double getPun_longitud() {
        return pun_longitud;
    }

    public void setPun_longitud(Double pun_longitud) {
        this.pun_longitud = pun_longitud;
    }

    public Integer getPun_elevacio() {
        return pun_elevacio;
    }

    public void setPun_elevacio(Integer pun_elevacio) {
        this.pun_elevacio = pun_elevacio;
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
