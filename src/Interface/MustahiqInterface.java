/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Model.MustahiqModel;
import View.ListMustahiq;
import java.util.List;

/**
 *
 * @author mz-hafizha
 */
public interface MustahiqInterface {
    public void add(MustahiqModel MustahiqModel2);
    public void show(MustahiqModel MustahiqModel2);
    public void update(MustahiqModel MustahiqModel2);
    public boolean delete(String nik);
    public List<MustahiqModel> getAll();

    public List<MustahiqModel> getMustahiq();

}
