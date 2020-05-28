/*???????????????????????????????????????????
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.BaseController.messageFailed;
import static Controller.BaseController.messageSuccess;
import DAO.MustahiqDAO;
import Model.MustahiqModel;
import Model.AmilModel;
import View.ListMustahiq;
import DAO.AmilDAO;
import Model.Session;
import Model.TableMustahiqModel;
import View.FormMustahiq;
import View.Welcome;
import View.FormLogin;
import java.util.List;
import javax.swing.JOptionPane;
import Interface.AmilInterface;
import Interface.MustahiqInterface;
//import static Model.AmilModel.id_amil;

/**
 *
 * @author mz-hafizha
 */
public class MustahiqController extends BaseController {

    FormMustahiq FormMustahiq2;
    ListMustahiq ListMustahiq2;
    private MustahiqInterface MustahiqInterface2;
    List<MustahiqModel> lm;

    public MustahiqController(FormMustahiq FormMustahiq2) {
        this.FormMustahiq2 = FormMustahiq2;
        this.MustahiqInterface2 = new MustahiqDAO();
        lm = MustahiqInterface2.getAll();
        tampil();
    }

    public void tampil() {
//        lm = MustahiqInterface2.getMustahiq();

        FormMustahiq2.getNamaText().setText(Session.getNama());
        FormMustahiq2.getNikText().setText(Session.getNik());
        FormMustahiq2.getNo_hpText().setText(Session.getNo_hp());
        FormMustahiq2.getTanggunganText().setText(String.valueOf(Session.getTanggungan()));
        FormMustahiq2.getRwText().setText(String.valueOf(Session.getRW()));

    }

//    public MustahiqController(ListMustahiq ListMustahiq2) {
//        this.ListMustahiq2 = ListMustahiq2;
//        this.MustahiqInterface2 = new MustahiqDAO();
//    }
    
    public void add() {

        MustahiqModel MustahiqModel2 = new MustahiqModel();

        if (FormMustahiq2.getNamaText().getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Silahkan isi nama terlebih dahulu.");
            FormMustahiq2.getNamaText().requestFocus();
        } else if (FormMustahiq2.getNikText().getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Silahkan isi NIK terlebih dahulu.");
            FormMustahiq2.getNikText().requestFocus();
        } else if (FormMustahiq2.getNo_hpText().getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Silahkan isi NO HP terlebih dahulu.");
            FormMustahiq2.getNo_hpText().requestFocus();
        } else if (FormMustahiq2.getRwText().getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Silahkan isi RW terlebih dahulu.");
            FormMustahiq2.getRwText().requestFocus();
        } else {
            try {
                MustahiqModel2.setNama(FormMustahiq2.getNamaText().getText());
                MustahiqModel2.setNik(FormMustahiq2.getNikText().getText());
                MustahiqModel2.setNo_hp(FormMustahiq2.getNo_hpText().getText());
                MustahiqModel2.setRW(Integer.parseInt(FormMustahiq2.getRwText().getText()));
                MustahiqModel2.setTanggungan(Integer.parseInt(FormMustahiq2.getTanggunganText().getText()));
                MustahiqInterface2.add(MustahiqModel2);

                messageSuccess("Pendaftaran berhasil !!");

                reset();
                FormMustahiq2.setVisible(false);
                new ListMustahiq().setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error di add MustahiqController "+ e);
            }
        }

    }

    public void update() {
        MustahiqModel MustahiqModel2 = new MustahiqModel();

        if (FormMustahiq2.getNamaText().getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Silahkan isi nama terlebih dahulu.");
            FormMustahiq2.getNamaText().requestFocus();
        } else if (FormMustahiq2.getNikText().getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Silahkan isi NIK terlebih dahulu.");
            FormMustahiq2.getNikText().requestFocus();
        } else if (FormMustahiq2.getNo_hpText().getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Silahkan isi NO HP terlebih dahulu.");
            FormMustahiq2.getNo_hpText().requestFocus();
        } else if (FormMustahiq2.getRwText().getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Silahkan isi RW terlebih dahulu.");
            FormMustahiq2.getRwText().requestFocus();
        } else {
            try {
                MustahiqModel2.setNama(FormMustahiq2.getNamaText().getText());
                MustahiqModel2.setNik(FormMustahiq2.getNikText().getText());
                MustahiqModel2.setNo_hp(FormMustahiq2.getNo_hpText().getText());
                MustahiqModel2.setRW(Integer.parseInt(FormMustahiq2.getRwText().getText()));
                MustahiqModel2.setTanggungan(Integer.parseInt(FormMustahiq2.getTanggunganText().getText()));
                MustahiqInterface2.update(MustahiqModel2);
                
                messageSuccess("Update Berhasil.");
                
                FormMustahiq2.setVisible(false);
                new ListMustahiq().setVisible(true);
                
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public void reset() {
        FormMustahiq2.getNamaText().setText("");
        FormMustahiq2.getNikText().setText("");
        FormMustahiq2.getNo_hpText().setText("");
        FormMustahiq2.getTanggunganText().setText("");
        FormMustahiq2.getRwText().setText("");
    }

    //maksud eeeeeeeeee
    public void welcome() {

        FormMustahiq2.setVisible(false);
        new Welcome().setVisible(true);

    }

    public void addMustahiq() {
        ListMustahiq2.setVisible(false);
        new FormMustahiq().setVisible(true);
    }
}
