/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

//import Implement.JenisZakat;
import java.util.Date;
import Interface.JenisZakatInterface;
import java.util.List;

/**
 *
 * @author mz-hafizha
 */
public class ZakatModel extends MustahiqModel{
    JenisZakatModel jenisZakatModel = new JenisZakatModel();
    
//    private Date tanggal;
//    private String nik, nama;
//    private int tanggungan, RW, total;
    private int tanggungan, id_transaksi;
    private double total;
    private String nik, nama,jenis_zakat, tanggal;

    public ZakatModel() {
        this.nik = super.getNik();
        this.nama = super.getNama();
        this.tanggungan = super.getTanggungan();
    }

    public String getJenis_zakat() {
        return jenis_zakat;
    }

    public void setJenis_zakat(String jenis_zakat) {
        this.jenis_zakat = jenis_zakat;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    
    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }



//    @Override
//    public void beras_kg() {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        double total_beras = (super.getTanggungan()+1)*2.5;
//        this.beras_kg = total_beras;
//    }
//
//    @Override
//    public void uang_rp() {
//        int total_uang = (tanggungan+1)*25000;
//        this.uang_rp = total_uang;
//    }
  
}
