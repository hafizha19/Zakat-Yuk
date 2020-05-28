/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.BaseController;
import Koneksi.Koneksi;
import Model.JenisZakatModel;
import View.ListJenisZakat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mz-hafizha
 */
public class JenisZakatDAO implements Interface.JenisZakatInterface {

    private String add = "INSERT INTO jenis_zakat VALUES (?,?)";
    private String update = "UPDATE jenis_zakat SET jenis_zakat=?, besaran=? WHERE jenis_zakat=?";
    private String show = "SELECT * FROM jenis_zakat";
    
    @Override
    public void add(JenisZakatModel JenisZakatModel2) {
        try {
            PreparedStatement statement = Koneksi.getConnection().prepareStatement(add, Statement.RETURN_GENERATED_KEYS);
//            statement.setInt(1, JenisZakatModel2.getId_jenis_zakat());
            statement.setString(1, JenisZakatModel2.getJenis());
            statement.setDouble(2, JenisZakatModel2.getBesaran());
            
            statement.executeUpdate();
//            ResultSet resultSet = statement.getGeneratedKeys();
//            
//            if(resultSet.next()){
//                JenisZakatModel2.setId_jenis_zakat(1);
//            }
            
            statement.close();
            
        } catch (SQLException e) {
            BaseController.letakError("Add JenisZakatDAO: "+ e.getMessage());
        }
    }
    
    public void tampilData(JenisZakatModel jenisZakatModel){
        PreparedStatement statement = null;
        
        try {
            statement = Koneksi.getConnection().prepareStatement(update);
            
            statement.setString(1, jenisZakatModel.getJenis());
            statement.setDouble(2, jenisZakatModel.getBesaran());
            statement.setString(3, jenisZakatModel.getJenis());
            statement.executeUpdate();
            
            
        } catch (SQLException e) {
            BaseController.letakError("TampilData JenisZakatDAO: "+e);
        }
    }

    @Override
    public void update(JenisZakatModel JenisZakatModel2) {
        try {
            PreparedStatement statement = Koneksi.getConnection().prepareStatement(update);
            statement.setString(1, JenisZakatModel2.getJenis());
            statement.setDouble(2, JenisZakatModel2.getBesaran());
            statement.setString(3, JenisZakatModel2.getJenis());
            
            statement.executeUpdate();
            statement.close();
                        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error di Update Jenis Zakat DAO: "+e.getMessage());
        }
    }

    @Override
    public List<JenisZakatModel> getAll() {
        List<JenisZakatModel> ljzm = null;
        
        try {
            ljzm = new ArrayList<JenisZakatModel>();
            Statement st = Koneksi.getConnection().createStatement();
            ResultSet rs = st.executeQuery(show);
            
            while (rs.next()){
                JenisZakatModel jenisZakatModel = new JenisZakatModel();
//                jenisZakatModel.setId_jenis_zakat(rs.getInt("id_jenis_zakat"));
                jenisZakatModel.setJenis(rs.getString("jenis_zakat"));
                jenisZakatModel.setBesaran(rs.getDouble("besaran"));
                ljzm.add(jenisZakatModel);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error di getAll JenisZakatDAO "+e);
        }
        return ljzm;
    }

    @Override
    public List<JenisZakatModel> getJenis() {
        List<JenisZakatModel> list = new ArrayList<>();
        
        try {
//            ljz = new ArrayList<JenisZakatModel>();
            Statement st = Koneksi.getConnection().createStatement();
            ResultSet rs = st.executeQuery(show);
            
            while (rs.next()){
                JenisZakatModel jenisZakatModel = new JenisZakatModel();
//                jenisZakatModel.setId_jenis_zakat(rs.getInt("id_jenis_zakat"));
                jenisZakatModel.setJenis(rs.getString("jenis_zakat"));
                jenisZakatModel.setBesaran(rs.getDouble("besaran"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error di getJenis JenisZakatDAO "+ e);
        }
        return list;
    }
    
}
