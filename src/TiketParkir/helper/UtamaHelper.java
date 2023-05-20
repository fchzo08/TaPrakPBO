/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiketParkir.helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

/**
 *
 * @author fachr
 */
public class UtamaHelper {
    
    ConnectionDB con;
    private static final Logger LOG = Logger.getLogger(UtamaHelper.class.getName());
    public UtamaHelper(ConnectionDB db){
        this.con=db;
    }
    ///!!! sepertinya salah
    public void inputDB(LocalDateTime waktu, String ken,double tar,int id) {
        try {
            DateTimeFormatter dtmFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String query = "UPDATE TIKET SET waktu_keluar ="+waktu.format(dtmFormatter)+",kendaraan="+ken+",tarif= "+tar+" WHERE id_tiket == "+id+"";
            //String quer = "INSERT INTO TIKET(id_tiket, waktu_masuk) VALUES("+t.getId()+",\""+t.getWaktuMasuk().format(dtmFormatter)+"\")";
            con.statement.executeUpdate(query);
            LOG.info("Query TIket DB DIjalankan");
        } catch (Exception e) {
        }
    }
    
    
}
