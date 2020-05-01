package backend.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.classes.Perscription;
import backend.classes.Test;
import backend.factory.FactoryObjects;
import backend.factory.TestObject;

/**
 * TestDAO connects to the Test table in the database
 * 
 * 
 * @author samshenoi
 *
 */
public class TestDAO extends GenericDAO {
    public TestDAO(){
    	
    }


    /**
     * Inserts into Test
     * 
     * @see GenericDAO#insertIntoTable(String[], String[])
     */
	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		this.insert("Test", fields, params);
		
	}
	
	/**
	 * deletes from the test table
	 * 
	 * @see GenericDAO#deleteFromTable(String[], String[])
	 */
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {		
		this.delete("Test", fields, params);
	}
	

	/**
	 * gets data from Test
	 * 
	 * @see GenericDAO#getData(String[], String[])
	 */
	public List<Test> getData(String [] fields, String [] params) {
		 String rmStr = "";
		 if(fields.length > 0) {
		   rmStr =  this.generateRmStr(fields, params);
		 }

		 List<List<Object>> stuff = this.query("*", "Test", rmStr, params);
		 //FactoryObjects<Test> factoryObj = new TestObject();
		 return generateList(stuff);
		
	 }
		
	private List<Test> generateList(List<List<Object>> stuff) {
		 List<Test> finalList = new ArrayList<Test>(); 
		 List<String> headerRow = listToString(stuff.get(0));
		 for(int i = 1; i < stuff.size(); i++) {
			 //TODO: implement this; 
			 finalList.add(new Test(headerRow, stuff.get(i)));
		 }
		 
		 return finalList;
	}

	/**
	 * updates Test
	 * 
	 * @see GenericDAO#updateTable(String[], String[], String[], String[])
	 */
	@Override
	public void updateTable(String[] setFields, String[] setParams, String[] fields, String[] params)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
