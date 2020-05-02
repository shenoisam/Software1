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
    /**
     * returns a singlar SQLConnectionPool object. Connects to the database
     * 
     * @return the SQLConnectionPool object
     */
	public static SQLConnectionPool create() {
		 // Get all of the database configuration information from the config object
		 Config m = new Config(); 
		 List<Connection> p  = new ArrayList<Connection>();
		 
		 //Create 10 connections to start off with
		 for (int i =0; i < INITIAL_POOL_SIZE; i++) {
			 p.add(SQLConnection.setUpConnection(m.getProperty("db"),m.getProperty("host"),Integer.parseInt(m.getProperty("port")),"CShareAdmin","password"));
		 } 
		 return new SQLConnectionPool(p);
		 
	}
	
	/**
	 * returns 1 of 10 database connections. Ensures that only a limited number of connections are created 
	 * 
	 * @return a Connection object
	 */
	public Connection getConnection() {
		Connection con = pool.remove(pool.size() -1);
		usedConnections.add(con);
		return con;
	}
	
    /**
     * releases a connection back into the pool 
     * 
     *  @param connection a connection to be released back into the pool
     *  @return returns a boolean value indicating success or failure
     */
	public boolean releaseConnection(Connection connection) {
		pool.add(connection);
		return usedConnections.remove(connection);
	}


}
