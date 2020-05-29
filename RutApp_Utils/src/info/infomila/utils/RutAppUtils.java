package info.infomila.utils;

import info.infomila.rutapp.Categoria;
import info.infomila.rutapp.Foto;
import info.infomila.rutapp.Punt;
import info.infomila.rutapp.Ruta;
import java.util.Iterator;
import java.util.List;

public interface RutAppUtils {
    
    List<Categoria> getCategories();
    void crearCategoria(Categoria categoria);
    void modificaCategoria(Categoria categoria);
    void eliminaCategoria(Categoria categoria);
    int getNewCategoriaId();
    
    List<Ruta> getRutes();
    List<Ruta> getRutes(Categoria c);
    
    void transaction();
    void commit();
    
}
