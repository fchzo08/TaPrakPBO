/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiketParkir.controller;

import TiketParkir.helper.ConnectionDB;
import TiketParkir.helper.KaryawanHelper;
import TiketParkir.views.InputKaryawan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author fachr
 */
public class inputKaryawanController implements ActionListener{
    InputKaryawan view;
    KaryawanHelper kh;
    UtamaController previous;
    
    public inputKaryawanController(UtamaController prev) {
        this.view = new InputKaryawan();
        previous = prev;
        view.getJButton1().addActionListener(this);
    }
    public void showFrame(){
        view.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        kh = new KaryawanHelper(new ConnectionDB());
        kh.inputKaryawan(view.getInNama(), view.getInUsername(), view.getInPassword());
        view.setVisible(false);
        previous.showFrame();
    }
    }
