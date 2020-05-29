package com.example.rutapp.asynctask;

import android.content.Context;
import android.os.AsyncTask;

import com.example.rutapp.model.Punt;
import com.example.rutapp.model.Ruta;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class AsyncTaskGetPunts extends AsyncTask<Void, Void, ArrayList<Punt>> {

    public static int GET_PUNTS = 2;

    private Socket socket;
    private DataOutputStream dos;
    private ObjectInputStream ois;
    final int PORT = 17500;

    private int id_ruta;
    private Context context;
    private ArrayList<Punt> punts = new ArrayList<Punt>();

    public AsyncTaskGetPunts(Context context, int id_ruta){
        this.context = context;
        this.id_ruta = id_ruta;
    }

    @Override
    public ArrayList<Punt> doInBackground(Void... voids) {
        try{
            socket = new Socket("192.168.1.128", PORT);
            dos = new DataOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            getPunts();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            desconectar();
        }
        return punts;
    }

    public void getPunts(){
        Punt punt;
        try{
            dos.writeInt(GET_PUNTS);
            dos.writeInt(id_ruta);
            int puntsSize = ois.readInt();
            for(int i=0;i<puntsSize;i++){
                Integer rut_id = (Integer)ois.readObject();
                Integer pun_numero = (Integer)ois.readObject();
                String pun_nom = (String)ois.readObject();
                String pun_descripcio = (String)ois.readObject();
                Long pun_hora = (Long)ois.readObject();
                Double pun_latitud = (Double)ois.readObject();
                Double pun_longitud = (Double)ois.readObject();
                Integer pun_elevacio = (Integer)ois.readObject();
                String fot_titol = (String)ois.readObject();
                String fot_url = (String)ois.readObject();
                punt = new Punt(rut_id,pun_numero,pun_nom,pun_descripcio,pun_hora,pun_latitud,pun_longitud,pun_elevacio,fot_titol,fot_url);
                punts.add(punt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void desconectar(){
        try{
            dos.close();
            ois.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

}
