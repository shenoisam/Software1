package backend.SQLConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import backend.Config;

/**
 * Defines a class that allows for a pooled connection to the mysql database
 *  based of the code provided at: https://www.baeldung.com/java-connection-pooling
 * 
 * @author samshenoi
 *
 */
public class SQLConnectionPool implements ConnectionPool {
    private List<Connection> pool;
    private List<Connection> usedConnections; 
    private static int INITIAL_POOL_SIZE = 10; 
    
    
    // Define the connection pool as private so that it can only be called by the create method
    private SQLConnectionPool(List<Connection> start) {
    	this.pool = start; 
    	usedConnections = new ArrayList<Connection>();
    }
    
	public static SQLConnectionPool create() {
		 // Get all of the database configuration information from the config object
		 Config m = new Config(); 
		 List<Connection> p  = new ArrayList<Connection>();
		 
		 //Create 10 connections to start off with
		 for (int i =0; i < INITIAL_POOL_SIZE; i++) {
			 p.add(SQLConnection.setUpConnection("Cshare","localhost",3306,"CShareAdmin","password"));
		 } 
		 return new SQLConnectionPool(p);
		 
	}
	
	public Connection getConnection() {
		Connection con = pool.remove(pool.size() -1);
		usedConnections.add(con);
		return con;
	}

	public boolean releaseConnection(Connection connection) {
		pool.add(connection);
		return usedConnections.remove(connection);
	}


}
