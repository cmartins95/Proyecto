package info.infomila.rutapp;

import info.infomila.rutapp.exception.RutAppException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ruta")
public class Ruta implements Serializable{
    
    @Id
    private Integer rut_id;
    
    @Basic(optional = false)
    @Column(length=255,nullable = false)
    private String rut_titol;
    
    @ManyToOne(optional = true, cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
    @JoinColumn(name = "rut_cat_id", foreignKey = @ForeignKey(name = "RUTA_CATEGORIA_FK"))
    private Categoria rut_cat_id;
    
    //@Basic(optional = false)
    //@Column(name = "RUT_DESC_MARKDOWN", nullable = false, length = 65535, columnDefinition="TEXT")
    @Transient
    private String rut_desc_markdown;
    
    //@Basic(optional = false)
    //@Column(nullable = false)
    @Transient
    private Integer rut_desnivell;
    
    //@Basic(optional = false)
    //@Column(nullable = false)
    @Transient
    private Integer rut_alcada_max;
    
    //@Basic(optional = false)
    //@Column(nullable = false)
    @Transient
    private Integer rut_alcada_min;
    
    //@Basic(optional = false)
    //@Column(nullable = false)
    @Transient
    private Float rut_distancia_km;
    
    //@Basic(optional = false)
    //@Column(nullable = false)
    @Transient
    private Long rut_temps_aprox;
    
    //@Basic(optional = false)
    //@Column(nullable = false)
    @Transient
    private Boolean rut_circular;
    
    //@Basic(optional = false)
    //@Column(nullable = false)
    @Transient
    private Integer rut_dificultat_5;
    
    //@Basic(optional = true)
    //@Column(name = "RUT_GPX_FILE_URL", nullable = true, length = 65535, columnDefinition="TEXT")
    @Transient
    private String rut_gpx_File_URL;
    
    @Transient
    private Foto rut_foto; //Innecesario
    
    @Transient
    private List<Punt> punts; //Innecesario

    protected Ruta(){
        
    }
    
    public Ruta(Integer rut_id, String rut_titol, Categoria categoria, String rut_desc_markdown, Integer rut_desnivell, Integer rut_alcada_max, Integer rut_alcada_min, Float rut_distancia_km, Long rut_temps_aprox, Boolean rut_circular, Integer rut_dificultat_5, String rut_gpx_File_URL, Foto rut_foto) {
        setId(rut_id);
        setTitol(rut_titol);
        setCategoria(categoria);
        setDescMarkdown(rut_desc_markdown);
        setDesnivell(rut_desnivell);
        setAlcadaMax(rut_alcada_max);
        setAlcadaMin(rut_alcada_min);
        setDistanciaKm(rut_distancia_km);
        setTempsAprox(rut_temps_aprox);
        setCircular(rut_circular);
        setDificultat(rut_dificultat_5);
        setGpxFileURL(rut_gpx_File_URL);
        setFoto(rut_foto);
        punts = new ArrayList<Punt>();
    }

    public Integer getId() {
        return rut_id;
    }

    public void setId(Integer rut_id) {
        if(rut_id==null){
            throw new RutAppException("RUT_ID CAN NOT BE NULL");
        }
        this.rut_id = rut_id;
    }
    
    public String getTitol() {
        return rut_titol;
    }

    public void setTitol(String rut_titol) {
        if(rut_titol==null){
            throw new RutAppException("RUT_TITOL CAN NOT BE NULL");
        }
        this.rut_titol = rut_titol;
    }

    public Categoria getCategoria(){
        return rut_cat_id;
    }
    
    public void setCategoria(Categoria categoria){
        if(categoria==null){
            throw new RutAppException("CATEGORIA CAN NOT BE NULL");
        }
        this.rut_cat_id = categoria;
    }
    
    public String getDescMarkdown() {
        return rut_desc_markdown;
    }

    public void setDescMarkdown(String rut_desc_markdown) {
        if(rut_desc_markdown==null){
            throw new RutAppException("RUT_DESC_MARKDOWN CAN NOT BE NULL");
        }
        this.rut_desc_markdown = rut_desc_markdown;
    }

    public Integer getDesnivell() {
        return rut_desnivell;
    }

    public void setDesnivell(Integer rut_desnivell) {
        if(rut_desnivell==null){
            throw new RutAppException("RUT_DESNIVELL CAN NOT BE NULL");
        }
        this.rut_desnivell = rut_desnivell;
    }

    public Integer getAlcadaMax() {
        return rut_alcada_max;
    }

    public void setAlcadaMax(Integer rut_alcada_max) {
        if(rut_alcada_max==null){
            throw new RutAppException("RUT_ALCADA_MAX CAN NOT BE NULL");
        }
        this.rut_alcada_max = rut_alcada_max;
    }

    public Integer getAlcadaMin() {
        return rut_alcada_min;
    }

    public void setAlcadaMin(Integer rut_alcada_min) {
        if(rut_alcada_min==null){
            throw new RutAppException("RUT_ALCADA_MIN CAN NOT BE NULL");
        }
        this.rut_alcada_min = rut_alcada_min;
    }

    public Float getDistanciaKm() {
        return rut_distancia_km;
    }

    public void setDistanciaKm(Float rut_distancia_km) {
        if(rut_distancia_km==null){
            throw new RutAppException("RUT_DISTANCIA_KM CAN NOT BE NULL");
        }
        this.rut_distancia_km = rut_distancia_km;
    }

    public Long getTempsAproxLong() {
        return rut_temps_aprox;
    }
    
    public String getTempsAproxString() {
        return String.format("%02d:%02d:%02d", 
        TimeUnit.MILLISECONDS.toHours(rut_temps_aprox),
        TimeUnit.MILLISECONDS.toMinutes(rut_temps_aprox) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(rut_temps_aprox)),
        TimeUnit.MILLISECONDS.toSeconds(rut_temps_aprox) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(rut_temps_aprox)));
    }

    public void setTempsAprox(Long rut_temps_aprox) {
        if(rut_temps_aprox==null){
            throw new RutAppException("RUT_TEMPS_APROX CAN NOT BE NULL");
        }
        this.rut_temps_aprox = rut_temps_aprox;
    }

    public Boolean getCircular() {
        return rut_circular;
    }

    public void setCircular(Boolean rut_circular) {
        if(rut_circular==null){
            throw new RutAppException("RUT_CIRCULAR CAN NOT BE NULL");
        }
        this.rut_circular = rut_circular;
    }

    public Integer getDificultat() {
        return rut_dificultat_5;
    }

    public void setDificultat(Integer rut_dificultat_5) {
        if(rut_dificultat_5==null || rut_dificultat_5<0 || rut_dificultat_5>5){
            throw new RutAppException("RUT_DIFICULTAT_5 CAN NOT BE NULL (0-5)");
        }
        this.rut_dificultat_5 = rut_dificultat_5;
    }

    public String getGpxFileURL() {
        return rut_gpx_File_URL;
    }

    public void setGpxFileURL(String rut_gpx_File_URL) {
        this.rut_gpx_File_URL = rut_gpx_File_URL;
    }

    public Foto getFoto() {
        return rut_foto;
    }

    public void setFoto(Foto rut_foto) {
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
