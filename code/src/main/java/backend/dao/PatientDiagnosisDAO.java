package backend.dao;

import java.sql.SQLException;

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

}
