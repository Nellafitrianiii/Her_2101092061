/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package her__b;

/**
 *
 * @author Asus
 */
public class Hutang {
    private String Kode;
    private String Tgl;
    private String Pembeli;
    private int Totalbeli;
    private Double diskon;
    private int Hutang;

    public Hutang() {
    }

    public Hutang(String Kode, String Tgl, String Pembeli, int Totalbeli, Double diskon, int Hutang) {
        this.Kode = Kode;
        this.Tgl = Tgl;
        this.Pembeli = Pembeli;
        this.Totalbeli = Totalbeli;
        this.diskon = diskon;
        this.Hutang = Hutang;
    }

    public String getKode() {
        return Kode;
    }

    public void setKode(String Kode) {
        this.Kode = Kode;
    }

    public String getTgl() {
        return Tgl;
    }

    public void setTgl(String Tgl) {
        this.Tgl = Tgl;
    }

    public String getPembeli() {
        return Pembeli;
    }

    public void setPembeli(String Pembeli) {
        this.Pembeli = Pembeli;
    }

    public int getTotalbeli() {
        return Totalbeli;
    }

    public void setTotalbeli(int Totalbeli) {
        this.Totalbeli = Totalbeli;
    }

    public Double getDiskon() {
        double diskon = 0.02;
        return diskon;
    }

    public int getHutang() {
        if(Hutang > 100000){
            double diskon = 0.02;
            Hutang = (int) (Totalbeli - diskon);
        } else {
            System.out.println("Tidak dapat ndiskon");
        }
        return Hutang;
    }

    public void setHutang(int Hutang) {
        this.Hutang = Hutang;
    }
    
    
    
}
