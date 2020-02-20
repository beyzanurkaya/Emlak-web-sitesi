import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.sql.rowset.CachedRowSet;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Özcan
 */
@ManagedBean(name = "login")
@RequestScoped
public class Login implements Serializable {
    
    private String ad;
    private String soyad;
    private String telefon;
    private String mail;
    private String sifre;
    private String bulunacak_kayit;
    private String silinecek_id;
    CachedRowSet rowSet = null;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    public void setBulunacak_kayit(String bulunacak_kayit) {
        this.bulunacak_kayit = bulunacak_kayit;
    }
    public String getBulunacak_kayit() {
        return bulunacak_kayit;
    }
    public String getSilinecek_id() {
        return silinecek_id;
    }
    public void setSilinecek_id(String silinecek_id) {
        this.silinecek_id = silinecek_id;
    }

    public String validate() {
        boolean aa = Login2.validate(ad, sifre);
        /*  else if(aa==true)
         return "index2";
     else 
         return "yanlış giriş";*/
        if ("admin".equals(ad) && "1".equals(sifre)) {
            return "admin";
        } else if (aa == true) {
            return "index2";
        } else {
            return "yanlış giriş";
        }
    }
    public String ekle() throws SQLException {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, "baglantı sikintisi");
            }

            Connection conn = null;
            try {
                conn = DriverManager.getConnection("jdbc:derby://localhost:1527/emlak", "APP", "APP");
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, "baglanti sikintisi");
            }

            PreparedStatement addEntry
                    = conn.prepareStatement("INSERT INTO APP.KULLANICILAR"
                            + "(AD, SOYAD, TELEFON, MAIL, SIFRE)"
                            + "VALUES ( ?, ?, ?, ?, ? )");

            addEntry.setString(1, getAd());
            addEntry.setString(2, getSoyad());
            addEntry.setString(3, getTelefon());
            addEntry.setString(4, getMail());
            addEntry.setString(5, getSifre());

            addEntry.executeUpdate();
            return "index";
        }
        finally {
            //conn.close();
        }
    }

    public String update() throws SQLException {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, "baglantı sikintisi");
            }

            Connection conn = null;
            try {
                conn = DriverManager.getConnection("jdbc:derby://localhost:1527/emlak", "APP", "APP");
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, "baglanti sikintisi");
            }

            PreparedStatement object3
                    = conn.prepareStatement("UPDATE APP.KULLANICILAR SET SIFRE=? WHERE MAIL=?");

            object3.setString(2, mail);
            object3.setString(1, sifre);

            object3.executeUpdate();

            return "uyegiris"; 
        }
        finally {
            //conn.close(); 
        } 

    }

    public String sil() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, "baglantı sikintisi");
        }

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/emlak", "APP", "APP");
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, "baglanti sikintisi");
        }
        try {
            PreparedStatement myObject
                    = conn.prepareStatement("DELETE FROM APP.KULLANICILAR WHERE MAIL=?");

            myObject.setString(1, getMail());

            myObject.executeUpdate(); 
            return "admin";
        } 
        finally {
            conn.close();
        }
    }
    
        public ResultSet bul() throws SQLException {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, "baglantı sikintisi");
            }

            Connection conn = null;
            try {
                conn = DriverManager.getConnection("jdbc:derby://localhost:1527/emlak", "APP", "APP");
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, "baglanti sikintisi");
            }
            PreparedStatement ps
                    = conn.prepareStatement("select kullanicilar.id, kullanicilar.ad, kullanicilar.soyad, kullanicilar.telefon, kullanicilar.mail, kullanicilar.sifre from kullanicilar" + " where kullanicilar.ad=?");
            ps.setString(1, getBulunacak_kayit());
            rowSet = new com.sun.rowset.CachedRowSetImpl();
            rowSet.populate(ps.executeQuery());
            return rowSet;
        }
        finally {
            //conn.close();
        }
    }

}
