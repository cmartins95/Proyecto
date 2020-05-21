package info.infomila.rutapp.exception;

public class RutAppException extends RuntimeException{
    
    public RutAppException(String message) {
        super(message);
    }

    public RutAppException(Throwable cause) {
        super(cause);
    }

    public RutAppException(String message , Throwable ex) {
        super(message,ex);
    }
    
}
