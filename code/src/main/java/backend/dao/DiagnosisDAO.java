package backend.dao;

import java.sql.SQLException;

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

}
