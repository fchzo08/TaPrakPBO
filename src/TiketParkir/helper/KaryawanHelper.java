/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiketParkir.helper;
import TiketParkir.controller.LoginController;
import TiketParkir.model.Karyawan;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
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
    
    private String hashPassword(String password){
        try {
            MessageDigest digest= MessageDigest.getInstance("SHA-256");
            byte[] encodedPwd= digest.digest(password.getBytes());
            
            //karakter ke hexa
            StringBuilder hashedPassword=new StringBuilder();
            for(byte b: encodedPwd){
                String hexString = Integer.toHexString(0xff & b);
                if(hexString.length()==1){
                    hashedPassword.append('0');
                }
                hashedPassword.append(hexString);
            }
            return hashedPassword.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Karyawan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void inputKaryawan(String nama, String user, String pass){
        pass=hashPassword(pass);
        try {
            String query = "INSERT INTO `karyawan`(`nama`, `username`, `passwword`) VALUES ('"+nama+"','"+user+"','"+pass+"')";
            con.statement.executeUpdate(query); 
            LOG.info("Input Karyawan berhasil");
        } catch (SQLException ex){
            LOG.severe(ex.getMessage());
        }
    }   
    
    public ResultSet getKaryawanByUsername(String username,String password){
        password=hashPassword(password);
        
        String query = "SELECT * FROM KARYAWAN WHERE USERNAME = \""+username+"\""+"AND PASSWWORD = \""+password+"\"";
        try{
        
            ResultSet rs = this.con.statement.executeQuery(query);
            if(rs.next()){
                LOG.info(rs.getString("nama"));
                return rs;
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
    
    public List<Karyawan> getAllTiket(){
        String query = "SELECT * FROM karyawan";
        List<Karyawan> karys = new ArrayList<>();
        try{
            ResultSet rs = this.con.statement.executeQuery(query);
            while(rs.next()){
                Karyawan k = new Karyawan();
                k.setId(rs.getInt("id_karyawan"));
                k.setNama(rs.getString("nama"));
                k.setUsername(rs.getString("username"));
                karys.add(k);
                LOG.info("Getting LIst TIket on TiketHelper");
            }
        }
        catch(SQLException ex){
            LOG.severe(ex.getMessage());
        }
        return karys;
    }

    public int editKaryawan(Karyawan karyawan) {
        try {
            String query = String.format("UPDATE KARYAWAN SET NAMA='%s', USERNAME = '%s' WHERE id_karyawan = %d", 
                    karyawan.getNama(),karyawan.getUsername(),karyawan.getId());
            return con.statement.executeUpdate(query);
        } catch (SQLException ex){
            LOG.severe(ex.getMessage());
        }
        return -1;
    }
    
    public int hapusKaryawan(Karyawan karyawan){
        try {
            String query = String.format("DELETE FROM KARYAWAN WHERE id_karyawan = %d", 
                    karyawan.getId());
            
            return con.statement.executeUpdate(query);
        } catch (SQLException ex){
            LOG.severe(ex.getMessage());
        }
        return -1;
    }
    
    public int isFirst(){
        try {
            String query = String.format("SELECT COUNT(*) as \"data\" FROM KARYAWAN");
            ResultSet rs = this.con.statement.executeQuery(query);
            if(rs.next())
            {
                return rs.getInt("data");
            }
        }
            catch (SQLException ex) {
                LOG.severe(ex.getMessage());
        }
        return -1;
    }
    
}
