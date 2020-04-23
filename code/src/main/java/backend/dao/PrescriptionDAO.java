package backend.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.classes.PatientDiagnosis;
import backend.classes.Perscription;

public class PrescriptionDAO extends GenericDAO {
    PrescriptionDAO(){
    	
    }
	@Override
	public void updateTable(String[] fields, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		this.insert("Prescription", fields, params);
		
	}
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {		
		this.delete("Prescription", fields, params);
	}
	
	public List<Perscription> getAppointments(String [] fields, String [] params) {
		 String rmStr = this.generateRmStr(fields, params);
		 
		 List<List<Object>> stuff = this.query("*", "Notes", rmStr, params);
		 return generateList(stuff);
		
	 }
		
	private List<Perscription> generateList(List<List<Object>> stuff) {
		 List<Perscription> finalList = new ArrayList<Perscription>(); 
		 List<String> headerRow = listToString(stuff.get(0));
		 for(int i = 1; i < stuff.size(); i++) {
			 //TODO: implement this; 
			 finalList.add(new Perscription(headerRow, stuff.get(i)));
		 }
		 
		 return finalList;
	}

}
