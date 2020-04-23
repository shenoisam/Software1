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
	public void updateTable(String[] fields, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		this.insert("Test", fields, params);
		
	}
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {		
		this.delete("Test", fields, params);
	}
	
	public List<Test> getAppointments(String [] fields, String [] params) {
		 String rmStr = this.generateRmStr(fields, params);
		 
		 List<List<Object>> stuff = this.query("*", "Notes", rmStr, params);
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

}
