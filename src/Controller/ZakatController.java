/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MustahiqDAO;
import DAO.ZakatDAO;
import View.FormZakat;
import View.ListZakat;
import View.Welcome;
import java.awt.Dimension;
import java.awt.Toolkit;
import Interface.MustahiqInterface;
import Interface.ZakatInterface;
import Model.JenisZakatModel;
import Model.Session;
import Model.ZakatModel;
import static java.lang.String.format;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mz-hafizha
 */
public class ZakatController extends BaseController {

    Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
//    private final FormTransaksi FormTransaksi2;
    private ListZakat ListZakat2;
    private FormZakat FormZakat2;
    private ZakatInterface ZakatInterface2;
    List<ZakatModel> lzm;
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/d/yyyy");

    public ZakatController(FormZakat ListTransaksi2) {
        this.FormZakat2 = ListTransaksi2;
        this.ZakatInterface2 = new ZakatDAO();
        lzm = ZakatInterface2.getAll();

    }

    public void lokasiform() {
        int x = layar.width / 2 - ListZakat2.getSize().width / 2;
        int y = layar.height / 2 - ListZakat2.getSize().height / 2;
        ListZakat2.setLocation(x, y);
    }

    public void addtransaksi() {
        ListZakat2.setVisible(false);
        FormZakat2.setVisible(true);
    }

    public void welcome() {

        ListZakat2.setVisible(false);
        new Welcome().setVisible(true);

    }

    public void add() {
        ZakatModel ZakatModel2 = new ZakatModel();

        if (FormZakat2.getNikText().getText().trim().equals("")) {
            messageFailed("Silahkan Isi NIK terlebih dahulu.");
            FormZakat2.getNikText().requestFocus();
        } else {
            try {
                ZakatModel2.setNik(FormZakat2.getNikText().getText());
                ZakatModel2.setTanggungan(Integer.parseInt(FormZakat2.getTanggunganText().getText()));
                ZakatModel2.setJenis_zakat(FormZakat2.getZakatCombo().getSelectedItem().toString());
                ZakatModel2.setTotal(Double.parseDouble(FormZakat2.getTotalText().getText()));
//                ZakatModel2.setTanggal((dateFormat.format(FormZakat2.getTanggalCal().getDate())));
            
                ZakatInterface2.add(ZakatModel2);
                
                messageSuccess("Pendaftaran Berhasil!!!");
                
                FormZakat2.setVisible(false);
                new ListZakat().setVisible(true);
            
            } catch (Exception e) {
                letakError("add() ZakatController "+e);
            }
        }
    }

    public void getTanggungan() {
        String NIK = FormZakat2.getNikText().getText();

        String tanggungan = ZakatInterface2.getTanggungan(NIK);
        FormZakat2.getTanggunganText().setText(tanggungan);
    }

    public void getBesaran() {
//        System.out.println();
        String jenis_zakat = FormZakat2.getZakatCombo().getSelectedItem().toString();

        String besaran = ZakatInterface2.getBesaran(jenis_zakat);
        FormZakat2.getBesaranText().setText(besaran);
    }

    public void getTotal() {
//        String total = "";

        double tanggungan = Double.valueOf(FormZakat2.getTanggunganText().getText());
        double besaran = Double.valueOf(FormZakat2.getBesaranText().getText());

        double total = (tanggungan+1) * besaran;

        FormZakat2.getTotalText().setText(String.valueOf(total));
    }
    
}
