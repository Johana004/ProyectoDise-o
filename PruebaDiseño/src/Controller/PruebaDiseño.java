
package Controller;

import Model.DBConnection;
import View.Login;
import View.Admin;
import View.Registration;


public class PruebaDiseño {

    public static void main(String[] args) {
        Login lg = new Login();
        lg.setVisible(true);
        
        Registration rg= new Registration();
        rg.setVisible(true);
        
        Admin ad= new Admin();
        ad.setVisible(true);
        
    }
}
