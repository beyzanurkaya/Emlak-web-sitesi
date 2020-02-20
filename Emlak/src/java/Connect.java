import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

    /**
     *
     * @return
     */
    public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:derby://localhost:1527/emlak", "APP", "APP");
                        
			return con;
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->"
					+ ex.getMessage());
                        System.out.print("aa");
			return null;
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}
