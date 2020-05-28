/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.ListJenisZakat;
import javax.swing.JOptionPane;

/**
 *
 * @author mz-hafizha
 */
public class BaseController {
//    ListJenisZakat listJenisZakat;
    
    public static void messageSuccess(String a) {
        JOptionPane.showMessageDialog(null, a, "Pesan", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void messageFailed(String a) {
        JOptionPane.showMessageDialog(null, a, "Pesan", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void letakError(String a){
        JOptionPane.showMessageDialog(null, a, "Letak Error: ", JOptionPane.ERROR_MESSAGE);
    }
    
    
}
