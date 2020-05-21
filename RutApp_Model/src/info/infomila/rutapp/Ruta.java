package info.infomila.rutapp;

import info.infomila.rutapp.exception.RutAppException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Ruta {
    
    private Integer rut_id;
    private String rut_titol;
    private String rut_desc_markdown;
    private Integer rut_desnivell;
    private Integer rut_alcada_max;
    private Integer rut_alcada_min;
    private Float rut_distancia_km;
    private Date rut_temps_aprox;
    private Boolean rut_circular;
    private Integer rut_dificultat_5;
    private String rut_gpx_File_URL;
    private Foto rut_foto;
    private List<Punt> punts;

    protected Ruta(){
        
    }
    
    public Ruta(Integer rut_id, String rut_titol, String rut_desc_markdown, Integer rut_desnivell, Integer rut_alcada_max, Integer rut_alcada_min, Float rut_distancia_km, Date rut_temps_aprox, Boolean rut_circular, Integer rut_dificultat_5, String rut_gpx_File_URL, Foto rut_foto) {
        setRut_id(rut_id);
        setRut_titol(rut_titol);
        setRut_desc_markdown(rut_desc_markdown);
        setRut_desnivell(rut_desnivell);
        setRut_alcada_max(rut_alcada_max);
        setRut_alcada_min(rut_alcada_min);
        setRut_distancia_km(rut_distancia_km);
        setRut_temps_aprox(rut_temps_aprox);
        setRut_circular(rut_circular);
        setRut_dificultat_5(rut_dificultat_5);
        setRut_gpx_File_URL(rut_gpx_File_URL);
        setRut_foto(rut_foto);
        punts = new ArrayList<Punt>();
    }

    public Integer getRut_id() {
        return rut_id;
    }

    public void setRut_id(Integer rut_id) {
        if(rut_id==null){
            throw new RutAppException("RUT_ID CAN NOT BE NULL");
        }
        this.rut_id = rut_id;
    }
    
    public String getRut_titol() {
        return rut_titol;
    }

    public void setRut_titol(String rut_titol) {
        if(rut_titol==null){
            throw new RutAppException("RUT_TITOL CAN NOT BE NULL");
        }
        this.rut_titol = rut_titol;
    }

    public String getRut_desc_markdown() {
        return rut_desc_markdown;
    }

    public void setRut_desc_markdown(String rut_desc_markdown) {
        if(rut_desc_markdown==null){
            throw new RutAppException("RUT_DESC_MARKDOWN CAN NOT BE NULL");
        }
        this.rut_desc_markdown = rut_desc_markdown;
    }

    public Integer getRut_desnivell() {
        return rut_desnivell;
    }

    public void setRut_desnivell(Integer rut_desnivell) {
        if(rut_desnivell==null){
            throw new RutAppException("RUT_DESNIVELL CAN NOT BE NULL");
        }
        this.rut_desnivell = rut_desnivell;
    }

    public Integer getRut_alcada_max() {
        return rut_alcada_max;
    }

    public void setRut_alcada_max(Integer rut_alcada_max) {
        if(rut_alcada_max==null){
            throw new RutAppException("RUT_ALCADA_MAX CAN NOT BE NULL");
        }
        this.rut_alcada_max = rut_alcada_max;
    }

    public Integer getRut_alcada_min() {
        return rut_alcada_min;
    }

    public void setRut_alcada_min(Integer rut_alcada_min) {
        if(rut_alcada_min==null){
            throw new RutAppException("RUT_ALCADA_MIN CAN NOT BE NULL");
        }
        this.rut_alcada_min = rut_alcada_min;
    }

    public Float getRut_distancia_km() {
        return rut_distancia_km;
    }

    public void setRut_distancia_km(Float rut_distancia_km) {
        if(rut_distancia_km==null){
            throw new RutAppException("RUT_DISTANCIA_KM CAN NOT BE NULL");
        }
        this.rut_distancia_km = rut_distancia_km;
    }

    public Date getRut_temps_aprox() {
        return rut_temps_aprox;
    }

    public void setRut_temps_aprox(Date rut_temps_aprox) {
        if(rut_temps_aprox==null){
            throw new RutAppException("RUT_TEMPS_APROX CAN NOT BE NULL");
        }
        this.rut_temps_aprox = rut_temps_aprox;
    }

    public Boolean getRut_circular() {
        return rut_circular;
    }

    public void setRut_circular(Boolean rut_circular) {
        if(rut_circular==null){
            throw new RutAppException("RUT_CIRCULAR CAN NOT BE NULL");
        }
        this.rut_circular = rut_circular;
    }

    public Integer getRut_dificultat_5() {
        return rut_dificultat_5;
    }

    public void setRut_dificultat_5(Integer rut_dificultat_5) {
        if(rut_dificultat_5==null){
            throw new RutAppException("RUT_DIFICULTAT_5 CAN NOT BE NULL");
        }
        this.rut_dificultat_5 = rut_dificultat_5;
    }

    public String getRut_gpx_File_URL() {
        return rut_gpx_File_URL;
    }

    public void setRut_gpx_File_URL(String rut_gpx_File_URL) {
        this.rut_gpx_File_URL = rut_gpx_File_URL;
    }

    public Foto getRut_foto() {
        return rut_foto;
    }

    public void setRut_foto(Foto rut_foto) {
        if(rut_foto==null){
            throw new RutAppException("RUT_FOTO CAN NOT BE NULL");
        }
        this.rut_foto = rut_foto;
    }
    
    public int getPuntsCount(){
        return punts.size();
    }
    
    public Punt getPunt(int index){
        return punts.get(index);
    }
    
    public Iterator<Punt> getPunts(){
        return punts.iterator();
    }
    
    public void addPunt(Punt punt){
        punts.add(punt);
    }
    
    public Punt deletePunt(int index){
        return punts.remove(index);
    }
    
    public void deletePunt(Punt punt){
        punts.remove(punt);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.rut_id);
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
        final Ruta other = (Ruta) obj;
        if (!Objects.equals(this.rut_id, other.rut_id)) {
            return false;
        }
        return true;
    }
    
}
