/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.FormLogin;
import View.FormMustahiq;
import View.Welcome;
//import View.FormTransaksi;
import View.ListMustahiq;
/**
 *
 * @author mz-hafizha
 */
public class WelcomeController extends BaseController{
    private Welcome Welcome2;

    public WelcomeController(Welcome viewWelcome) {
        this.Welcome2 = viewWelcome;
    }
    
    public void amil() {
        Welcome2.setVisible(false);
        new FormLogin().setVisible(true);
    }

    public void mustahiqBaru() {
        Welcome2.setVisible(false);
        new FormMustahiq().setVisible(true);
    }
    
}
