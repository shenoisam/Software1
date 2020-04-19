package backend.dao;

import java.sql.SQLException;

public class TestOrderDAO extends GenericDAO {
    public TestOrderDAO(){
    	
    }
	@Override
	public void updateTable(String[] fields, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		this.insert("TestOrder", fields, params);
		
	}
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {		
		this.delete("TestOrder", fields, params);
	}

}
