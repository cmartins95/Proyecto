package info.infomila.rutapp.gestio;

import info.infomila.utils.RutAppUtils;
import info.infomila.utils.RutAppUtilsFactory;
import info.infomila.utils.exception.RutAppUtilsException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        
        try{
            RutAppUtils obj = RutAppUtilsFactory.getInstance("info.infomila.rutapp.persistence.RutAppPersistence");
            SwingGestorCategories sc = new SwingGestorCategories(obj);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    
}
