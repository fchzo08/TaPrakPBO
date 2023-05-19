/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiketParkir.controller;

import TiketParkir.helper.ConnectionDB;
import TiketParkir.helper.TiketHelper;
import TiketParkir.model.Tiket;
import TiketParkir.views.InputKarcis;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.logging.Logger;

/**
 *
 * @author fachr
 */
public class InputKarcisController implements ActionListener{
    private int idTotal;
    InputKarcis ik;
    TiketHelper th;
    
    private static final Logger LOG = Logger.getLogger(InputKarcisController.class.getName());

    public InputKarcisController(InputKarcis view) {
        this.ik = view;
        th = new TiketHelper(new ConnectionDB());
        getIdCount();
    }
    
    public void getIdCount(){
        idTotal = th.getIdCount()+1;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Tiket tiket = new Tiket(idTotal, LocalDateTime.now());
        th.inputTiket(tiket);
        LOG.info("Tiket Ditambahkan ke Database");
        idTotal++;
    }
    
}
