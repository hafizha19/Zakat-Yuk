/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.BaseController;
import Koneksi.Koneksi;
import Model.MustahiqModel;
import Model.ZakatModel;
import java.sql.Date;
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
public class ZakatDAO implements Interface.ZakatInterface {

    private String show = "SELECT * FROM zakat";
    private String add = "INSERT INTO zakat VALUES (null, ?,?,?,?,?)";

    @Override
    public List<ZakatModel> getAll() {
        List<ZakatModel> lzm = null;
        try {
            lzm = new ArrayList<ZakatModel>();
            Statement st = Koneksi.getConnection().createStatement();
            ResultSet rs = st.executeQuery(show);

            while (rs.next()) {
                ZakatModel ZakatModel2 = new ZakatModel();
                ZakatModel2.setNik(rs.getString("nik"));
                ZakatModel2.setTanggungan(rs.getInt("tanggungan"));
                ZakatModel2.setJenis_zakat(rs.getString("jenis_zakat"));
                ZakatModel2.setTotal(rs.getDouble("total"));
                ZakatModel2.setTanggal(rs.getString("tanggal"));

                lzm.add(ZakatModel2);
            }
        } catch (Exception e) {
            BaseController.letakError("getAll ZakatDAO");
        }
        return lzm;
    }

    @Override
    public List<ZakatModel> getZakat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(ZakatModel ZakatModel2) {
        try {
            PreparedStatement statement = Koneksi.getConnection().prepareStatement(add, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, ZakatModel2.getNik());
            statement.setInt(2, ZakatModel2.getTanggungan());
            statement.setString(3, ZakatModel2.getJenis_zakat());
            statement.setDouble(4, ZakatModel2.getTotal());
            statement.setString(5, ZakatModel2.getTanggal());

            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                ZakatModel2.setId_transaksi(resultSet.getInt(1));
            }

            statement.close();

        } catch (Exception e) {
            BaseController.letakError("add ZakatDAO" + e);
        }
    }

    @Override
    public void show(ZakatModel ZakatModel2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void format(ZakatModel ZakatModel2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTanggungan(String NIK) {
        String tanggungan = "";

        try {

            PreparedStatement statement = Koneksi.getConnection().prepareStatement(""
                    + "SELECT tanggungan FROM mustahiq WHERE nik = ?");
            statement.setString(1, NIK);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                tanggungan = resultSet.getString("tanggungan");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tanggungan;
    }

    @Override
    public String getBesaran(String jenis_zakat) {
        String besaran = "";

        try {
            PreparedStatement statement = Koneksi.getConnection().prepareStatement(""
                    + "SELECT besaran FROM jenis_zakat where jenis_zakat = ?");
            statement.setString(1, jenis_zakat);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                besaran = resultSet.getString("besaran");
            }
        } catch (SQLException e) {
            BaseController.letakError("getBesaran ZakatDAO");
        }
        return besaran;
    }

//    @Override
//    public int getTotal(String NIK, String jenis_zakat) {
//        int total = 0;
//        
//        try {
//            PreparedStatement statement = Koneksi.getConnection().prepareStatement("" +
//                    "SELEC")
//        } catch (Exception e) {
//        }
//    }
    @Override
    public boolean delete(String nik) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String delete = "DELETE FROM zakat WHERE nik=?";
        try {
            PreparedStatement st = null;
            st = Koneksi.getConnection().prepareStatement(delete);
            st.setString(1, nik);
            st.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            BaseController.letakError("Delete() ZakatDAO "+e);
            return false;
        }
    }

}
