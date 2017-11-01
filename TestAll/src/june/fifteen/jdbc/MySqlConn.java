package june.fifteen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @date 2017-06-16
 */
public class MySqlConn {
	
	public Connection conn2MySql()
	{
		Long usetime = System.nanoTime();
		Connection conn = null;
//		System.out.println("nanotime is : " + usetime);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			
			String url = "jdbc:mysql://localhost:3306/self";
			String name = "root";
			String password = "";
			
			conn = DriverManager.getConnection(url, name, password);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("build connection consume " + 1.0*(System.nanoTime() - usetime)/1000000000.0 + " s");
		return conn;
	}
}
