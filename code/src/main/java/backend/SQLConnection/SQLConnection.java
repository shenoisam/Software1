
package backend.SQLConnection;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import backend.Config;
import frontend.EHRRunner;

/**
 * Defines a class that allows for a single connection to the mysql database
 * 
 * 
 * @author samshenoi
 *
 */
public class SQLConnection {

	 /**      
	  *  returns a set up connection for connecting to the database 
	  *  
	  *  @param db the database being connected to    
	  *  @param host the hostname of the database 
	  *  @param port the port of the database 
	  *  @param the username used to log into the database 
	  *  @param the password used to log into the database   
	  *  @return N/A
	  *            
	  **/ 
	public static Connection setUpConnection(String db, String host, int port, String username, String password) {
		// Get the connection url. Have to add some parameters to the end because of some timezone issue. 
				String url = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; 
				Connection con = null; 
				try {
					con = DriverManager.getConnection(url,"root","seven725");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Error: Can't connect. Is your mysql server running?");
					e.printStackTrace();
				}  
				return con; 
	}
	
}
