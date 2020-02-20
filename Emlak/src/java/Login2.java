import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
 * @author Özcan
 */
public class Login2 implements Serializable{

    public static boolean validate(String ad,String sifre) {
    
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
                   
                     System.out.println("DB DB DB DB");
                  
                PreparedStatement  ps =conn.prepareStatement("SELECT AD, SIFRE FROM APP.KULLANICILAR WHERE AD ='"+ad+"' AND SIFRE='"+sifre+"'");
                    System.out.println("STATEMENT ALDIII "+ps);
                 
			ResultSet rs = ps.executeQuery();
                     System.out.println("ResulSet ALDIII "+rs);
                     System.out.println("ResulSet ALDIII "+rs);
                      System.out.println("ResulSet ALDIII "+rs);
			if (rs.next()) {
                                return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			
                        return false;
		} finally {
		       // conn.close();
		}
		return false;
	}
    
    
    /*public String validate() throws SQLException{
        // check whether dataSource was injected by the server
       if (dataSource == null) {
            throw new SQLException("Unable to obtain DataSource");
        }

        // obtain a connection from the connection pool
        

        // check whether connection was successful
      Connection connection = dataSource.getConnection();  
      if (connection == null) {
            throw new SQLException("Unable to connect to DataSource");
        }

        try {
            PreparedStatement deneme = connection.prepareStatement("SELECT AD,SİFRE FROM APP.KULLANICILAR WHERE AD=? AND SİFRE=? ");
            deneme.setString(1, ad);
            deneme.setString(2, sifre);
            // create a PreparedStatement to insert a new address book entry
            ResultSet rs = deneme.executeQuery();

            if (rs.next()) {

                return "welcome";
            } else {

                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Geçersiz ya da yanlış kullanıcı girişi", "lütfen kontrol ediniz");
                FacesContext.getCurrentInstance().addMessage(null, msg);

                return "login";
            }
        } finally {
            connection.close(); // return this connection to pool
        }

    }*/

    /*static boolean ekle(String ad, String soyad, String sifre, String mail, String telefon) {
    

    try {         
		  try {
                  Class.forName("com.mysql.jdbc.Driver");
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, "baglantı sikintisi");
              }
              
    
              Connection conn = null;
              
                  conn = DriverManager.getConnection("jdbc:derby://localhost:1527/emlak", "APP", "APP");
              } catch (SQLException ex) {
                  Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, "baglanti sikintisi");
              }
               try{
                PreparedStatement  ps =conn.prepareStatement("INSERT INTO APP.KULLANICILAR (AD, SOYAD, SIFRE, TELEFON, MAIL) VALUES('"+ad+"', '"+soyad+"', '"+sifre+"', '"+telefon+"', '"+mail+"');");
                    System.out.println("STATEMENT ALDIII "+ps);
                 
			ResultSet rs = ps.executeQuery();
              
			if (rs.next()) {
				//result found, means valid inputs
				
                                return true;
                               
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			
                        return false;
		} finally {
		//	conn.close();
		}
              
		return false;
                
	}*/

   
}

