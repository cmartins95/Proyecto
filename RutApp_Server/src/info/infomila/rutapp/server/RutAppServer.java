package info.infomila.rutapp.server;

import info.infomila.rutapp.server.exception.RutAppServerException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RutAppServer extends Thread {
    
    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;
    private int idSessio;
    
    public RutAppServer(Socket socket, int id) {
        if(socket==null){
            throw new RutAppServerException("El socket passat per paràmetre es null");
        }
        this.socket = socket;
        this.idSessio = id;
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            throw new RutAppServerException("Error al iniciar els canals de lectura y escriptura del socket",ex);
        }
    }
    
    public void desconnectar() {
        try {
            socket.close();
        } catch (IOException ex) {
            throw new RutAppServerException("No s'ha pogut desconectar correctament del servidor",ex);
        }
    }
    
    @Override
    public void run() {
        String accion = "";
        try {
            accion = dis.readUTF();
            if(accion.equals("hola")){
                System.out.println("El cliente con idSesion "+this.idSessio+" saluda");
                dos.writeUTF("adios");
            }
        } catch (IOException ex) {
            throw new RutAppServerException("No s'ha pogut connectar correctament al servidor",ex);
        }
        desconnectar();
    }
}