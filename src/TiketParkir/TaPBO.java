/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TiketParkir;

import TiketParkir.helper.ConnectionDB;
import TiketParkir.views.InputKarcis;
import TiketParkir.views.Login;
import TiketParkir.views.InputKaryawan;
import java.sql.SQLException;

/**
 *
 * @author fachr
 */
public class TaPBO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        Login a = new Login();
        a.setVisible(true);
    }
    
}
