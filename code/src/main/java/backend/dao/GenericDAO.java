package backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSetMetaData;

import backend.SQLConnection.SQLConnectionPool;
import backend.SQLConnection.SQLConnectionPoolFactory;

public class GenericDAO {
	SQLConnectionPool pool; 
	protected int MAX_SINGLET_DATA_SIZE = 3; 
	protected int MIN_DATA_SIZE = 1; 
	protected GenericDAO(){
		pool = SQLConnectionPoolFactory.getPool();
	}
	
	private String generateQueryString(String select, String table, String rmStr) {
		String query; 
		query = "SELECT " + select + " FROM " + table +" WHERE " + rmStr + ";";
		return query; 
	}
	protected List<List<Object>> query(String select, String table, String rmStr,String [] params) {
		Connection c = pool.getConnection();
		String query = generateQueryString(select,table,rmStr);
		 //Create a generic table to return from this function 
	    List<List<Object>> data = new ArrayList<List<Object>>();
		try {
			PreparedStatement p = c.prepareStatement(query);
		    for(int i =0; i < params.length; i++) {
		    	p.setString(i +1, params[i]);
		    }
		   
		    ResultSet rs = p.executeQuery();
		   
		    
		    List<Object> columnNames = new ArrayList<Object>();
		    
		    //Get the rows of teh table 
		    ResultSetMetaData rsmd = rs.getMetaData();
		    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
		        columnNames.add(rsmd.getColumnLabel(i));
		    }
		    
		    data.add(columnNames);
		    while (rs.next()) {
		    	List<Object> row = new ArrayList<Object>(); 
		    	for (int i = 1; i <= rsmd.getColumnCount(); i++) {
		    	        row.add(rs.getObject(i));
		    	}
		    	data.add(row);
		    }
		    p.close();
		    pool.releaseConnection(c);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return data; 
		
		
	}

}
