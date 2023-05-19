/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiketParkir.model;

import TiketParkir.helper.ConnectionDB;
import TiketParkir.helper.TiketHelper;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author fachr
 */
public class Tiket {
    int Id;
    LocalDateTime waktu_masuk,waktu_keluar;
    String Kendaraan;
    public Tiket(int id, LocalDateTime waktu_Masuk){
        this.Id=id;
        this.waktu_masuk=waktu_Masuk;
        
    }
    public void inputTiket(){
        TiketHelper th = new TiketHelper(new ConnectionDB());
        th.inputTiket(this);
    }
    public LocalDateTime getWaktuMasuk(){
        return this.waktu_masuk;
    }
    public int getId(){
        return this.Id;
    }
}
