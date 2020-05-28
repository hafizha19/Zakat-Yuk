/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Model.AmilModel;
import java.util.List;

/**
 *
 * @author mz-hafizha
 */
public interface AmilInterface {
    
    //public boolean masuk (String id_amil, String password);
//    public List getAmil(long id);
    
    public boolean checkLogin(AmilModel account);
}
