/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiketParkir.helper;

import TiketParkir.model.Tiket;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

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
    public void inputDB(LocalDateTime waktu, String ken,double tar,int id) {
        try {
            DateTimeFormatter dtmFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            int gantiId = 9000000+id;
            String query = "UPDATE `tiket` SET `id_tiket`='"+gantiId+"',`waktu_keluar`='"+waktu.format(dtmFormatter)+"',`kendaraan`='"+ken+"',`tarif`='"+tar+"' WHERE id_tiket = "+id+"";
            con.statement.executeUpdate(query);
            LOG.info("Query TIket DB DIjalankan");
        } catch (Exception e) {
            LOG.info("Query TIket DB Tidak berhasil");
        }
    }
    public int getTotalTiket(){
        ResultSet rs;
        try {
            String query = "SELECT COUNT(id_tiket) as 'ID' FROM TIKET";
            rs = con.statement.executeQuery(query);
            if(rs.next()){
                return rs.getInt("ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtamaHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public static void printNota(int id, String masuk, LocalDateTime keluar, String jns, String ptgs,double tarif) {
        String filePath = "D:\\Project Java LAT\\TaPBO\\notakeluar\\nota"+id+".txt";
        try(PrintWriter writer = new PrintWriter(filePath)){
            writer.println("=========== Nota Karcis ============");
            writer.println("");
            writer.println(" NO    : "+id);
            writer.println(" Masuk : "+masuk);
            writer.println(" Keluar: "+keluar.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            writer.println(" Jenis : "+jns);
            writer.println(" Ptgs  : "+ptgs);
            writer.println(" Tarif : "+tarif);
            writer.println("====================================");
            writer.println("");
            writer.println(" *TERIMA KASIH ATAS KUNJUNGAN ANDA* ");
            writer.println("");
            writer.println("====================================");
            LOG.info("Nota berhasil diCetak");
        } catch (FileNotFoundException e) {
        }
    }
}
