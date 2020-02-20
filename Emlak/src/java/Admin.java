
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;

/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 *
 *
 *
 */
/*
@ManagedBean(name = "admin")
@RequestScoped

public class Admin {

    private String soyad;
    private String telefon;
    private String mail;
    private String ad;
    private String id;
    private String sifre;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    /*            ps=con.prepareStatement("SELECT * FROM APP.KULLANICILAR");
            ResultSet rs=ps.executeQuery();
            List<Admin> liste=new ArrayList<>();
            while(rs.next()){
                Admin aa=new Admin();
                aa.setId(rs.getString("id"));
                aa.setAd(rs.getString("ad"));
                aa.setSoyad(rs.getString("soyad"));
                aa.setTelefon(rs.getString("telefon"));
                aa.setMail(rs.getString("mail"));
                aa.setId(rs.getString("sifre"));
                liste.add(aa);
            }
            return liste;*/
 /*PreparedStatement ps = null;
    Connection con = null;

    public List<Admin> getTablo1() throws SQLException {
        
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

            System.out.println("DB DB DB DB");

            ps = con.prepareStatement("SELECT * FROM APP.KULLANICILAR");
            ResultSet rs = ps.executeQuery();
            List<Admin> liste = new ArrayList<>();
            while (rs.next()) {
                Admin aa = new Admin();
                aa.setId(rs.getString("id"));
                aa.setAd(rs.getString("ad"));
                aa.setSoyad(rs.getString("soyad"));
                aa.setTelefon(rs.getString("telefon"));
                aa.setMail(rs.getString("mail"));
                aa.setId(rs.getString("sifre"));
                liste.add(aa);
            }
            return liste;
        }
    }
 */
@ManagedBean(name = "admin")
@RequestScoped
public class Admin implements Serializable {

    private String soyad;
    private String telefon;
    private String mail;
    private String ad;
    private String id;
    private String sifre;
    private String bulunacak_kayit;
    private String silinecek_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public void setBulunacak_kitap(String bulunacak_kayit) {
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

    CachedRowSet rowSet = null;

    DataSource dataSource;

    public Admin() {
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("jdbc/addressbook");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    /*  public List<Sonuc> gotuntule() throws SQLException{
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
                PreparedStatement addEntry //+ " WHERE " + "KIRA_BEDELI > ? && KIRA_BEDELI < ? "
                        = conn.prepareStatement("SELECT * FROM APP.KONUT");

                addEntry.setString(1, getId());
                addEntry.setString(2, getAd());
                addEntry.setString(2, getSoyad());
                addEntry.setString(2, getTelefon());
                addEntry.setString(2, getMail());
                addEntry.setString(2, getSifre());
                ResultSet rs = addEntry.executeQuery();
                List<Sonuc> liste = new ArrayList<>();
                while (rs.next())
                {
                    Sonuc aa = new Sonuc();
                    aa.setId(rs.getInt("id"));
                    aa.setAdi(rs.getString("adi"));
                    aa.setAdres(rs.getString("adres"));
                    aa.kira(rs.getInt("kira_bedeli"));
                    aa.satis(rs.getInt("satis_bedeli"));
                    liste.add(aa);
                }
                return liste;
    }
        finally {
           //conn.close();
        } 
}*/
    public ResultSet bul() throws SQLException {
        // check whether dataSource was injected by the server
        if (dataSource == null) {
            throw new SQLException("Unable to obtain DataSource");
        }

        // obtain a connection from the connection pool
        Connection connection = dataSource.getConnection();

        // check whether connection was successful
        if (connection == null) {
            throw new SQLException("Unable to connect to DataSource");
        }

        try {
            // create a PreparedStatement to insert a new address book entry
            PreparedStatement ps
                    = connection.prepareStatement("select kitaplar.ISBN,kitaplar.ad,yazarlar.ad as yazar_ad,yazarlar.soyad as yazar_soyad,"
                            + "yazarlar.id,kitaplar.basim_yili, kitaplar.yayin_evi from kitaplar,yazarlar "
                            + "where kitaplar.ad=? and kitaplar.yazar_id=yazarlar.id");
            ps.setString(1, getBulunacak_kayit());
            rowSet = new com.sun.rowset.CachedRowSetImpl();
            rowSet.populate(ps.executeQuery());
            return rowSet;
        } // end try
        finally {
            connection.close(); // return this connection to pool
        } // end finally
    }

    public String sil() throws SQLException {
        // check whether dataSource was injected by the server
        if (dataSource == null) {
            throw new SQLException("Unable to obtain DataSource");
        }

        // obtain a connection from the connection pool
        Connection connection = dataSource.getConnection();

        // check whether connection was successful
        if (connection == null) {
            throw new SQLException("Unable to connect to DataSource");
        }

        try {
            // create a PreparedStatement to insert a new address book entry
            PreparedStatement myObject
                    = connection.prepareStatement("delete from kitaplar where isbn=?");

            // specify the PreparedStatement's arguments
            myObject.setInt(1, Integer.parseInt(getSilinecek_id()));

            myObject.executeUpdate(); // insert the entry
            return "index"; // go back to index.xhtml page
        } // end try
        finally {
            connection.close(); // return this connection to pool
        } // end finally
    }
}
