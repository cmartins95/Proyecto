package info.infomila.rutapp;

import info.infomila.rutapp.exception.RutAppException;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Punt implements Serializable{
    
    private Integer pun_numero;
    private String pun_nom;
    private String pun_descripcio;
    private Long pun_hora;
    private Double pun_latitud;
    private Double pun_longitud;
    private Integer pun_elevacio;
    private Foto pun_foto;

    protected Punt(){
        
    }
    
    public Punt(Integer pun_numero, String pun_nom, String pun_descripcio, Long pun_hora, Double pun_latitud, Double pun_longitud, Integer pun_elevacio, Foto pun_foto) {
        setNumero(pun_numero);
        setNom(pun_nom);
        setDescripcio(pun_descripcio);
        setHora(pun_hora);
        setLatitud(pun_latitud);
        setLongitud(pun_longitud);
        setElevacio(pun_elevacio);
        setFoto(pun_foto);
    }

    public Integer getNumero() {
        return pun_numero;
    }

    public void setNumero(Integer pun_numero) {
        if(pun_numero==null){
            throw new RutAppException("PUN_NUMERO CAN NOT BE NULL");
        }
        this.pun_numero = pun_numero;
    }

    public String getNom() {
        return pun_nom;
    }

    public void setNom(String pun_nom) {
        if(pun_nom==null){
            throw new RutAppException("PUN_NOM CAN NOT BE NULL");
        }
        this.pun_nom = pun_nom;
    }

    public String getDescripcio() {
        return pun_descripcio;
    }

    public void setDescripcio(String pun_descripcio) {
        if(pun_descripcio==null){
            throw new RutAppException("PUN_DESCRIPCIO CAN NOT BE NULL");
        }
        this.pun_descripcio = pun_descripcio;
    }

    public String getHoraString(){
        return String.format("%02d:%02d:%02d", 
        TimeUnit.MILLISECONDS.toHours(pun_hora),
        TimeUnit.MILLISECONDS.toMinutes(pun_hora) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(pun_hora)),
        TimeUnit.MILLISECONDS.toSeconds(pun_hora) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(pun_hora)));
    }
    
    public long getHoraLong() {
        return pun_hora;
    }

    public void setHora(Long pun_hora) {
        this.pun_hora = pun_hora;
    }

    public Double getPun_latitud() {
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

    public void setElevacio(Integer pun_elevacio) {
        this.pun_elevacio = pun_elevacio;
    }

    public Foto getFoto() {
        return pun_foto;
    }

    public void setFoto(Foto pun_foto) {
        if(pun_foto==null){
            throw new RutAppException("PUN_FOTO CAN NOT BE NULL");
        }
        this.pun_foto = pun_foto;
    }

}
