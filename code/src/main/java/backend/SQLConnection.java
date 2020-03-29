
package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
		String url = "jdbc:mysql://" + host + ":" + port + "/" + db; 
		try {
			con = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}

}
