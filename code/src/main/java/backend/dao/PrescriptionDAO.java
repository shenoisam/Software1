package backend.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.classes.PatientDiagnosis;
import backend.classes.Perscription;
import backend.factory.FactoryObjects;
import backend.factory.PerscriptionObject;

public class PrescriptionDAO extends GenericDAO {
    public PrescriptionDAO(){
    	
    }
	/*@Override
	public void updateTable(String[] fields, String[] params) {
		// TODO Auto-generated method stub
		
	}*/

	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		for(int i =0; i < fields.length;i++) {
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
		 //PerscriptionObject pObj = new PerscriptionObject();
		 FactoryObjects<Perscription> factoryObj = new PerscriptionObject();
		 return super.generateList(stuff, factoryObj);
	 }
		

	
	@Override
	public void updateTable(String[] setFields, String[] setParams, String[] fields, String[] params)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
