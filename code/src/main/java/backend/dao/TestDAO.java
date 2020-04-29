package backend.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.classes.Perscription;
import backend.classes.Test;

public class TestDAO extends GenericDAO {
    public TestDAO(){
    	
    }


	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		this.insert("Test", fields, params);
		
	}
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {		
		this.delete("Test", fields, params);
	}
	
	public List<Test> getData(String [] fields, String [] params) {
		 String rmStr = "";
		 if(fields.length > 0) {
		   rmStr =  this.generateRmStr(fields, params);
		 }

		 List<List<Object>> stuff = this.query("*", "Test", rmStr, params);
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

	@Override
	public void updateTable(String[] setFields, String[] setParams, String[] fields, String[] params)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
