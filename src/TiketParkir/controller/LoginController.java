/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiketParkir.controller;

import TiketParkir.model.Karyawan;
import TiketParkir.views.InputKarcis;
import TiketParkir.views.Login;
import TiketParkir.views.Utama;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

/**
 *
 * @author fachr
 */
public class LoginController implements ActionListener{

    Login view;
    Karyawan  karyawan;
    
    private static final Logger LOG = Logger.getLogger(LoginController.class.getName());
    
    public LoginController(Login view){
        this.view=view;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==view.getjButton2()){
            view.setVisible(false);
            InputKarcis i = new InputKarcis();
            i.setVisible(true);
            LOG.info("Berpindah Halaman ke halaman Input Karcis Parkir");
            return;
        }
        karyawan = new Karyawan(view.getTextField1(),view.getPasswordField1());
        if(karyawan.getKaryawanByUsername()){
            LOG.info("Login Berhasil");
            view.setVisible(false);
            Utama mainForm = new Utama();
            mainForm.setVisible(true);
            LOG.info("Berpindah Halaman ke halaman utama");
        }else{
            view.showMessage("Login Gagal Username/Password Salah");
            LOG.info("Login Gagal");
        }
    }
    
    private Karyawan _getKaryawan(){
        
        return null;
    }
}
