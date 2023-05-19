/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiketParkir.helper;

import java.util.logging.Logger;

/**
 *
 * @author fachr
 */
public class UtamaHelper {
    
    ConnectionDB con;
    private static final Logger LOG = Logger.getLogger(UtamaHelper.class.getName());
    public UtamaHelper(ConnectionDB db){
        this.con=db;
    }
    
    
}
