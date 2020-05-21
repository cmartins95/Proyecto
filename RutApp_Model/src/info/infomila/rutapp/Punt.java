package info.infomila.rutapp;

import info.infomila.rutapp.exception.RutAppException;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Punt {
    
    private Integer pun_id;
    private Integer pun_numero;
    private String pun_nom;
    private String pun_descripcio;
    private Date pun_hora;
    private Double pun_latitud;
    private Double pun_longitud;
    private Integer pun_elevacio;
    private Foto pun_foto;

    protected Punt(){
        
    }
    
    public Punt(Integer pun_id, Integer pun_numero, String pun_nom, String pun_descripcio, Date pun_hora, Double pun_latitud, Double pun_longitud, Integer pun_elevacio, Foto pun_foto) {
        setPun_id(pun_id);
        setPun_numero(pun_numero);
        setPun_nom(pun_nom);
        setPun_descripcio(pun_descripcio);
        setPun_hora(pun_hora);
        setPun_latitud(pun_latitud);
        setPun_longitud(pun_longitud);
        setPun_elevacio(pun_elevacio);
        setPun_foto(pun_foto);
    }

    public Integer getPun_id() {
        return pun_id;
    }

    public void setPun_id(Integer pun_id) {
        if(pun_id==null){
            throw new RutAppException("PUN_ID CAN NOT BE NULL");
        }
        this.pun_id = pun_id;
    }

    public Integer getPun_numero() {
        return pun_numero;
    }

    public void setPun_numero(Integer pun_numero) {
        if(pun_numero==null){
            throw new RutAppException("PUN_NUMERO CAN NOT BE NULL");
        }
        this.pun_numero = pun_numero;
    }

    public String getPun_nom() {
        return pun_nom;
    }

    public void setPun_nom(String pun_nom) {
        if(pun_nom==null){
            throw new RutAppException("PUN_NOM CAN NOT BE NULL");
        }
        this.pun_nom = pun_nom;
    }

    public String getPun_descripcio() {
        return pun_descripcio;
    }

    public void setPun_descripcio(String pun_descripcio) {
        if(pun_descripcio==null){
            throw new RutAppException("PUN_DESCRIPCIO CAN NOT BE NULL");
        }
        this.pun_descripcio = pun_descripcio;
    }

    public Date getPun_hora() {
        return pun_hora;
    }

    public void setPun_hora(Date pun_hora) {
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

    public Foto getPun_foto() {
        return pun_foto;
    }

    public void setPun_foto(Foto pun_foto) {
        if(pun_foto==null){
            throw new RutAppException("PUN_FOTO CAN NOT BE NULL");
        }
        this.pun_foto = pun_foto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.pun_id);
        hash = 83 * hash + Objects.hashCode(this.pun_numero);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Punt other = (Punt) obj;
        if (!Objects.equals(this.pun_id, other.pun_id)) {
            return false;
        }
        if (!Objects.equals(this.pun_numero, other.pun_numero)) {
            return false;
        }
        return true;
    }

}
