package backend.SQLConnection;

/**
 * Defines a class that forces the creation of only one pooled connection object
 * 
 * 
 * @author samshenoi
 *
 */
public class SQLConnectionPoolFactory {
	private static SQLConnectionPool p; 
	/**
	 * ensures that only one SQLConnectionPool is created per app 
	 * 
	 * @return a SQLConnectionPool object
	 */
	public static SQLConnectionPool getPool() {
		if (p == null) {
			p = SQLConnectionPool.create();
		}
		return p; 
	}

}
