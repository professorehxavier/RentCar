/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rentcarw;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import br.com.senac.rentcar.view.FormLogin;
import br.com.senac.rentcar.view.FormPrincipal;

/**
 *
 * @author sala305b
 */
public class RentCar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
        */
        FormLogin form = new FormLogin();
        form.setVisible(true);
    }
    
}
