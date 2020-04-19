package backend.dao;

import java.sql.SQLException;

public class TestResultDAO extends GenericDAO {
    public TestResultDAO(){
    	
    }
	@Override
	public void updateTable(String[] fields, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		this.insert("TestResult", fields, params);
		
	}
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {		
		this.delete("TestResult", fields, params);
	}

}
