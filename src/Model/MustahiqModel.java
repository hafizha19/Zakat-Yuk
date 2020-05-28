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
public class MustahiqModel {
    private int id_mustahiq,tanggungan, RW;
    private String nik, nama, no_hp;

//    public int getId_mustahiq() {
//        return id_mustahiq;
//    }
//
//    public void setId_mustahiq(int id_mustahiq) {
//        this.id_mustahiq = id_mustahiq;
//    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }
 
    public int getTanggungan() {
        return tanggungan;
    }

    public void setTanggungan(int tanggungan) {
        this.tanggungan = tanggungan;
    }

    public int getRW() {
        return RW;
    }

    public void setRW(int RW) {
        this.RW = RW;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }    
    
}
