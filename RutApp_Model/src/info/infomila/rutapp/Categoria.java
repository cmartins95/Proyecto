package info.infomila.rutapp;

import info.infomila.rutapp.exception.RutAppException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Categoria {
    
    private Integer cat_id;
    private String cat_nom;
    private List<Categoria> cat_fills;
    private List<Ruta> cat_rutes;
    
    protected Categoria(){
        
    }
    
    public Categoria(Integer cat_id, String cat_nom) {
        setCat_id(cat_id);
        setCat_nom(cat_nom);
        cat_fills = new ArrayList();
        cat_rutes = new ArrayList<Ruta>();
    }

    public Integer getCat_id() {
        return cat_id;
    }

    public void setCat_id(Integer cat_id) {
        if(cat_id==null){
            throw new RutAppException("CAT_ID CAN NOT BE NULL");
        }
        this.cat_id = cat_id;
    }

    public String getCat_nom() {
        return cat_nom;
    }

    public void setCat_nom(String cat_nom) {
        if(cat_nom==null){
            throw new RutAppException("CAT_NOM CAN NOT BE NULL");
        }
        this.cat_nom = cat_nom;
    }

    public int getCatFillesCount(){
        return cat_fills.size();
    }
    
    public Categoria getCatFilla(int index){
        return cat_fills.get(index);
    }
    
    public Iterator<Categoria> getCatFilles(){
        return cat_fills.iterator();
    }
    
    public void addCatFilla(Categoria filla){
        cat_fills.add(filla);
    }
    
    public Categoria deleteCatFilla(int index){
        return cat_fills.remove(index);
    }
    
    public void deleteCatFilla(Categoria filla){
        cat_fills.remove(filla);
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
    
}
