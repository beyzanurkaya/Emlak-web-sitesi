
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
@ManagedBean(name = "arama")
@RequestScoped
public class Arama implements Serializable {

    private String secim;
    private String secim2;
    private String max;
    private String min;

    public String getSecim() {
        return secim;
    }

    public void setSecim(String secim) {
        this.secim = secim;
    }

    public String getSecim2() {
        return secim2;
    }

    public void setSecim2(String secim2) {
        this.secim2 = secim2;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setSoyad(String max) {
        this.max = max;
    }

    public List<Sonuc> ara() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, "baglanti sikintisi");
        }

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/emlak", "APP", "APP");
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, "baglanti sikintisi");
        }

        PreparedStatement addEntry
                = conn.prepareStatement("SELECT * FROM APP.KONUT" + " WHERE " + "KIRA_BEDELI > ? AND KIRA_BEDELI < ? ");

        addEntry.setString(1, getMin());
        addEntry.setString(2, getMax());
        ResultSet rs = addEntry.executeQuery();
        List<Sonuc> liste = new ArrayList<>();
        while (rs.next()) {
            Sonuc aa = new Sonuc();
            aa.setAdi(rs.getString("ADI"));
            aa.setAdres(rs.getString("ADRES"));
            aa.kira(rs.getInt("KIRA_BEDELI"));
            aa.satis(rs.getInt("SATIS_BEDELI"));
            liste.add(aa);
        }
        return liste;

    }
}
