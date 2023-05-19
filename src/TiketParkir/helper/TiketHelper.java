/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiketParkir.helper;
import TiketParkir.controller.LoginController;
import TiketParkir.model.Tiket;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
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
    
    public void closeConnection() throws SQLException{
        con.conn.close();
    }
    }

