package backend.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.NotImplementedException;
import backend.classes.Diagnosis;

/**
 * Defines a Database Access Object (DAO) specific for connecting to the Diagnosis Table 
 * 
 * 
 * @author samshenoi
 *
 */
public class DiagnosisDAO extends GenericDAO{

	public DiagnosisDAO(){
		super();
	}
	
	/*
	 * updates the Diagnosis table 
	 * 
	 * @see GenericDAO#updateTable
	 */
	@Override
	public void updateTable(String[] fields, String[] params) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * inserts into the Diagnosis table 
	 * 
	 * @see GenericDAO#insertIntoTable
	 */
	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		this.insert("Diagnosis", fields, params);
		
	}
	
	
	/*
	 * deletes from the Diagnosis table 
	 * 
	 * @see GenericDAO#deleteFromTable
	 */
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {		
		this.delete("Diagnosis", fields, params);
	}
	
	public List<Diagnosis> getDiagnosis(String [] fields, String [] params) throws NotImplementedException {
		String rmStr = this.generateRmStr(fields, params);
		
		List<List<Object>> vals = this.query("*", "Diagnosis", rmStr, params);
		List<Diagnosis> d = new ArrayList<Diagnosis>(); 
		if (vals.size() > MIN_DATA_SIZE) {
			//Get the header row. The first row returned should be the header row
			List<Object> header = vals.get(0);
			List<String> headerRow  = new ArrayList<String> (); 
			
			for (Object h: header) {
				headerRow.add(h.toString());
			}
			for(int i = MIN_DATA_SIZE; i < vals.size(); i++) {
				d.add(new Diagnosis(headerRow, vals.get(i)));
			}
		}
		return d;
		
		
	}

}
