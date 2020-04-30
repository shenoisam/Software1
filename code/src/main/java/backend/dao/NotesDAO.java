package backend.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.classes.Appointment;
import backend.classes.Notes;
import backend.factory.FactoryObjects;
import backend.factory.NotesObject;

public class NotesDAO extends GenericDAO {
    public NotesDAO(){
    	
    }


	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		for(int i =0; i < fields.length;i++) {
			if (fields[i].contentEquals("DateVal")) {
				params[i] = new java.sql.Date(new java.util.Date(params[i]).getTime()).toString();
			}
		}
		this.insert("Notes", fields, params);
		
	}
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {		
		this.delete("Notes", fields, params);
	}
	
	public List<Notes> getData(String [] fields, String [] params) {
		 String rmStr = this.generateRmStr(fields, params);
		 
		 List<List<Object>> stuff = this.query("*", "Notes", rmStr, params);
		 FactoryObjects<Notes> factoryObj = new NotesObject();
		 return generateList(stuff);
		
	 }
		
	private List<Notes> generateList(List<List<Object>> stuff) {
		 List<Notes> finalList = new ArrayList<Notes>(); 
		 List<String> headerRow = listToString(stuff.get(0));
		 for(int i = 1; i < stuff.size(); i++) {
			 //TODO: implement this; 
			 finalList.add(new Notes(headerRow, stuff.get(i)));
		 }
		 
		 return finalList;
	}

	@Override
	public void updateTable(String[] setFields, String[] setParams, String[] fields, String[] params)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
