
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;
//import javax.faces.bean.ViewScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.faces.bean.ManagedBean;    
import javax.faces.bean.SessionScoped;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gizze
 */
@ManagedBean(name="hizmet")
@RequestScoped
public class Hizmet implements Serializable{

    private String id;
    private String mesajKonusu;
    private String ad;
    private String soyad;
    private String telefon;
    private String mail;
    private String bilgiTuru;
    private String mesajIcerik;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMesajKonusu() {
        return mesajKonusu;
    }

    public void setMesajKonusu(String mesajKonusu) {
        this.mesajKonusu = mesajKonusu;
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

    public String getBilgiTuru() {
        return bilgiTuru;
    }

    public void setBilgiTuru(String bilgiTuru) {
        this.bilgiTuru = bilgiTuru;
    }

    public String getMesajIcerik() {
        return mesajIcerik;
    }

    public void setMesajIcerik(String mesajIcerik) {
        this.mesajIcerik = mesajIcerik;
    }

    //CachedRowSet rowSet = null;
 
   public String mesaj_gonder() throws SQLException {
         try{        
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
                    = conn.prepareStatement( "INSERT INTO APP.HIZMET" + " (AD, SOYAD, TELEFON, MAIL, MESAJKONUSU, MESAJICERIK, BILGITURU) " + "VALUES ( ?, ?, ?, ?, ?, ?, ? )" );  // specify the PreparedStatement's arguments
            addEntry.setString( 1, getAd() );
            addEntry.setString( 2, getSoyad() );
            addEntry.setString( 3, getTelefon() );
            addEntry.setString( 4, getMail() );
            addEntry.setString( 5, getMesajKonusu() );
            addEntry.setString( 6, getMesajIcerik() );
            addEntry.setString( 7, getBilgiTuru() );
            addEntry.executeUpdate(); // insert the entry sql i yanlş yazarsan  burda hata alırsın 
            return "index"; // go back to index.xhtml home page
        } // end try
          
        finally {
            //conn.close(); // return this connection to pool
        } // end finally
    }
}
