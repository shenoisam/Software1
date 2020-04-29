package backend.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.classes.PatientDiagnosis;
import backend.classes.Perscription;

public class PrescriptionDAO extends GenericDAO {
    public PrescriptionDAO(){
    	
    }


	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		for(int i = 0; i < fields.length;i++) {
			if (fields[i].contentEquals("DateVal")) {
				params[i] = new java.sql.Date(new java.util.Date(params[i]).getTime()).toString();
			}
		}
		
		this.insert("Prescription", fields, params);
		
	}
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {		
		this.delete("Prescription", fields, params);
	}
	
	public List<Perscription> getData(String [] fields, String [] params) {
		 String rmStr = this.generateRmStr(fields, params);
		 
		 List<List<Object>> stuff = this.query("*", "Prescription", rmStr, params);
		 System.out.println(stuff.size());
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



	@Override
	public void updateTable(String[] setFields, String[] setParams, String[] fields, String[] params)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}
	

}
