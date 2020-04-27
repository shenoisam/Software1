package backend.SQLConnection;

import java.sql.Connection;

/**
 * Defines an interface for a database connection pool 
 * 
 * 
 * @author samshenoi
 *
 */
public interface ConnectionPool {
	Connection getConnection();
    boolean releaseConnection(Connection connection);
}
