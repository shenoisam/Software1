package backend.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.classes.PatientDiagnosis;
import backend.classes.Perscription;
import backend.factory.FactoryObjects;
import backend.factory.PerscriptionObject;
/**
 * PrescriptionDAO connects to the Prescription table in the database
 * 
 * 
 * @author samshenoi
 *
 */
public class PrescriptionDAO extends GenericDAO {
    public PrescriptionDAO(){
    	
    }
	/*@Override
	public void updateTable(String[] fields, String[] params) {
		// TODO Auto-generated method stub
		
	}*/

    /**
     * Inserts into Prescription
     * 
     * @see GenericDAO#insertIntoTable(String[], String[])
     */
	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		for(int i =0; i < fields.length;i++) {
			if (fields[i].contentEquals("DateVal")) {
				params[i] = new java.sql.Date(new java.util.Date(params[i]).getTime()).toString();
			}
		}
		this.insert("Prescription", fields, params);
		
	}
	
	/**
	 * deletes from the prescription table
	 * 
	 * @see GenericDAO#deleteFromTable(String[], String[])
	 */
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {		
		this.delete("Prescription", fields, params);
	}
	

	/**
	 * gets data from Prescription
	 * 
	 * @see GenericDAO#getData(String[], String[])
	 */
	public List<Perscription> getData(String [] fields, String [] params) {
		 String rmStr  = "";
		 if (fields.length > 0) {rmStr = this.generateRmStr(fields, params);}
		 
		 List<List<Object>> stuff = this.query("*", "Prescription", rmStr, params);
		 //PerscriptionObject pObj = new PerscriptionObject();
		 //FactoryObjects<Perscription> factoryObj = new PerscriptionObject();
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
	
	/**
	 * updates Prescription
	 * 
	 * @see GenericDAO#updateTable(String[], String[], String[], String[])
	 */
	@Override
	public void updateTable(String[] setFields, String[] setParams, String[] fields, String[] params)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
