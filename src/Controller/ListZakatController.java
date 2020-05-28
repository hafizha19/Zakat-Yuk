/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ZakatDAO;
import Interface.ZakatInterface;
import Model.TableZakatModel;
import Model.ZakatModel;
import View.FormZakat;
import View.ListZakat;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mz-hafizha
 */
public class ListZakatController extends BaseController{
    ListZakat ListZakat2;
    FormZakat FormZakat2 = new FormZakat();
    ZakatModel ZakatModel2 = new ZakatModel();
    ZakatInterface ZakatInterface2;
    List<ZakatModel> zm;

    public ListZakatController(ListZakat ListZakat2) {
        this.ListZakat2 = ListZakat2;
        ZakatInterface2 = new ZakatDAO();
        isiTable();
    }
    
    public void isiTable(){
        zm = ZakatInterface2.getAll();
        TableZakatModel tmm = new TableZakatModel(zm);
        ListZakat2.getTableZakat().setModel(tmm);
    }
    
    public void delete(){
      if(ListZakat2.getNikText().getText().trim().equals("")){
       JOptionPane.showMessageDialog(null, "Isi NIK yang ingin dihapus");
    }
        ZakatModel2.setNik(ListZakat2.getNikText().getText());
        if (JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data ini?", "Warning", 2) == JOptionPane.YES_OPTION) {
            String nik="";
            if (ZakatInterface2.delete(ZakatModel2.getNik())) {
                messageSuccess("Data Telah Berhasil Dihapus.");
                
            } else {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
            }
        } else {
            System.out.println("oh");
        }
//        isiTabel();
    }

//    public void klik_table(){
//        ZakatModel ZakatModel2 = new ZakatModel();
//        
//        int baris = ListZakat2.getTableZakat().getSelectedRow();
//        ZakatModel2.setNik(ListZakat2.getTableZakat().getValueAt(baris, 0).toString());
//        ZakatModel2.setTanggungan(Integer.valueOf(ListZakat2.getTableZakat().getValueAt(baris, 1).toString()));
//        ZakatModel2.setTotal(Double.valueOf(ListZakat2.getTableZakat().getValueAt(baris, 3).toString()));
//        ZakatModel2.setJenis_zakat(ListZakat2.getTableZakat().getValueAt(baris, 2).toString());
//        ZakatModel2.setTanggal(ListZakat2.getTableZakat().getValueAt(baris, 4).toString());
//        
//        
//    }
    
//    public boolean reset(){
//        TableZakatModel tzm = new TableZakatModel(zm);
        
//        int baris = tzm.getRowCount();
//        for (int i = 0; i < baris; i++) {
//            tzm.remove
//        }
//    }
    
    

}
