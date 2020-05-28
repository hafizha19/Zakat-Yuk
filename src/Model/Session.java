/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author mz-hafizha
 */
public class Session {
    private static int id_mustahiq,tanggungan, RW;
    private static String nik, nama, no_hp;

    public static int getId_mustahiq() {
        return id_mustahiq;
    }

    public static void setId_mustahiq(int id_mustahiq) {
        Session.id_mustahiq = id_mustahiq;
    }

    public static int getTanggungan() {
        return tanggungan;
    }

    public static void setTanggungan(int tanggungan) {
        Session.tanggungan = tanggungan;
    }

    public static int getRW() {
        return RW;
    }

    public static void setRW(int RW) {
        Session.RW = RW;
    }

    public static String getNik() {
        return nik;
    }

    public static void setNik(String nik) {
        Session.nik = nik;
    }

    public static String getNama() {
        return nama;
    }

    public static void setNama(String nama) {
        Session.nama = nama;
    }

    public static String getNo_hp() {
        return no_hp;
    }

    public static void setNo_hp(String no_hp) {
        Session.no_hp = no_hp;
    }
    
    
}
