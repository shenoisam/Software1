package backend.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.classes.Notes;
import backend.classes.PatientDiagnosis;

public class PatientDiagnosisDAO extends GenericDAO {
    PatientDiagnosisDAO(){
    	
    }
	@Override
	public void updateTable(String[] fields, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		this.insert("PatientDiagnosis", fields, params);
		
	}
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {		
		this.delete("PatientDiagnosis", fields, params);
	}
	
	
	public List<PatientDiagnosis> getAppointments(String [] fields, String [] params) {
		 String rmStr = this.generateRmStr(fields, params);
		 
		 List<List<Object>> stuff = this.query("*", "Notes", rmStr, params);
		 return generateList(stuff);
		
	 }
		
	private List<PatientDiagnosis> generateList(List<List<Object>> stuff) {
		 List<PatientDiagnosis> finalList = new ArrayList<PatientDiagnosis>(); 
		 List<String> headerRow = listToString(stuff.get(0));
		 for(int i = 1; i < stuff.size(); i++) {
			 //TODO: implement this; 
			 finalList.add(new PatientDiagnosis(headerRow, stuff.get(i)));
		 }
		 
		 return finalList;
	}

}
