/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.MustahiqModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Koneksi.Koneksi;
import Model.Session;
import View.ListMustahiq;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mz-hafizha
 */
public class MustahiqDAO implements Interface.MustahiqInterface {

//    private Connection Koneksi2;
    private String show = "SELECT * FROM mustahiq";
    private String update = "Update mustahiq SET nama=?, nik=?, no_hp=?, tanggungan=?, RW=? where nik=?";
    private String add = "INSERT INTO mustahiq Values (?,?,?,?,?)";
    private String delete = "DELETE FROM mustahiq WHERE nik=?";
    
    @Override
    public void add(MustahiqModel MustahiqModel2) {
        try {
            PreparedStatement statement = Koneksi.getConnection().prepareStatement(add, Statement.RETURN_GENERATED_KEYS);

//            preparedStatement.setInt(1, MustahiqModel2.getId_mustahiq());
            statement.setString(1, MustahiqModel2.getNama());
            statement.setString(2, MustahiqModel2.getNik());
            statement.setString(3, MustahiqModel2.getNo_hp());
            statement.setInt(4, MustahiqModel2.getTanggungan());
            statement.setInt(5, MustahiqModel2.getRW());

            statement.executeUpdate();
//            ResultSet resultSet = statement.getGeneratedKeys();
//
//            if (resultSet.next()) {
//                MustahiqModel2.setId_mustahiq(resultSet.getInt(1));
//            }

            statement.close();


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error di add MustahiqDAO "+e);
        }

    }

    @Override
    public List<MustahiqModel> getAll() {
        List<MustahiqModel> lmm = null;
        try {
            lmm = new ArrayList<MustahiqModel>();
//            Statement st = Koneksi2.prepareStatement();
            Statement st = Koneksi.getConnection().createStatement();
            ResultSet rs = st.executeQuery(show);

            while (rs.next()) {
                MustahiqModel MustahiqModel2 = new MustahiqModel();
//                MustahiqModel2.setId_mustahiq(rs.getInt("id_mustahiq"));
                MustahiqModel2.setNik(rs.getString("nik"));
                MustahiqModel2.setNama(rs.getString("nama"));
                MustahiqModel2.setNo_hp(rs.getString("no_hp"));
                MustahiqModel2.setTanggungan(rs.getInt("tanggungan"));
                MustahiqModel2.setRW(rs.getInt("RW"));

                lmm.add(MustahiqModel2);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error di getAll MustahiqDAO "+ ex);
        }
        return lmm;
    }

    @Override
    public void show(MustahiqModel MustahiqModel2) {
//        PreparedStatement statement = Koneksi.getConnection().prepareStatement(add, Statement.RETURN_GENERATED_KEYS);

        try {
            PreparedStatement statement = Koneksi.getConnection().prepareStatement(show, Statement.RETURN_GENERATED_KEYS);

            statement = Koneksi.getConnection().prepareStatement(update);

            statement.setString(1, MustahiqModel2.getNama());
            statement.setString(2, MustahiqModel2.getNik());
            statement.setString(3, MustahiqModel2.getNo_hp());
            statement.setInt(4, MustahiqModel2.getTanggungan());
            statement.setInt(5, MustahiqModel2.getRW());
           

            statement.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public boolean delete(String nik) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            PreparedStatement statement = null;
            statement = Koneksi.getConnection().prepareStatement(delete);
            statement.setString(1, nik);
            statement.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Bagian DAO gaError");
            return true;
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
        
    }

    @Override
    public void update(MustahiqModel MustahiqModel2) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            PreparedStatement statement = null;
            statement = Koneksi.getConnection().prepareStatement(update);
            
            statement.setString(1, MustahiqModel2.getNama());  
            statement.setString(3, MustahiqModel2.getNo_hp());
            statement.setString(2, MustahiqModel2.getNik());
            statement.setInt(4, MustahiqModel2.getTanggungan());
            statement.setInt(5, MustahiqModel2.getRW());
//            statement.setInt(6, MustahiqModel2.getId_mustahiq());
            statement.setString(6, MustahiqModel2.getNik());
 
            statement.executeUpdate();
            statement.close();
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error di update MustahiqDAO "+ ex);
        }
    }

    @Override
    public List<MustahiqModel> getMustahiq() {
        List<MustahiqModel> list = new ArrayList<>();
        
        try {
//            PreparedStatement preparedStatement = Koneksi.getConnection().prepareStatement(""
//                    + show);
            Statement st = Koneksi.getConnection().createStatement();
            
//            preparedStatement.setString(1, Session.getNik());
            ResultSet rs = st.executeQuery(show);
            
            while (rs.next()) {
                MustahiqModel model = new MustahiqModel();
                model.setNik(rs.getString("nik"));
                model.setNama(rs.getString("nama"));
                model.setNo_hp(rs.getString("no_hp"));
                model.setRW(rs.getInt("RW"));
                model.setTanggungan(rs.getInt("tanggungan"));
                list.add(model);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}