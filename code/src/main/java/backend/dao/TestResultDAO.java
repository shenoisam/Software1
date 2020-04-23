package backend.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.classes.Test;
import backend.classes.TestResult;

public class TestResultDAO extends GenericDAO {
    public TestResultDAO(){
    	
    }
	@Override
	public void updateTable(String[] fields, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		this.insert("TestResult", fields, params);
		
	}
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {		
		this.delete("TestResult", fields, params);
	}
	public List<TestResult> getAppointments(String [] fields, String [] params) {
		 String rmStr = this.generateRmStr(fields, params);
		 
		 List<List<Object>> stuff = this.query("*", "Notes", rmStr, params);
		 return generateList(stuff);
		
	 }
		
	private List<TestResult> generateList(List<List<Object>> stuff) {
		 List<TestResult> finalList = new ArrayList<TestResult>(); 
		 List<String> headerRow = listToString(stuff.get(0));
		 for(int i = 1; i < stuff.size(); i++) {
			 //TODO: implement this; 
			 finalList.add(new TestResult(headerRow, stuff.get(i)));
		 }
		 
		 return finalList;
	}


}
