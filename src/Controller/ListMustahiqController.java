/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MustahiqDAO;
import Model.TableMustahiqModel;
import View.ListMustahiq;
import Model.MustahiqModel;
import Model.Session;
import View.FormMustahiq;
import java.util.List;
import javax.swing.JOptionPane;
import Interface.MustahiqInterface;

/**
 *
 * @author mz-hafizha
 */
public class ListMustahiqController extends BaseController {

    ListMustahiq ListMustahiq2;
    FormMustahiq FormMustahiq2 = new FormMustahiq();
    MustahiqModel MustahiqModel2 = new MustahiqModel();
    MustahiqInterface MustahiqInterface2;
    List<MustahiqModel> lm;

    public ListMustahiqController(ListMustahiq ListMustahiq2) {
        this.ListMustahiq2 = ListMustahiq2;
        MustahiqInterface2 = new MustahiqDAO();
        isiTabel();
    }

    public void showForm() {
        ListMustahiq2.setVisible(false);
        new FormMustahiq().setVisible(true);
    }

    public void isiTabel() {
        lm = MustahiqInterface2.getAll();
        TableMustahiqModel tmm = new TableMustahiqModel(lm);
        ListMustahiq2.getTableMustahiq().setModel(tmm); //maksud eeee
    }

    public void b_delete() {
    if(ListMustahiq2.getNikText().getText().trim().equals("")){
       JOptionPane.showMessageDialog(null, "Isi NIK yang ingin dihapus");
    }
        MustahiqModel2.setNik(ListMustahiq2.getNikText().getText());
        if (JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data ini?", "Warning", 2) == JOptionPane.YES_OPTION) {
            String nik="";
            if (MustahiqInterface2.delete(MustahiqModel2.getNik())) {
                JOptionPane.showMessageDialog(null, "Data Telah dihapus");
                isiTabel();
            } else {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
            }
        } 
    }

    public void b_update() {
//        klik_table();

        ListMustahiq2.setVisible(false);
        new FormMustahiq().setVisible(true);

//        MustahiqModel MustahiqModel2 = new MustahiqModel();
//        MustahiqModel2.setNama(FormMustahiq2.getNamaText().getText());
//        MustahiqModel2.setNik(FormMustahiq2.getNikText().getText());
//        MustahiqModel2.setNo_hp(FormMustahiq2.getNo_hpText().getText());
//        MustahiqModel2.setTanggungan(Integer.parseInt(FormMustahiq2.getTanggunganText().getText()));
//        MustahiqModel2.setRW(Integer.parseInt(FormMustahiq2.getRwText().getText()));
//        MustahiqInterface2.update(MustahiqModel2); //pengerror
    }

    public void klik_table() {
        int baris = ListMustahiq2.getTableMustahiq().getSelectedRow();
        String nama = ListMustahiq2.getTableMustahiq().getValueAt(baris, 0).toString();
        String nik = ListMustahiq2.getTableMustahiq().getValueAt(baris, 1).toString();
        String no_hp = ListMustahiq2.getTableMustahiq().getValueAt(baris, 2).toString();
        String tanggungan = ListMustahiq2.getTableMustahiq().getValueAt(baris, 3).toString();
        String RW = ListMustahiq2.getTableMustahiq().getValueAt(baris, 4).toString();

        Session.setNik(nik);
        Session.setNama(nama);
        Session.setNo_hp(no_hp);
        Session.setTanggungan(Integer.parseInt(tanggungan));
        Session.setRW(Integer.parseInt(RW));
//        b_update();

//        FormMustahiq2.getNamaText().setText(nama);
//        FormMustahiq2.getNikText().setText(nik);
//        FormMustahiq2.getNo_hpText().setText(no_hp);
//        FormMustahiq2.getTanggunganText().setText(tanggungan);
//        FormMustahiq2.getRwText().setText(RW);
//        
//        FormMustahiq2.
    }
}

//    public void isiField(int row){
//        FormMustahiq2.getNamaText().setText(lm.get(row).getNama().toString());
//        FormMustahiq2.getNikText().setText(lm.get(row).getNik().toString());
//        FormMustahiq2.getNo_hpText().setText(lm.get(row).getNo_hp().toString());
//        FormMustahiq2.getTanggunganText().setText(lm.get(row).((Integer.parseInt)(getTanggungan())));
//    }
//}
