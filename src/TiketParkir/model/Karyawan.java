/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiketParkir.model;

import TiketParkir.helper.ConnectionDB;
import TiketParkir.helper.KaryawanHelper;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author fachr
 */
public class Karyawan {
    private String _username;
    private String _password;
    private int Id;
    private String Nama;
    public Karyawan(String uname, String pwd){
        this._username = uname;
        this._password=pwd;
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

    public String getNama() {
        return Nama;
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
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
}
