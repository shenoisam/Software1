package backend.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.classes.Notes;
import backend.classes.PatientDiagnosis;
import backend.factory.FactoryObjects;
import backend.factory.PatientDiagnosisObject;

public class PatientDiagnosisDAO extends GenericDAO {
    public PatientDiagnosisDAO(){
    	
    }


	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		this.insert("PatientDiagnosis", fields, params);
		
	}
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {		
		this.delete("PatientDiagnosis", fields, params);
	}
	
	
	public List<PatientDiagnosis> getData(String [] fields, String [] params) {
		 String rmStr = this.generateRmStr(fields, params);
		 
		 List<List<Object>> stuff = this.query("*", "PatientDiagnosis", rmStr, params);
		 //FactoryObjects<PatientDiagnosis> factoryObj = new PatientDiagnosisObject();
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




	@Override
	public void updateTable(String[] setFields, String[] setParams, String[] fields, String[] params)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
