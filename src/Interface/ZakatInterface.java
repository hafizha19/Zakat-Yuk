/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Model.ZakatModel;
import java.util.List;

/**
 *
 * @author mz-hafizha
 */
public interface ZakatInterface {
    public List<ZakatModel> getAll();
    public List<ZakatModel> getZakat();
    public void add(ZakatModel ZakatModel2);
    public boolean delete(String nik);
    public void show(ZakatModel ZakatModel2);
    public void format(ZakatModel ZakatModel2);
    public String getTanggungan (String NIK);
    public String getBesaran (String jenis_zakat); 
//    public int getTotal(String NIK, String jenis_zakat);
}
