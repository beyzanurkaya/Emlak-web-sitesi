
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gizze
 */
public class Iletisim {

    private String unvan;
    private String vergiNo;
    private String sicilNo;
    private String adres;
    private String elektronikIletisim;
    private String telNo;
    private String mail;

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getVergiNo() {
        return vergiNo;
    }

    public void setVergiNo(String vergiNo) {
        this.vergiNo = vergiNo;
    }

    public String getSicilNo() {
        return sicilNo;
    }

    public void setSicilNo(String sicilNo) {
        this.sicilNo = sicilNo;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getElektronikIletisim() {
        return elektronikIletisim;
    }

    public void setElektronikIletisim(String elektronikIletisim) {
        this.elektronikIletisim = elektronikIletisim;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String iletisim_update(String a) throws SQLException {
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
            if (a == unvan) {
                PreparedStatement object
                        = conn.prepareStatement("UPDATE APP.ILETISIM SET UNVAN=?");
                object.setString(1, unvan);
                object.executeUpdate();

                return "admin"; //
            } else if (a == vergiNo) {
                PreparedStatement object
                        = conn.prepareStatement("UPDATE APP.ILETISIM SET VERGI_NO=?");
                object.setString(1, vergiNo);
                object.executeUpdate();

                return "admin"; //
            } else if (a == sicilNo) {
                PreparedStatement object
                        = conn.prepareStatement("UPDATE APP.ILETISIM SET SICIL_NO=?");
                object.setString(1, sicilNo);
                object.executeUpdate();

                return "admin"; //
            } else if (a == adres) {
                PreparedStatement object
                        = conn.prepareStatement("UPDATE APP.ILETISIM SET ADRES=?");
                object.setString(1, adres);
                object.executeUpdate();

                return "admin"; //
            } else if (a == elektronikIletisim) {
                PreparedStatement object
                        = conn.prepareStatement("UPDATE APP.ILETISIM SET ELEKTRONIK_ILETISIM=?");
                object.setString(1, elektronikIletisim);
                object.executeUpdate();

                return "admin"; //
            } else if (a == telNo) {
                PreparedStatement object
                        = conn.prepareStatement("UPDATE APP.ILETISIM SET TEL_NO=?");
                object.setString(1, telNo);
                object.executeUpdate();

                return "admin"; //
            } else if (a == mail) {
                PreparedStatement object
                        = conn.prepareStatement("UPDATE APP.ILETISIM SET MAIL=?");
                object.setString(1, mail);
                object.executeUpdate();

                return "admin"; //
            } else {
                System.out.println("islem yok!");
            }
        } // end try
        finally {
            //conn.close(); // return this connection to pool
        } // end finally
        return null;
    }
}
