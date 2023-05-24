/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiketParkir.controller;

import TiketParkir.model.Karyawan;
import TiketParkir.model.Tiket;
import TiketParkir.views.DaftarKaryawan; 
import TiketParkir.views.EditKaryawan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fachr
 */
public class DaftarKaryawanController implements ActionListener{
    private Karyawan karyawan;
    private DaftarKaryawan dkView;
    private static final Logger LOG = Logger.getLogger(UtamaController.class.getName());
    UtamaController p;
    public DaftarKaryawanController(UtamaController parent) {
        this.p=parent;
        karyawan = new Karyawan();
        this.dkView = new DaftarKaryawan();
        this.dkView.getBtnEdit().addActionListener(this);
        this.dkView.getBtnBack().addActionListener(this);
        
        this.dkView.setVisible(true);
        loadAllDK();
        
    }    
    public void showFrame(){
        dkView.setVisible(true);
    }
    
    public void loadAllDK(){
        List<Karyawan> karys = karyawan.getAllTiket();
        DefaultTableModel dtm = new DefaultTableModel();
         dtm.addColumn("ID");
        dtm.addColumn("Nama");
        dtm.addColumn("Username");
        for(Karyawan k:karys){
            Object[] row = {k.getId(),k.getNama(),k.getUsername()};
            dtm.addRow(row);
        }
        dkView.setTableModel(dtm);
        LOG.info("Successfully load data to table model");
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==dkView.getBtnEdit()){
            System.out.println(dkView.getTable().getSelectedRow());
            if(dkView.getTable().getSelectedRow()!=-1){
                Karyawan karyawan = new Karyawan();
                karyawan.closeConnection();
                karyawan.setNama(dkView.getTable().getValueAt(dkView.getTable().getSelectedRow(), 1).toString());
                karyawan.setUsername(dkView.getTable().getValueAt(dkView.getTable().getSelectedRow(), 2).toString());
                karyawan.setId(Integer.parseInt(dkView.getTable().getValueAt(dkView.getTable().getSelectedRow(), 0).toString()));
                EditKaryawanController ekController = new EditKaryawanController(karyawan);
                loadAllDK();
            }
        }
        if(e.getSource()==dkView.getBtnBack()){
            p.showFrame();
            dkView.dispose();
        }
    }
}
