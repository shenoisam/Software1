package backend.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import backend.classes.Test;
import backend.classes.TestOrder;
import backend.factory.FactoryObjects;
import backend.factory.TestOrderObject;

public class TestOrderDAO extends GenericDAO {
    public TestOrderDAO(){
    	
    }

	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		for(int i =0; i < fields.length;i++) {
			if (fields[i].contentEquals("DateVal")) {
				params[i] = new java.sql.Date(new java.util.Date(params[i]).getTime()).toString();
			}
		}
		
		this.insert("TestOrder", fields, params);
		
	}
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {		
		this.delete("TestOrder", fields, params);
	}
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


	@Override
	public void updateTable(String[] setFields, String[] setParams, String[] fields, String[] params)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}


}
