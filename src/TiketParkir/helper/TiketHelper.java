/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiketParkir.helper;
import TiketParkir.controller.LoginController;
import TiketParkir.model.Tiket;
import java.sql.*;
import java.time.format.DateTimeFormatter;
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
    public void closeConnection() throws SQLException{
        con.conn.close();
    }
    }

