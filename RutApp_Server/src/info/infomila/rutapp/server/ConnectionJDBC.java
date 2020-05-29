package info.infomila.rutapp.server;

import info.infomila.rutapp.server.exception.RutAppServerException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionJDBC {
    
    private Connection con = null;
    private String nomFitxerPropietats;
    
    public ConnectionJDBC(){
        this("ConnectionJDBC.properties");
    }
    
    public ConnectionJDBC(String nomFitxerPropietats){
        if(nomFitxerPropietats == null){
            throw new RutAppServerException("El fitxer de propietats es obligatori");
        }
        this.nomFitxerPropietats = nomFitxerPropietats;

        Properties p = new Properties();
        try {
            p.load(new FileReader(nomFitxerPropietats));
        } catch (IOException ex) {
            throw new RutAppServerException("Problemes en carrregar la configuracio");
        }

        String url = p.getProperty("url");
        String usu = p.getProperty("usuari");
        String pwd = p.getProperty("contrasenya");
        
        if(url==null || usu==null || pwd==null) {
            throw new RutAppServerException("Falten alguna de les tres propietats");
        }

        try {
            con = DriverManager.getConnection(url,usu,pwd);
            con.setAutoCommit(false);
        } catch (SQLException ex) {
            throw new RutAppServerException("Problemes en establir la connecxio",ex);
        }
    }
    
    public List<InfoRuta> getRutes(){
        List<InfoRuta> rutes = new ArrayList<InfoRuta>();
        String consulta = "select \n" +
            "r.rut_id as \"ID\", \n" +
            "r.rut_titol as \"TITOL\", \n" +
            "c.cat_id as \"CAT_ID\",\n" +
            "c.cat_nom as \"CAT_NOM\", \n" +
            "r.rut_desc_markdown as \"DESCRIPCIO\", \n" +
            "r.rut_desnivell as \"DESNIVELL\", \n" +
            "r.rut_alcada_max as \"ALC_MAX\", \n" +
            "r.rut_alcada_min as \"ALC_MIN\", \n" +
            "r.rut_distancia_km as \"DISTANCIA\", \n" +
            "r.rut_temps_aprox as \"TEMPS\", \n" +
            "r.rut_circular as \"CIRCULAR\", \n" +
            "r.rut_dificultat_5 as \"DIFICULTAT\", \n" +
            "r.rut_gpx_File_URL as \"GPXFILE\",\n" +
            "f.fot_titol as \"FOT_TITOL\",\n" +
            "f.fot_url as \"FOT_URL\"\n" +
            "from ruta r join categoria c on c.cat_id = r.rut_cat_id\n" +
            "join foto f on f.fot_id = r.rut_foto;";
        Statement st;
        try{
            st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while(rs.next()){
                Integer rutId = rs.getInt("ID");
                String rutTit = rs.getString("TITOL");
                Integer catId = rs.getInt("CAT_ID");
                String catNom = rs.getString("CAT_NOM");
                String rutDesc = rs.getString("DESCRIPCIO");
                Integer rutDesn = rs.getInt("DESNIVELL");
                Integer rutAlcMax = rs.getInt("ALC_MAX");
                Integer rutAlcMin = rs.getInt("ALC_MIN");
                Float rutDist = rs.getFloat("DISTANCIA");
                Long rutTemps = rs.getLong("TEMPS");
                Boolean rutCirc = rs.getBoolean("CIRCULAR");
                Integer rutDif = rs.getInt("DIFICULTAT");
                String rutGpx = rs.getString("GPXFILE");
                if(rs.wasNull()){
                    rutGpx = null;
                }
                String fotTit = rs.getString("FOT_TITOL");
                String fotUrl = rs.getString("FOT_URL");
                InfoRuta ir = new InfoRuta(rutId,rutTit,catId,catNom,rutDesc,rutDesn,rutAlcMax,rutAlcMin,rutDist,rutTemps,rutCirc,rutDif,rutGpx,fotTit,fotUrl);
                rutes.add(ir);
            }
        }catch(SQLException ex){
            throw new RutAppServerException("Problemes al fer la consulta de Rutes");
        }
        return rutes;
    }
    
    public List<InfoPunt> getPunts(int rut_id){
        List<InfoPunt> punts = new ArrayList<InfoPunt>();
        String consulta = "select \n" +
            "r.rut_id as RUT_ID,\n" +
            "p.pun_numero as NUMERO,\n" +
            "p.pun_nom as NOM,\n" +
            "p.pun_descripcio as DESCRIPCIO,\n" +
            "p.pun_hora as HORA,\n" +
            "p.pun_latitud as LATITUD,\n" +
            "p.pun_longitud as LONGITUD,\n" +
            "p.pun_elevacio as ELEVACIO,\n" +
            "f.fot_titol as FOT_TITOL,\n" +
            "f.fot_url as FOT_URL\n" +
            "from punt p join ruta r on p.pun_id = r.rut_id\n" +
            "join foto f on f.fot_id = p.pun_foto\n" +
            "where r.rut_id = "+rut_id+"\n" +
            "order by NUMERO;";
        Statement st;
        try{
            st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while(rs.next()){
                Integer rutId = rs.getInt("RUT_ID");
                Integer punNum = rs.getInt("NUMERO");
                String punNom = rs.getString("NOM");
                String punDesc = rs.getString("DESCRIPCIO");
                Long punHora = rs.getLong("HORA");
                if(rs.wasNull()){
                    punHora = null;
                }
                Double punLat = rs.getDouble("LATITUD");
                if(rs.wasNull()){
                    punLat = null;
                }
                Double punLon = rs.getDouble("LONGITUD");
                if(rs.wasNull()){
                    punLon = null;
                }
                Integer punElev = rs.getInt("ELEVACIO");
                if(rs.wasNull()){
                    punElev = null;
                }
                String fotTit = rs.getString("FOT_TITOL");
                String fotUrl = rs.getString("FOT_URL");
                InfoPunt ip = new InfoPunt(rutId,punNum,punNom,punDesc,punHora,punLat,punLon,punElev,fotTit,fotUrl);
                punts.add(ip);
            }
        }catch(SQLException ex){
            throw new RutAppServerException("Problemes al fer la consulta de Punts");
        }
        return punts;
    }
     
}
