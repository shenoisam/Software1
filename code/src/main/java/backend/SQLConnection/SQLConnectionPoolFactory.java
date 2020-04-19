package backend.SQLConnection;

/**
 * Defines a class that forces the creation of only one pooled connection object
 * I think this uses one of the design patterns so go team!
 * 
 * @author samshenoi
 *
 */
public class SQLConnectionPoolFactory {
	private static SQLConnectionPool p; 
	
	public static SQLConnectionPool getPool() {
		if (p == null) {
			p = SQLConnectionPool.create();
		}
		return p; 
	}

}
