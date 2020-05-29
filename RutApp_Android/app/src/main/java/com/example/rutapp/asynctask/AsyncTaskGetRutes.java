package com.example.rutapp.asynctask;

import android.content.Context;
import android.os.AsyncTask;

import com.example.rutapp.model.Ruta;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class AsyncTaskGetRutes extends AsyncTask<Void, Void, ArrayList<Ruta>> {

    public static int GET_RUTES = 1;

    private Socket socket;
    private DataOutputStream dos;
    private ObjectInputStream ois;
    final int PORT = 17500;

    private Context context;
    private ArrayList<Ruta> rutes = new ArrayList<>();

    public AsyncTaskGetRutes(Context context){
        this.context = context;
    }

    @Override
    public ArrayList<Ruta> doInBackground(Void... voids) {
        try{
            socket = new Socket("192.168.1.128", PORT);
            dos = new DataOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            getRutes();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            desconectar();
        }
        return rutes;
    }

    public void getRutes(){
        try{
            dos.writeInt(GET_RUTES);

            int rutesSize = ois.readInt();
            for(int i=0;i<rutesSize;i++){
                Integer rut_id = (Integer)ois.readObject();
                String rut_titol = (String)ois.readObject();
                Integer cat_id = (Integer)ois.readObject();
                String cat_nom = (String)ois.readObject();
                String rut_desc_markdown = (String)ois.readObject();
                Integer rut_desnivell = (Integer)ois.readObject();
                Integer rut_alcada_max = (Integer)ois.readObject();
                Integer rut_alcada_min = (Integer)ois.readObject();
                Float rut_distancia_km = (Float)ois.readObject();
                Long rut_temps_aprox = (Long)ois.readObject();
                Boolean rut_circular = (Boolean)ois.readObject();
                Integer rut_dificultat_5 = (Integer)ois.readObject();
                String rut_gpx_File_URL = (String)ois.readObject();
                String fot_titol = (String)ois.readObject();
                String fot_url = (String)ois.readObject();
                Ruta ruta = new Ruta(rut_id,rut_titol,cat_id,cat_nom,rut_desc_markdown,rut_desnivell,rut_alcada_max,rut_alcada_min,rut_distancia_km,rut_temps_aprox,rut_circular,rut_dificultat_5,rut_gpx_File_URL,fot_titol,fot_url);
                rutes.add(ruta);
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
