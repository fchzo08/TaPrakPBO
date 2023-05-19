/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiketParkir.model;

import TiketParkir.helper.ConnectionDB;
import TiketParkir.helper.TiketHelper;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author fachr
 */
public class Tiket {
    int Id;
    LocalDateTime waktu_masuk,waktu_keluar;
    String Kendaraan;
    Double tarif;
    TiketHelper th;
    public Tiket(int id, LocalDateTime waktu_Masuk){
        this.Id=id;
        th = new TiketHelper(new ConnectionDB());
        this.waktu_masuk=waktu_Masuk;  
    }
    public Tiket(){
        th = new TiketHelper(new ConnectionDB());
    }
    public void setTarif(Double t){
        this.tarif=t;
    }
    public Double getTarif(){
        return this.tarif;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setWaktu_masuk(LocalDateTime waktu_masuk) {
        this.waktu_masuk = waktu_masuk;
    }

    public void setWaktu_keluar(LocalDateTime waktu_keluar) {
        this.waktu_keluar = waktu_keluar;
    }

    public void setKendaraan(String Kendaraan) {
        this.Kendaraan = Kendaraan;
    }
    public void inputTiket(){
        if(this.waktu_masuk!=null){
            th.inputTiket(this);
            
        }
    }
    public LocalDateTime getWaktuMasuk(){
        return this.waktu_masuk;
    }
    public LocalDateTime getWaktuKeluar(){
        return this.waktu_keluar;
    }
    public int getId(){
        return this.Id;
    }
    
    public List<Tiket> getAllTiket(){
        List<Tiket> tikets = th.getAllTiket();
        return tikets;
    }
}
