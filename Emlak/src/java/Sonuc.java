
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Özcan
 */

public class Sonuc {
    private int id;
    private String adi;
    private String adres;
    private int kira_bedeli;
    private int satis_bedeli;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    
    public String getAdi() {
        return adi;
    }
    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getAdres() {
        return adres;
    }
    public void setAdres(String adres) {
        this.adres = adres;
    }
    
    public int kira() {
        return kira_bedeli;
    }
    public void kira(int kira_bedeli) {
        this.kira_bedeli = kira_bedeli;
    }
    
    public int satis() {
        return satis_bedeli;
    }
    public void satis(int satis_bedeli) {
        this.satis_bedeli = satis_bedeli;
    }
    
}


