/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiketParkir.model;

import TiketParkir.helper.ConnectionDB;
import TiketParkir.helper.KaryawanHelper;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fachr
 */
public class Karyawan {
    private String _username;
    private String _password;
    private int Id;
    private String Nama;
    KaryawanHelper kh;
    public Karyawan(String uname, String pwd){
        this._username = uname;
        this._password=pwd;
    }

    public Karyawan() {
        kh = new KaryawanHelper(new ConnectionDB());
    }
    
    public void closeConnection(){
        try {
            kh.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Karyawan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setUsername(String _username) {
        this._username = _username;
    }
    
    public void setNama(String nama){
        this.Nama=nama;
    }
    
    public String getNama(){
        return this.Nama;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    public String getUsername() {
        return _username;
    }

    public String getPassword() {
        return _password;
    }

    public int getId() {
        return Id;
    }
    
        public List<Karyawan> getAllTiket(){
        List<Karyawan> karys = kh.getAllTiket();
        return karys;
    }
    
    public boolean getKaryawanByUsername(){
        KaryawanHelper kh = new KaryawanHelper(new ConnectionDB());
        try{
            ResultSet rs = kh.getKaryawanByUsername(_username,_password);
            if(rs!=null){
                _username = rs.getString("username");
                _password = rs.getString("passwword");
                
                this.Id = rs.getInt("id_karyawan");
                this.Nama = rs.getString("Nama");
                return true;
            }
            else{
                //Login gagal;
                return false;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Karyawan.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        return false;
    }
    
}
