package info.infomila.rutapp.persistence;

import info.infomila.rutapp.Categoria;
import info.infomila.rutapp.Ruta;
import info.infomila.rutapp.persistence.exception.RutAppPersistenceException;
import info.infomila.rutapp.exception.RutAppException;
import info.infomila.utils.RutAppUtils;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class RutAppPersistence implements RutAppUtils{
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public RutAppPersistence(){
        this("RutAppConnection.properties");
    }
    
    public RutAppPersistence(String propertiesFile){
        
        if(propertiesFile==null || propertiesFile.trim().length()==0){
            throw new RutAppPersistenceException("El path del propertiesFile no pot se null");
        }
        
        Properties props = new Properties();
        try {
            props.load(new FileReader(propertiesFile));
        } catch (FileNotFoundException ex) {
            throw new RutAppPersistenceException("No es troba el fitxer de propietats indicat",ex);
        } catch (IOException ex) {
            throw new RutAppPersistenceException("Error en carregar el fitxer de propietats",ex);
        }
        
        HashMap<String, String> propietats = new HashMap();
        propietats.put("javax.persistence.jdbc.url",props.getProperty("host"));
        propietats.put("javax.persistence.jdbc.user",props.getProperty("user"));
        propietats.put("javax.persistence.jdbc.password",props.getProperty("pass"));
        propietats.put("javax.persistence.jdbc.driver",props.getProperty("driver"));
        
       // try {
            emf = Persistence.createEntityManagerFactory("default", propietats);
            em = emf.createEntityManager();
        //} catch (Exception ex) {
            //throw new RutAppPersistenceException("Error en intentar connectar amb el servidor",ex);
       // }
    }
    
    public void close(){
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }

    @Override
    public List<Categoria> getCategories() {
        String consulta = "select c from Categoria c where cat_pare is null order by cat_nom";
        Query q = em.createQuery(consulta);
        return q.getResultList();
    }
    
    @Override
    public List<Ruta> getRutes(Categoria c) {
        List<Ruta> rutes = new ArrayList<Ruta>();
        Iterator<Ruta> it = c.getRutes();
        while(it.hasNext()){
            rutes.add(it.next());
        }
        return rutes;
    }

    @Override
    public void crearCategoria(Categoria categoria) {
        em.persist(categoria);
    }

    @Override
    public void modificaCategoria(Categoria categoria) {
        em.persist(categoria);
    }

    @Override
    public void eliminaCategoria(Categoria categoria) {
        em.remove(categoria);
    }

    @Override
    public int getNewCategoriaId() {
        String consulta = "select max(cat_id+1) from Categoria";
        Query q = em.createQuery(consulta);
        return (int)q.getResultList().get(0);
    }
    
    @Override
    public void transaction() {
        em.getTransaction().begin();
    }
    
    @Override
    public void commit() {
        em.getTransaction().commit();
    }

    @Override
    public List<Ruta> getRutes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
