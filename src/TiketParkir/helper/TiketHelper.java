/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiketParkir.helper;
import TiketParkir.controller.LoginController;
import TiketParkir.model.Tiket;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
/**
 *
 * @author fachr
 */
public class TiketHelper {
    ConnectionDB con;
    public TiketHelper(ConnectionDB db){
        this.con = db;
    }
    private static final Logger LOG = Logger.getLogger(TiketHelper.class.getName());
    
    public int getIdCount(){
        String query = "SELECT COUNT(*) as \"tiket\" FROM TIKET";
        try{
            //System.out.println("username = "+username+password);
            ResultSet rs = this.con.statement.executeQuery(query);
            if(rs.next()){
                return rs.getInt("tiket");
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return -1;
    }
    public void inputTiket(Tiket t){
        try{
            DateTimeFormatter dtmFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String query = "INSERT INTO TIKET(id_tiket, waktu_masuk) VALUES("+t.getId()+",\""+t.getWaktuMasuk().format(dtmFormatter)+"\")";
            con.statement.executeUpdate(query);
            LOG.info("Query TIket DIjalankan");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public List<Tiket> getAllTiket(){
        String query = "SELECT * FROM TIKET";
        List<Tiket> tikets = new ArrayList<>();
        try{
            ResultSet rs = this.con.statement.executeQuery(query);
            while(rs.next()){
                Tiket t = new Tiket();
                t.setId(rs.getInt("id_tiket"));
                t.setWaktu_masuk(LocalDateTime.parse(rs.getString("waktu_masuk"),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                t.setWaktu_keluar(LocalDateTime.parse(rs.getString("waktu_keluar"),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                t.setKendaraan(rs.getString("kendaraan"));
                t.setTarif(rs.getDouble("tarif"));
                tikets.add(t);
                LOG.info("Getting LIst TIket on TiketHelper");
            }
        }
        catch(SQLException ex){
            LOG.severe(ex.getMessage());
        }
        return tikets;
    }
    
    public String getTiketWaktuMasukById(int Id){
        String query="SELECT * FROM TIKET WHERE id_tiket = \""+Id+"\"";
        try{
            ResultSet rs = con.statement.executeQuery(query);
            if(rs.next()){
                return rs.getString("waktu_masuk");
            }
        }
        catch(SQLException ex){
            LOG.severe(ex.getMessage());
        }
        return null;
    }
    public static void printTiket(Tiket tik) {
//        String[] ToPrint = {
//            "========== Nomor Karcis ==========",
//            "",
//            "date : "+tik.getWaktuMasuk(),
//            "          NO : "+tik.getId(),
//            "",
//            "=================================="
//        };
//        PrintService[] ps = PrintServiceLookup.lookupPrintServices(null, null);
//        for (int i = 0; i < ps.length; i++) {
//            PrintService printer = ps[i];
//            System.out.println("Printer #" + (i + 1) + ": " + printer.getName());}
//Printer #1: Send To OneNote 2016
//Printer #2: OneNote for Windows 10
//Printer #3: Microsoft XPS Document Writer
//Printer #4: Microsoft Print to PDF
//Printer #5: Fax
//Printer #6: Canon G2010 series
//Printer #7: Adobe PDF
//        if(ps.length>0){
//            PrintService printer = ps[0];
//            DocPrintJob pj = printer.createPrintJob();
//            StringBuilder sb = new StringBuilder();
//            for (String line : ToPrint){
//                sb.append(line).append("\n");
//            }
//            String textToPoint = sb.toString();
//            System.out.println(textToPoint);
//            DocFlavor f = DocFlavor.BYTE_ARRAY.AUTOSENSE;
//            Doc doc =  new SimpleDoc(textToPoint.getBytes(), f, null);
//            System.out.println(doc);
//            PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
//            try {
//                pj.print(doc, null);
//                LOG.info("Tiket berhasil diCetak");
//            } catch (PrintException e) {
//                LOG.info("Terjadi Kesalahan Saat Mencetak");
//            }
//        }else{
//            LOG.info("Tidak ada printer yang tersedia");
//        }
        String filePath = "D:\\Project Java LAT\\TaPBO\\karcis\\karcis"+tik.getId()+".txt";
        try(PrintWriter writer = new PrintWriter(filePath)){
            writer.println("========== Nomor Karcis ==========");
            writer.println("");
            writer.println("date : "+tik.getWaktuMasuk().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            writer.println("");
            writer.println("          NO : "+tik.getId());
            writer.println("");
            writer.println("");
            writer.println("==================================");
            LOG.info("Tiket berhasil diCetak");
        } catch (FileNotFoundException e) {
        }
    }
    public void closeConnection() throws SQLException{
        con.conn.close();
    }
    }

