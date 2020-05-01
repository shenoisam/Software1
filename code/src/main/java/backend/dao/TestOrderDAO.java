package backend.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import backend.classes.Test;
import backend.classes.TestOrder;
import backend.factory.FactoryObjects;
import backend.factory.TestOrderObject;

/**
 * TestOrderDAO connects to the TestOrder table in the database
 * 
 * 
 * @author samshenoi
 *
 */
public class TestOrderDAO extends GenericDAO {
    public TestOrderDAO(){
    	
    }

    /**
     * Inserts into TestOrder
     * 
     * @see GenericDAO#insertIntoTable(String[], String[])
     */
	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		for(int i =0; i < fields.length;i++) {
			if (fields[i].contentEquals("DateVal")) {
				params[i] = new java.sql.Date(new java.util.Date(params[i]).getTime()).toString();
			}
		}
		
		this.insert("TestOrder", fields, params);
		
	}
	
	/**
	 * deletes from the testorder table
	 * 
	 * @see GenericDAO#deleteFromTable(String[], String[])
	 */
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {		
		this.delete("TestOrder", fields, params);
	}
	

	/**
	 * gets data from TestOrder
	 * 
	 * @see GenericDAO#getData(String[], String[])
	 */
	public List<TestOrder> getData(String [] fields, String [] params) {
		 String rmStr = this.generateRmStr(fields, params);
		 
		 List<List<Object>> stuff = this.query("*", "TestOrder", rmStr, params);
		 //FactoryObjects<TestOrder> factoryObj = new TestOrderObject();
		 return generateList(stuff);
		
	 }
		
	private List<TestOrder> generateList(List<List<Object>> stuff) {
		 List<TestOrder> finalList = new ArrayList<TestOrder>(); 
		 List<String> headerRow = listToString(stuff.get(0));
		 for(int i = 1; i < stuff.size(); i++) {
			 //TODO: implement this; 
			 finalList.add(new TestOrder(headerRow, stuff.get(i)));
		 }
		 
		 return finalList;
	}


	/**
	 * updates TestOrder
	 * 
	 * @see GenericDAO#updateTable(String[], String[], String[], String[])
	 */
	@Override
	public void updateTable(String[] setFields, String[] setParams, String[] fields, String[] params)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}


}
