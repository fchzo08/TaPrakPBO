/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiketParkir.controller;

import TiketParkir.helper.ConnectionDB;
import TiketParkir.helper.TiketHelper;
import TiketParkir.helper.UtamaHelper;
import TiketParkir.model.Karyawan;
import TiketParkir.model.Tiket;
import TiketParkir.views.InputKaryawan;
import TiketParkir.views.Login;
import TiketParkir.views.Utama;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author fachr
 */
public class UtamaController implements ActionListener, ItemListener {
    Utama view;
    Map<String,Double> listHargaKendaraan = new HashMap<>();
    
    //Buat instance untuk parsing dan navigasi
    private static UtamaController instance;
    private Karyawan karyawan;
    private Utama utamaView;
    private Tiket tiket;
    private static final Logger LOG = Logger.getLogger(UtamaController.class.getName());
    UtamaHelper uh;
    TiketHelper th;
    double totalTarif;
    String waktuMasuk;
    public UtamaController(){
        utamaView = new Utama();
        tiket = new Tiket();
        th = new TiketHelper(new ConnectionDB());
        uh = new UtamaHelper(new ConnectionDB());
        listHargaKendaraan.put("Motor",2000d);
        listHargaKendaraan.put("Mobil",5000d);
        listHargaKendaraan.put("Sepeda",1000d);
        utamaView.getJb_cari().addActionListener(this);
        for(String key : listHargaKendaraan.keySet()){
            utamaView.getCb_jenisKendaraan().addItem(key);
        }
        loadAllTiket();
        utamaView.getCb_jenisKendaraan().addItemListener(this);
        utamaView.getCb_jenisKendaraan().setSelectedItem(null);
        utamaView.getJb_bayar().addActionListener(this);
        utamaView.getBtnKaryawan().addActionListener(this);
        jam();
        updateTiket();
        
    }
    
    
    public void updateTiket(){
        Timer timer = new Timer(10000,updateTikets());
        timer.start();
    }
    
    public void loadAllTiket(){
        List<Tiket> tikets = tiket.getAllTiket();
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("waktu masuk");
        dtm.addColumn("waktu keluar");
        dtm.addColumn("Kendaraan");
        dtm.addColumn("Tarif");
        for(Tiket t:tikets){
            Object[] row = {t.getId(),t.getWaktuMasuk().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                t.getWaktuKeluar().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),t.getKendaraan(),
                t.getTarif()
            };
            dtm.addRow(row);
        }
        utamaView.getBtnDafKar().addActionListener(this);
        utamaView.setTableModel(dtm);
        LOG.info("Successfully load data to table model");
    }
    
    public static UtamaController getInstance(){
        if(instance==null){
            instance = new UtamaController();
        }
        return instance;
    }
    
    public void setLoggedKaryawan(Karyawan k){
        this.karyawan=k;
        if("ADMIN".equals(k.getUsername().toUpperCase())){
            utamaView.setVisibleBtnKaryawan(true);
            return;
        }
        utamaView.setVisibleBtnKaryawan(false);
    }
    
    public void showPage(){
        utamaView.setVisible(true);
        utamaView.setlbl_karyawanName("Nama Karyawan : "+karyawan.getNama());
    }
    
    public void jam() {
        // Membuat objek DateTimeFormatter dengan format waktu yang diinginkan
        
        Timer timer = new Timer(1000,ubahWaktuView());
        timer.start();
//        while (true) {
//            // Membuat objek LocalTime dengan waktu saat ini
//
//            // Menggunakan objek DateTimeFormatter untuk memformat waktu
//
//            // Menampilkan waktu
//            utamaView.waktuRT(formattedTime);
//
//            try {
//                // Menunda eksekusi selama 1 detik
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==utamaView.getJb_cari()){
            //Ketika tombol cari di klik;
                try{
                    waktuMasuk = th.getTiketWaktuMasukById(Integer.parseInt(utamaView.getTb_kode().getText()));
                    if(waktuMasuk != null){
                        //Sukses ketemu ID
                        utamaView.getL_masuk().setText(waktuMasuk);
                        LOG.info("Id Tiket loaded");
                    }
                    else{
                        JOptionPane.showMessageDialog(utamaView, "Id Tidak Ditemukan");
                        LOG.severe("ID TIDAK DITEMUKAN");
                    }
                }
                catch(NumberFormatException ex){
                    LOG.severe("ID TIDAK ADA");
                }
        }
        if(e.getSource()==utamaView.getJb_bayar()){
            if(utamaView.getTb_masukuang().getText()!=null){
                double uangMasuk = Double.parseDouble(utamaView.getTb_masukuang().getText().toString());
                double ttl = uangMasuk-totalTarif;
                if(ttl>=0){
                utamaView.getL_kembalian().setText(String.valueOf(ttl));
                    String  jjns = (String) utamaView.getCb_jenisKendaraan().getSelectedItem();
                    int idd = Integer.parseInt(utamaView.getTb_kode().getText());
                    LocalDateTime sekarang = LocalDateTime.now();
                    uh.printNota(idd,waktuMasuk,sekarang, jjns, karyawan.getNama(), totalTarif);
                    uh.inputDB(sekarang, jjns, totalTarif, idd);
                    loadAllTiket();
                    return;
                }else{
                    utamaView.showMessage("Uang Kurang");
                }
            }
        }
        if(e.getSource()==utamaView.getBtnKaryawan()){
            LOG.info("Berpindah Ke menu Karyawan");
            inputKaryawanController ikc = new inputKaryawanController(this);
            utamaView.setVisible(false);
            ikc.showFrame();
            return;
        }
        if(e.getSource()==utamaView.getBtnDafKar()){
            LOG.info("Berpindah Ke daftar Karyawan");
            DaftarKaryawanController dkc = new DaftarKaryawanController(this);
            utamaView.setVisible(false);
            dkc.showFrame();
        }
    }
    
    public void showFrame(){
        utamaView.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(waktuMasuk!=null){
            String key = utamaView.getCb_jenisKendaraan().getSelectedItem().toString();
            Double hargaDasar = listHargaKendaraan.get(key);
            LocalDateTime sekarang = LocalDateTime.now();
            LocalDateTime waktuMasuk = LocalDateTime.parse(utamaView.getL_masuk().getText(),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Duration durasi = Duration.between(waktuMasuk, sekarang);
            double durasiInHours = durasi.toHours() > 0 ? durasi.toHours() : 1;
            totalTarif = durasiInHours * listHargaKendaraan.get(utamaView.getCb_jenisKendaraan().getSelectedItem());

            utamaView.getL_tarif().setText(totalTarif + "("+listHargaKendaraan.get(utamaView.getCb_jenisKendaraan().getSelectedItem()).toString()+"/Jam)");
        }
    }

    private ActionListener ubahWaktuView() {
        return (ActionEvent e) -> {
            try {
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                utamaView.setWaktuRT(LocalDateTime.now().format(timeFormatter));
            } catch (Exception ex) {
                LOG.severe(ex.getMessage());
            }
        };
    }

    private ActionListener updateTikets() {
        return (ActionEvent e)->{
            try{
                if(uh.getTotalTiket()!=-1){
                    loadAllTiket();
                    System.out.println("data update");
                }
            }
            catch(Exception ex){
                LOG.severe(ex.getMessage());
            }
        };
    }
}
