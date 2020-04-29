package backend.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.classes.Test;
import backend.classes.TestOrder;

public class TestOrderDAO extends GenericDAO {
    public TestOrderDAO(){
    	
    }
	@Override
	public void updateTable(String[] fields, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		this.insert("TestOrder", fields, params);
		
	}
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {		
		this.delete("TestOrder", fields, params);
	}
	public List<TestOrder> getData(String [] fields, String [] params) {
		 String rmStr = this.generateRmStr(fields, params);
		 
		 List<List<Object>> stuff = this.query("*", "Notes", rmStr, params);
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


}
