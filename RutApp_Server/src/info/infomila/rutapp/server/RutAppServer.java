package info.infomila.rutapp.server;

import info.infomila.rutapp.server.exception.RutAppServerException;
import info.infomila.utils.RutAppUtils;
import info.infomila.utils.exception.RutAppUtilsException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RutAppServer extends Thread {
    
    private Socket socket;
    private DataInputStream dis;
    private ObjectOutputStream oos;
    private int idSessio;
    private ConnectionJDBC con;
    
    public RutAppServer(Socket socket, ConnectionJDBC con, int id) {
        if(socket==null){
            throw new RutAppServerException("El socket passat per paràmetre es null");
        }
        this.socket = socket;
        this.idSessio = id;
        this.con = con;
        try {
            dis = new DataInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
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
        int accion;
        try {
            accion = dis.readInt();
            if(accion==1){
                EnviarRutes();
            }else if(accion==2){
                InfoRuta();
            }
        } catch (IOException ex) {
            throw new RutAppServerException("No s'ha pogut connectar correctament al servidor",ex);
        } finally {
            desconnectar();
        }
    }

    private void EnviarRutes() {
        try{
            List<InfoRuta> rutes = con.getRutes();
            //dos.writeInt(rutes.size());
            oos.writeInt(rutes.size());
            for(InfoRuta r : rutes){
                oos.writeObject(r.getId());
                oos.writeObject(r.getTitol());
                oos.writeObject(r.getCatId());
                oos.writeObject(r.getCatNom());
                oos.writeObject(r.getDescMarkdown());
                oos.writeObject(r.getDesnivell());
                oos.writeObject(r.getAlcadaMax());
                oos.writeObject(r.getAlcadaMin());
                oos.writeObject(r.getDistanciaKm());
                oos.writeObject(r.getTempsAprox());
                oos.writeObject(r.getCircular());
                oos.writeObject(r.getDificultat());
                oos.writeObject(r.getGpxFileURL());
                oos.writeObject(r.getFotTitol());
                oos.writeObject(r.getFotUrl());
            }
        }catch (IOException ex){
            throw new RutAppServerException("Error en enviar les rutes");
        }
    }
    
    private void InfoRuta(){
        try {
            int id_ruta = dis.readInt();
            List<InfoPunt> punts = con.getPunts(id_ruta);
            oos.writeInt(punts.size());
            for(InfoPunt p : punts){
                oos.writeObject(p.getId());
                oos.writeObject(p.getNumero());
                oos.writeObject(p.getNom());
                oos.writeObject(p.getDescripcio());
                oos.writeObject(p.getHoraLong());
                oos.writeObject(p.getLatitud());
                oos.writeObject(p.getLongitud());
                oos.writeObject(p.getElevacio());
                oos.writeObject(p.getFotTitol());
                oos.writeObject(p.getFotUrl());
            }
        } catch (IOException ex) {
            throw new RutAppServerException("Error en enviar els punts de rutes");
        }
    }
    
}