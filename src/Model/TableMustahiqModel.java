/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mz-hafizha
 */
public class TableMustahiqModel extends AbstractTableModel {

    List<MustahiqModel> lmm;

    public TableMustahiqModel(List<MustahiqModel> lmm) {
        this.lmm = lmm;
    }

    @Override
    public int getRowCount() {
        return lmm.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
//            case 0:
//                return lmm.get(row).getId_mustahiq();
            case 0:
                return lmm.get(row).getNama();
            case 1:
                return lmm.get(row).getNik();
            case 2:
                return lmm.get(row).getNo_hp();
            case 3:
                return lmm.get(row).getTanggungan();
            case 4:
                return lmm.get(row).getRW();

            default:
                return null;
        }
    }
    
    public String getColumnName(int column){
        switch (column){
//            case 0:
//                return "ID Mustahiq";
            case 0:
                return "Nama";
            case 1:
                return "NIK";
            case 2:
                return "NO HP";
            case 3:
                return "Tanggungan";
            case 4:
                return "RW";
           
            default:
                return null;    
        }
    }
    
    

}
