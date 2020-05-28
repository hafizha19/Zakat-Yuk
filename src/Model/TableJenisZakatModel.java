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
public class TableJenisZakatModel extends AbstractTableModel {

    List<JenisZakatModel> ljzm;

    public TableJenisZakatModel(List<JenisZakatModel> ljzm) {
        this.ljzm = ljzm;
    }

    @Override
    public int getRowCount() {
        return ljzm.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
//            case 0:
//                return ljzm.get(row).getId_jenis_zakat();
            case 0:
                return ljzm.get(row).getJenis();
            case 1:
                return ljzm.get(row).getBesaran();

            default:
                return null;
        }
    }

    public String getColumnName(int column) {
        switch (column) {
//            case 0:
//                return "ID Jenis";
            case 0:
                return "Nama Jenis";
            case 1:
                return "Besaran";

            default:
                return null;
        }

    }
}
