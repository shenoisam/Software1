package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
	private Connection con; 

	public SQLConnection(String db, String host, int port, String username, String password) {
		String url = "jdbc:mysql://" + host + ":" + port + "/" + db; 
		try {
			con = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}

}
