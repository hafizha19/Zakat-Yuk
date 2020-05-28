/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Model.JenisZakatModel;
import java.util.List;

/**
 *
 * @author mz-hafizha
 */
public interface JenisZakatInterface {
    public void add(JenisZakatModel JenisZakatModel2);    
    public void tampilData(JenisZakatModel JenisZakatModel2);
    public void update(JenisZakatModel JenisZakatModel2);
    public List<JenisZakatModel> getAll();
    public List<JenisZakatModel> getJenis();
}
