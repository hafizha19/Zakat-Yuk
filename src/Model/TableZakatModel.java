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
public class TableZakatModel extends AbstractTableModel{
    List<ZakatModel> lm;

    public TableZakatModel(List<ZakatModel> lm) {
        this.lm = lm;
    }
    
    @Override
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return lm.size();
    }

    @Override
    public int getColumnCount() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return 5;
    }

    @Override
    public Object getValueAt(int row, int column) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        switch (column) {
            case 0: 
                return lm.get(row).getNik();
            case 1:
                return lm.get(row).getTanggungan();
            case 2:
                return lm.get(row).getJenis_zakat();
            case 3:
                return lm.get(row).getTotal();
            case 4:
                return lm.get(row).getTanggal();
                
            default:
                return null;
        }
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0: 
                return "NIK";
            case 1:
                return "Tanggungan";
            case 2:
                return "Jenis Zakat";
            case 3:
                return "Total Zakat";
            case 4:
                return "Tanggal";
            default:
                return null;    
                
        }
    }
}
