
package backend;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import frontend.EHRRunner;

/**
 * Defines a class that allows for connection to the database using java derby 
 * 
 * 
 * @author samshenoi
 *
 */
public class SQLConnection {
	private Connection con; 
	 /**      
	  *  Default constructor for connecting to the database 
	  *  
	  *  @param db the database being connected to    
	  *  @param host the hostname of the database 
	  *  @param port the port of the database 
	  *  @param the username used to log into the database 
	  *  @param the password used to log into the database   
	  *  @return N/A
	  *            
	  **/ 
	public SQLConnection(String db, String host, int port, String username, String password) {
		// Get the connection url. Have to add some parameters to the end because of some timezone issue. 
		String url = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; 
		try {
			con = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: Can't connect. Is your mysql server running?");
			e.printStackTrace();
		}  
		
	}
	public static void main(String[] args) {
		Config m = new Config(); 
	
		SQLConnection q = new SQLConnection(m.getProperty("db"),m.getProperty("host"),Integer.parseInt(m.getProperty("port")),m.getProperty("user"),m.getProperty("password"));
	}
	

}
