
package Controller;

import Model.DBConnection;
import View.Login;


public class PruebaDiseño {

    public static void main(String[] args) {
        Login lg = new Login();
        lg.setVisible(true);
        lg.setLocationRelativeTo(null);
      
      
     DBConnection db = new DBConnection();
        db.getConnection();
        db.disconnect();
    
    }
    
}
