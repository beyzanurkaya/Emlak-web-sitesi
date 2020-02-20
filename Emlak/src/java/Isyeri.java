import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
/**
 *
 * @author gizze
 */
@ManagedBean(name = "isyeri")
@SessionScoped
public class Isyeri {
    private String id;
    private String ad;
    private String adres;
    private String kira_bedeli;
    private String satis_bedeli;
    private String bulunacak_kayit;
    private String silinecek_id;
    CachedRowSet rowSet = null;
   // DataSource dataSource;

   /* public Konut() {
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("jdbc:derby://localhost:1527/emlak");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
*/
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
    public String getAdres() {
        return adres;
    }
    public void setAdres(String adres) {
        this.adres = adres;
    }   
    public String getKira_bedeli() {
        return kira_bedeli;
    }
    public void setKira_bedeli(String kira_bedeli) {
        this.kira_bedeli = kira_bedeli;
    }
    public String getSatis_bedeli() {
        return satis_bedeli;
    }
    public void setSatis_bedeli(String satis_bedeli) {
        this.satis_bedeli = satis_bedeli;
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
                    = conn.prepareStatement("INSERT INTO APP.ISYERI"
                            + "(ID, ADI, ADRES, KIRA_BEDELI, SATIS_BEDELI)"
                            + "VALUES ( ?, ?, ?, ?, ? )");         
            
            addEntry.setInt(1, Integer.parseInt(getId()));
            addEntry.setString(2, getAd());
            addEntry.setString(3, getAdres());
            addEntry.setInt(4, Integer.parseInt(getKira_bedeli()));
            addEntry.setInt(5, Integer.parseInt(getSatis_bedeli()));
            
            addEntry.executeUpdate();
            return "admin";
        }
        finally {
            //conn.close(); 
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
                    = conn.prepareStatement("select isyeri.id, isyeri.adi, isyeri.adres, isyeri.kira_bedeli, isyeri.satis_bedeli from isyeri" + " where isyeri.adi=?");
            ps.setString(1, getBulunacak_kayit());
            rowSet = new com.sun.rowset.CachedRowSetImpl();
            rowSet.populate(ps.executeQuery());
            return rowSet;
        }
        finally {
            //conn.close();
        }
    }

    public String sil() throws SQLException {
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
            PreparedStatement myObject
                    = conn.prepareStatement("DELETE FROM APP.ISYERI WHERE ID=?");
            myObject.setInt(1, Integer.parseInt(getSilinecek_id()));

            myObject.executeUpdate();
            return "admin"; 
        } 
        finally {
            //conn.close(); 
        } 
    } 
}
