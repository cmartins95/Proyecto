package info.infomila.rutapp;

import info.infomila.rutapp.exception.RutAppException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="categoria")
public class Categoria implements Serializable{

    @Id
    private Integer cat_id;
    
    @Basic(optional = false)
    @Column(length=255,nullable = false)
    private String cat_nom;
    
    @ManyToOne(optional = true, cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
    @JoinColumn(name = "cat_pare", nullable = true, foreignKey = @ForeignKey(name = "CATEGORIA_CATEGORIA_FK"))
    private Categoria cat_pare;
    
    @OneToMany(mappedBy = "cat_pare")
    private List<Categoria> cat_filles;
    
    @OneToMany(mappedBy = "rut_cat_id")
    private List<Ruta> cat_rutes;
    
    protected Categoria(){
        
    }
    
    public Categoria(Integer cat_id, String cat_nom) {
        setId(cat_id);
        setNom(cat_nom);
        cat_rutes = new ArrayList<Ruta>();
        cat_filles = new ArrayList<Categoria>();
    }

    public Categoria(Integer cat_id, String cat_nom, Categoria cat_pare) {
        setId(cat_id);
        setNom(cat_nom);
        setPare(cat_pare);
        cat_rutes = new ArrayList<Ruta>();
        cat_filles = new ArrayList<Categoria>();
    }
    
    public Integer getId() {
        return cat_id;
    }

    public void setId(Integer cat_id) {
        if(cat_id==null){
            throw new RutAppException("CAT_ID CAN NOT BE NULL");
        }
        this.cat_id = cat_id;
    }

    public String getNom() {
        return cat_nom;
    }

    public void setNom(String cat_nom) {
        if(cat_nom==null){
            throw new RutAppException("CAT_NOM CAN NOT BE NULL");
        }
        this.cat_nom = cat_nom;
    }

    public Categoria getPare() {
        return cat_pare;
    }

    public void setPare(Categoria cat_pare) {
        this.cat_pare = cat_pare;
    }

    public int getFillesCount(){
        return cat_filles.size();
    }
    
    public Categoria getFilla(int index){
        return cat_filles.get(index);
    }
    
    public List<Categoria> getListFilles(){
        return cat_filles;
    }
    
    public Iterator<Categoria> getFilles(){
        return cat_filles.iterator();
    }
    
    public void addFilla(Categoria filla){
        cat_filles.add(filla);
    }
    
    public Categoria deleteFilla(int index){
        return cat_filles.remove(index);
    }
    
    public void deleteFilla(Categoria filla){
        cat_filles.remove(filla);
    }
    
    public int getRutesCount(){
        return cat_rutes.size();
    }
    
    public Ruta getRuta(int index){
        return cat_rutes.get(index);
    }
    
    public Iterator<Ruta> getRutes(){
        return cat_rutes.iterator();
    }
    
    public void addRuta(Ruta ruta){
        cat_rutes.add(ruta);
    }
    
    public Ruta deleteRuta(int index){
        return cat_rutes.remove(index);
    }
    
    public void deleteRuta(Ruta ruta){
        cat_rutes.remove(ruta);
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.cat_id;
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
        final Categoria other = (Categoria) obj;
        if (this.cat_id != other.cat_id) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return cat_nom;
    }
    
}
