package backend.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.NotImplementedException;
import backend.classes.Appointment;
import backend.classes.Notes;

public class NotesDAO extends GenericDAO {
    public NotesDAO(){
    	
    }
	@Override
	public void updateTable(String[] fields, String[] params) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Notes> getNotes(String [] fields, String [] params) throws NotImplementedException{
		 String rmStr = this.generateRmStr(fields, params);
		 List<List<Object>> stuff = this.query("*", "Appointment", rmStr, params);
		 return generateList(stuff);
		
	 }
	
	private List<Notes> generateList(List<List<Object>> stuff) throws NotImplementedException{
		 List<Notes> finalList = new ArrayList<Notes>(); 
		 for(int i = MIN_DATA_SIZE; i < stuff.size(); i++) {
			 //TODO: implement this; 
			 finalList.add(new Notes(stuff.get(MIN_DATA_SIZE), stuff.get(i)));
		 }
		 
		 return finalList;
	}
	

	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		this.insert("Notes", fields, params);
		
	}
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {		
		this.delete("Notes", fields, params);
	}

}
