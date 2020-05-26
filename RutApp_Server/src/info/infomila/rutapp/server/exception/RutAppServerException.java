package info.infomila.rutapp.server.exception;

import java.io.IOException;

public class RutAppServerException extends RuntimeException{
    
    public RutAppServerException(String message) {
        super(message);
    }

    public RutAppServerException(Throwable cause) {
        super(cause);
    }

    public RutAppServerException(String message , Throwable ex) {
        super(message,ex);
    }
    
}
