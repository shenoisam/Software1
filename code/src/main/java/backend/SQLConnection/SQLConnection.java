
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
					con = DriverManager.getConnection(url,username,password);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Error: Can't connect. Is your mysql server running?");
					e.printStackTrace();
				}  
				return con; 
	}
	

	
	/*
	protected ResultSet executeStatement(String query) {
		ResultSet res = null; 
		Statement stmt = null; 
		try {
			  stmt = con.createStatement();
			  res = stmt.executeQuery(query);
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		}
		return res; 
	}
	
	public ResultSet query(String select,String table,  String rmStr) {
		String query = "SELECT " + select + " FROM " + table;
		if (rmStr.length() > 0) {
			query = query + " WHERE " + rmStr;
		}
		return executeStatement(query);
	}
	
	//Adapted from: https://stackoverflow.com/questions/192078/how-do-i-get-the-size-of-a-java-sql-resultset
	public int resultSize(ResultSet r) {
		int rowcount = 0; 
		try {
			if (r.last()) {
				rowcount = r.getRow(); 
				r.beforeFirst(); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowcount; 
	}
	*/
   
	
	

}
