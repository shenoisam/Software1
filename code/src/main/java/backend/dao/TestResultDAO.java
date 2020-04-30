package backend.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.classes.Test;
import backend.classes.TestResult;
import backend.factory.FactoryObjects;
import backend.factory.TestResultObject;

public class TestResultDAO extends GenericDAO {
    public TestResultDAO(){
    	
    }

	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		for(int i =0; i < fields.length;i++) {
			if (fields[i].contentEquals("DateVal")) {
				params[i] = new java.sql.Date(new java.util.Date(params[i]).getTime()).toString();
			}
		}
		this.insert("TestResult", fields, params);
		
	}
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {		
		this.delete("TestResult", fields, params);
	}
	public List<TestResult> getData(String [] fields, String [] params) {
		 String rmStr = this.generateRmStr(fields, params);
		 
		 List<List<Object>> stuff = this.query("*", "TestResult", rmStr, params);
		 FactoryObjects<TestResult> factoryObj = new TestResultObject();
		 return super.generateListObjects(stuff, factoryObj);
		
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

	@Override
	public void updateTable(String[] setFields, String[] setParams, String[] fields, String[] params)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}


}
