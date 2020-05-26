package info.infomila.utils;

import info.infomila.utils.exception.RutAppUtilsException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RutAppUtilsFactory {
    
    protected RutAppUtilsFactory() {
    }

    static public RutAppUtils getInstance(String nomClasseComponent) throws RutAppUtilsException {
        RutAppUtils obj;
        try {
            obj = (RutAppUtils) Class.forName(nomClasseComponent).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            throw new RutAppUtilsException("Error en carregar/instanciar la classe " + nomClasseComponent, ex);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RutAppUtilsException("Error en invocar constructor de classe " + nomClasseComponent, ex);
            
        }
        return obj;
    }

    static public RutAppUtils getInstance(String nomClasseComponent, String nomFitxerPropietats) throws RutAppUtilsException {
        RutAppUtils obj;
        try {
            Class cl = Class.forName(nomClasseComponent);
            Constructor co = cl.getConstructor(String.class);
            obj = (RutAppUtils) co.newInstance(nomFitxerPropietats);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException ex) {
            throw new RutAppUtilsException("Error en carregar/instanciar la classe " + nomClasseComponent, ex);
        }
        return obj;
    }
    
}
