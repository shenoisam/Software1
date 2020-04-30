package backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSetMetaData;

import backend.NotImplementedException;
import backend.SQLConnection.SQLConnectionPool;
import backend.SQLConnection.SQLConnectionPoolFactory;
import backend.classes.Perscription;
import backend.factory.FactoryObjects;

/**
 * Defines a generic Database Access Object (DAO) specific for connecting to a table; 
 * 
 * 
 * @author samshenoi
 *
 */
public abstract class GenericDAO {
	SQLConnectionPool pool; 
	protected int MAX_SINGLET_DATA_SIZE = 3; 
	protected int MIN_DATA_SIZE = 1; 
	protected GenericDAO(){
		pool = SQLConnectionPoolFactory.getPool();
	}
	
	private String generateQueryString(String select, String table, String rmStr) {
		String query; 
		query = "SELECT " + select + " FROM " + table;
		
	    query = query + rmStr + ";";

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
		    System.out.println(p.toString());
		    
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
		    rs.close(); 
		    p.close();
		    pool.releaseConnection(c);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return data; 
		
		
	}
	/*private List<Perscription> generateList(List<List<Object>> stuff) {
		 List<Perscription> finalList = new ArrayList<Perscription>(); 
		 List<String> headerRow = listToString(stuff.get(0));
		 for(int i = 1; i < stuff.size(); i++) {
			 //TODO: implement this; 
			 finalList.add(new Perscription(headerRow, stuff.get(i)));
		 }
		 
		 return finalList;
	}*/
	protected <T>List<T> generateListObjects(List<List<Object>> stuff, FactoryObjects<T> object) {
		 List<T> finalList = new ArrayList<T>(); 
		 List<String> headerRow = listToString(stuff.get(0));
		 for(int i = 1; i < stuff.size(); i++) {
			 //TODO: implement this; 
			 finalList.add(object.generateObject(headerRow, stuff.get(i)));
		 }
		 
		 return finalList;
	}

	protected void update(String table, String [] fields,String rmStr,String [] params) throws SQLException {
		Connection con = pool.getConnection();
		String update = "UPDATE " + table + " SET " + generateRmStr(fields, params) + "WHERE " + rmStr; 

		PreparedStatement p = con.prepareStatement(update);
	    for(int i = 0; i < params.length; i++) {
	    	p.setString(i +1, params[i]);
	    }
	    p.executeUpdate(); 
	
		
		
		pool.releaseConnection(con);
		//TODO: Fix this. 
		
		
		
	}

	protected void delete(String table, String [] fields, String [] params) throws SQLException {
		String rmStr = ""; 
		for ( int i = 0; i < fields.length - 1; i++) {
			rmStr = rmStr  + fields[i] + " = ? AND ";
		}
		rmStr = rmStr  + fields[fields.length -1] + " = ?";
		String delete = "DELETE FROM " + table + " WHERE " + rmStr; 
		dbConnect(delete, params);	
		
	}

	protected List<String> listToString(List<Object> l){
		List<String> s = new ArrayList<String>(); 
		for (Object obj: l) {
			s.add(obj.toString());
		}
		return s; 
	}
	
	protected void insert(String table, String [] fields, String [] params) throws SQLException {
		//Generate the query 
		String in = "INSERT INTO " + table + " ("; 
		assert(params.length == fields.length);
		for(int i =0; i < fields.length -1 ; i++) {
			in = in + fields[i] + ", ";
		}
		in = in + fields[fields.length -1] + ") VALUES (";
		for(int i =0; i < params.length -1 ; i++) {
			in = in + "?, ";
		}
		in = in + "?)";
		
		
		
		//Preform the action 
		dbConnect(in, params);

	}
	
	private void dbConnect(String query, String [] params) throws SQLException {
		Connection c = pool.getConnection();

		PreparedStatement p = c.prepareStatement(query);
	    for(int i =0; i < params.length; i++) {
	    	p.setString(i +1, params[i]);
	    }
	    p.executeUpdate();
	    //TODO: Check to see if I need to call commit on the database object...
	
		pool.releaseConnection(c);
	}
	
	protected String generateRmStr(String [] fields, String [] params) {
		String rmStr = " WHERE ";
		 
		 for (int i =0; i < fields.length - 1; i++) {
			 rmStr = rmStr +" " + fields[i] + " = ? AND"; 
		 }
		 if (fields.length > 0) {
			 rmStr = rmStr + fields[fields.length -1] + " = ? ";
		 }
		 return rmStr;
	}
	
	//Should return a List<Backend.class>, not sure how to genericify that. 
	//public abstract List<Object> getTableValues(String [] fields, String [] params);
	
	
	
	
	/*
	 * inserts a row into a table in the database
	 * 
	 * @param fields the fields in question for this specific table 
	 * @param params the parameters to insert into this table
	 * 
	 */
	public abstract void insertIntoTable(String [] fields, String [] params) throws SQLException;
	
	/*
	 * deletes a row in the database based on given parameters
	 * 
	 * @param fields the fields in question for this specific table 
	 * @param params the parameters to match for deletion for this specific table
	 * 
	 */
	public abstract void deleteFromTable(String [] fields, String [] params) throws SQLException;
	public abstract  <T> List<T> getData(String [] fields, String [] params);

	
	/*
	 * updates a table in the database
	 * 
	 * @param fields the fields in question for this specific table the rmStr 
	 * @param params the parameters to insert into this table for the rmStr 
	 * @param setFields the fields to be set 
	 * @param setParams the parameters to be set
	 * 
	 */
	public abstract void updateTable(String[] setFields, String[] setParams, String [] fields, String[] params) throws SQLException;


}
