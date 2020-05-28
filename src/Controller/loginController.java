/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import DAO.AmilDAO;
import Model.AmilModel;
import View.FormLogin;
import View.ListZakat;
import View.Welcome;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import Interface.AmilInterface;

/**
 *
 * @author mz-hafizha
 */
public class loginController extends BaseController{

    
    Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
    private final FormLogin FormLogin2;
    private List<AmilModel> listLogin;
    private final AmilInterface AmilImplement2; //kenapa final

    public loginController(FormLogin FormLogin2) {
        this.FormLogin2 = FormLogin2;
        AmilImplement2 = new AmilDAO();
        lokasiform();
    }

    
    public void lokasiform() {
        int x = layar.width / 2 - FormLogin2.getSize().width / 2;
        int y = layar.height / 2 - FormLogin2.getSize().height / 2;
        FormLogin2.setLocation(x, y);
    }
    
    public void welcome(){
        
        FormLogin2.setVisible(false);
        new Welcome().setVisible(true);
    
    }

    
    public void prosesLogin() {

        String id_amil = FormLogin2.getUserText().getText();
        String password = FormLogin2.getPassText().getText();

        AmilModel account = new AmilModel();
        account.setUsername(id_amil);
        account.setPassword(password);

        if (AmilImplement2.checkLogin(account)) {
            messageSuccess("Berhasil Login");
            FormLogin2.setVisible(false);
            new ListZakat().setVisible(true);
        } else {
            messageFailed("Username atau password anda salah !!");
        }

    }
}
