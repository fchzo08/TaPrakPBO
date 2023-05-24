/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiketParkir.controller;

import TiketParkir.helper.ConnectionDB;
import TiketParkir.helper.KaryawanHelper;
import TiketParkir.model.Karyawan;
import TiketParkir.views.EditKaryawan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author fachr
 */
public class EditKaryawanController implements ActionListener{
    
    private Karyawan karyawan;
    private EditKaryawan view;
    private JDialog dialog;
    public EditKaryawanController(Karyawan k){
        this.karyawan=k;
        view = new EditKaryawan();
        view.getBtnEdit().addActionListener(this);
        view.getBtnHapus().addActionListener(this);
        
        view.setTf_edit_kar(this.karyawan.getNama());
        view.setTf_edit_kar1(this.karyawan.getUsername());
        dialog = new JDialog();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.add(view.getContentPane());
        dialog.pack();
        dialog.setModal(true);
        dialog.setVisible(true);
        dialog.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==view.getBtnEdit()){
            KaryawanHelper kh = new KaryawanHelper(new ConnectionDB());
            karyawan.setNama(view.getTfEditKar().getText());
            karyawan.setUsername(view.getTfEditKar1().getText());
            if(kh.editKaryawan(karyawan)>0){
                Logger.getLogger(Karyawan.class.getName()).log(Level.INFO, "Update Karyawan Berhasil");
                dialog.dispose();
            }
            else{
                JOptionPane.showMessageDialog(view, "Edit Gagal");
            }
        }
        if(e.getSource()==view.getBtnHapus()){
            KaryawanHelper kh = new KaryawanHelper(new ConnectionDB());
            karyawan.setNama(view.getTfEditKar().getText());
            karyawan.setUsername(view.getTfEditKar1().getText());
            if(kh.hapusKaryawan(karyawan)>=0){
                Logger.getLogger(Karyawan.class.getName()).log(Level.INFO, "Hapus Karyawan Berhasil");
                dialog.dispose();
            }
            else{
                JOptionPane.showMessageDialog(view, "Hapus Gagal");
            }
        }
    }
    
}
