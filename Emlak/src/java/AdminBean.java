import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@ManagedBean(name="admin")
@SessionScoped
public class AdminBean implements Serializable{
 
	//resource injection
	@Resource(name="jdbc:derby://localhost:1527/emlak")
	private DataSource ds;
	

	public List<Admin> getAdminList() throws SQLException{
		
		if(ds==null)
			throw new SQLException("Can't get data source");
		
		//get database connection
		Connection con = ds.getConnection();
		
		if(con==null)
			throw new SQLException("Can't get database connection");
		System.out.println("aaaaaaaa");
		PreparedStatement ps 
			= con.prepareStatement(
			   " SELECT ID, AD, SOYAD, TELEFON, MAIL, SIFRE FROM APP.KULLANICILAR "); 
                System.out.println("aaaaaaaa");
		
		//get customer data from database
		ResultSet result =  ps.executeQuery();
		
		List<Admin> list = new ArrayList<Admin>();
		
		while(result.next()){
			Admin cust = new Admin();
			
			cust.setId(result.getString("id"));
			cust.setAd(result.getString("ad"));
			cust.setSoyad(result.getString("soyad"));
			cust.setTelefon(result.getString("telefon"));
                        cust.setMail(result.getString("mail"));
                        cust.setSifre(result.getString("sifre"));
			
			//store all data into a List
			list.add(cust);
		}
			
		return list;
	}
}
