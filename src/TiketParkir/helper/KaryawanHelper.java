/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiketParkir.helper;
import TiketParkir.controller.LoginController;
import java.sql.*;
import java.util.logging.Logger;
/**
 *
 * @author fachr
 */
public class KaryawanHelper {
    ConnectionDB con;
    private static final Logger LOG = Logger.getLogger(LoginController.class.getName());
    public KaryawanHelper(ConnectionDB db){
        this.con=db;
    }
    
    public ResultSet getKaryawanByUsername(String username,String password){
        
        String query = "SELECT * FROM KARYAWAN WHERE USERNAME = \""+username+"\""+"AND PASSWWORD = \""+password+"\"";
        try{
        
            ResultSet rs = this.con.statement.executeQuery(query);
            if(rs.next()){
                LOG.info(rs.getString("nama"));
                return rs;
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    public void closeConnection() throws SQLException{
        con.conn.close();
    }
}
