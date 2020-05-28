/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;

import Controller.BaseController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author mz-hafizha
 */
public class Koneksi extends BaseController{

    private static Connection mariakonek;

    public static Connection getConnection() {
        if (mariakonek == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                mariakonek = DriverManager.getConnection("jdbc:mariadb://localhost/ZakatYuk", "root", "");

            } catch (Exception e) {
                messageFailed("Koneksi Error");
            }
        }

        return mariakonek;
    }
}
