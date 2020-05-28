/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.AmilModel;
import Koneksi.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.List;
import Interface.AmilInterface;

/**
 *
 * @author mz-hafizha
 */
public class AmilDAO implements AmilInterface {

    
    @Override
    public boolean checkLogin(AmilModel account) {
        try {
            PreparedStatement preparedStatement = Koneksi
                    .getConnection().prepareStatement(""
                    + "SELECT username, password FROM login WHERE username = ? AND "
                            + "password = ?");
            
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {                
                return true;
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return false;
    }

//    @Override
//    public List getAmil(long id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }


}