/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiketParkir.helper;
import TiketParkir.controller.LoginController;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author fachr
 */
public class ConnectionDB {
    String dbUrl = "jdbc:mysql://localhost/parkir";
    String username = "root";
    String password = "";
    public Connection conn;
    Statement statement;
    
    private static final Logger LOG = Logger.getLogger(ConnectionDB.class.getName());
    public ConnectionDB(){
        try{
            conn = DriverManager.getConnection(dbUrl, username, password);
            createStatement();
            LOG.info("Koneksi DB Dibuat");
        }
        catch(SQLException exception){
            System.out.println(exception.getMessage());
        }
    }
    
    public void createStatement(){
        try {
            this.statement = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
