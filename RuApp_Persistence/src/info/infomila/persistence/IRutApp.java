package info.infomila.persistence;

import info.infomila.rutapp.Categoria;
import info.infomila.rutapp.Foto;
import info.infomila.rutapp.Punt;
import info.infomila.rutapp.Ruta;
import java.util.Iterator;

public interface IRutApp {
    
    Iterator<Categoria> getCategories();
    void addCategoria(Categoria categoria);
    void deleteCategoria(Categoria categoria);
    void deleteCategoria(int cat_id);
    
}
