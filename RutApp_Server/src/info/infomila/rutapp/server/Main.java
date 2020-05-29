package info.infomila.rutapp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        EncenderServidor();
    }
    
    public static void EncenderServidor(){
        final int PORT = 17500;
        ServerSocket serverSocket;
        System.out.print("Inicializando servidor... ");
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("\t[OK]");
            int idSession = 0;
            while (true) {
                Socket socket;
                socket = serverSocket.accept();
                System.out.println("Nueva conexión entrante: "+socket);
                ConnectionJDBC con = new ConnectionJDBC();
                ((RutAppServer) new RutAppServer(socket,con,idSession)).start();
                idSession++;
            }
        } catch (IOException ex) {
            System.out.println("ERROR: "+ex.getMessage());
        }
    }
    
}
