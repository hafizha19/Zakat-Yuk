/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.JenisZakatDAO;
import DAO.MustahiqDAO;
import Interface.JenisZakatInterface;
import Model.JenisZakatModel;
import Model.TableJenisZakatModel;
import Model.TableMustahiqModel;
import View.ListJenisZakat;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mz-hafizha
 */
public class JenisZakatController extends BaseController {

//    JenisZakatModel JenisZakatModel2 = new JenisZakatModel();
    ListJenisZakat ListJenisZakat2;
    JenisZakatInterface JenisZakatInterface2;
    List<JenisZakatModel> ljzm;

    public JenisZakatController(ListJenisZakat ListJenisZakat2) {
        this.ListJenisZakat2 = ListJenisZakat2;
        JenisZakatInterface2 = new JenisZakatDAO();   
        ljzm = JenisZakatInterface2.getAll();
//        isiTabel();
    }

//    public void tampil() {
//        ListJenisZakat2.getJenisText().setText(JenisZakatModel2.getJenis());
//        ListJenisZakat2.getBesaranText().setText(Double.toString(JenisZakatModel2.getBesaran()));
//
//    }

    public void add() {
        JenisZakatModel JenisZakatModel2 = new JenisZakatModel();
        if (ListJenisZakat2.getJenisText().getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Silahkan isi Nama Jenis Barang yang Dizakatkan.");
            ListJenisZakat2.getJenisText().requestFocus();
        } else if (ListJenisZakat2.getBesaranText().getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Silahkan isi Besaran Jenis Barang yang Dizakatkan.");
            ListJenisZakat2.getJenisText().requestFocus();
        } else {
            try {
//                JenisZakatModel2.setId_jenis_zakat(Integer.parseInt(ListJenisZakat2.getIdText().getText()));
                JenisZakatModel2.setJenis(ListJenisZakat2.getJenisText().getText());
                JenisZakatModel2.setBesaran(Double.parseDouble(ListJenisZakat2.getBesaranText().getText()));
                
                JenisZakatInterface2.add(JenisZakatModel2);
                
                messageSuccess("Pendaftaran Berhasil");
                
                isiTabel();
                
            } catch (Exception e) {
                letakError("Add JenisZakatController "+ e);
            }
        }
    }
    
    public void isiTabel() {
        ljzm = JenisZakatInterface2.getAll();
        TableJenisZakatModel tjzm = new TableJenisZakatModel(ljzm);
        ListJenisZakat2.getTable_JenisZakat().setModel(tjzm); //maksud eeee
    }
    
    public  void update(){
        JenisZakatModel jenisZakatModel = new JenisZakatModel();
//        jenisZakatModel.setId_jenis_zakat(Integer.parseInt(ListJenisZakat2.getIdText().getText()));
        jenisZakatModel.setJenis(ListJenisZakat2.getJenisText().getText());
        jenisZakatModel.setBesaran(Double.parseDouble(ListJenisZakat2.getBesaranText().getText()));
        
        JenisZakatInterface2.update(jenisZakatModel);
        
        messageSuccess("Berhasil diupdate.");
        
        isiTabel();
    }
    
    public void isiField(){
        int baris = ListJenisZakat2.getTable_JenisZakat().getSelectedRow();
//        String id = ListJenisZakat2.getTable_JenisZakat().getValueAt(baris, 0).toString();
        String jenis = ListJenisZakat2.getTable_JenisZakat().getValueAt(baris, 0).toString();
        String besaran = ListJenisZakat2.getTable_JenisZakat().getValueAt(baris, 1).toString();
        
//        ListJenisZakat2.getIdText().setText(id);
        ListJenisZakat2.getJenisText().setText(jenis);
        ListJenisZakat2.getBesaranText().setText(besaran);
    }
    
}
