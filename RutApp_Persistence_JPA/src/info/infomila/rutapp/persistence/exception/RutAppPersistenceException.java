package info.infomila.rutapp.persistence.exception;

public class RutAppPersistenceException extends RuntimeException{
    
    public RutAppPersistenceException(String message) {
        super(message);
    }

    public RutAppPersistenceException(Throwable cause) {
        super(cause);
    }

    public RutAppPersistenceException(String message , Throwable ex) {
        super(message,ex);
    }
    
}
