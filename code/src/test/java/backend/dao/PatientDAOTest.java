package backend.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.junit.runners.MethodSorters;

import backend.SQLConnection.SQLConnectionPoolFactory;
import backend.classes.Patient;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.FixMethodOrder;
import java.util.Date;
import java.util.List;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PatientDAOTest {

	private Connection c;
	private PatientDAO p;
	
	public PatientDAOTest() {
		p = new PatientDAO();
		
		c = SQLConnectionPoolFactory.getPool().getConnection();
	}
	
	/*
	 * 
	 * Before all add in three types of users to the database
	 * 
	 */
	@BeforeAll
	public void setUp() throws Exception {
		
		String patquery = "INSERT INTO USER (Firstname, Lastname, Email, ID, Password) VALUES('Pat','Test','Pattest@test.com', 'one',  MD5('Test'))";
		String docquery = "INSERT INTO USER  (Firstname, Lastname, Email, ID, Password) VALUES('Doc','Test','Doctest@test.com','two',  MD5('Test'))";
		String staffquery = "INSERT INTO USER  (Firstname, Lastname, Email, ID, Password)  VALUES('Staff','Test','Stafftest@test.com','three', MD5('Test'))";
		PreparedStatement p = c.prepareStatement(patquery);
		PreparedStatement p2 = c.prepareStatement(docquery);
		PreparedStatement p3 = c.prepareStatement(staffquery);
		
		 p.executeUpdate();
		 p2.executeUpdate();
		 p3.executeUpdate();
		 
		 patquery = "INSERT INTO Patient (ID) VALUES('one')";
		 docquery = "INSERT INTO Doctor (ID) VALUES('two')";
		 staffquery = "INSERT INTO STAFF (ID) VALUES('three')";
		 
		  p = c.prepareStatement(patquery);
		  p2 = c.prepareStatement(docquery);
		  p3 = c.prepareStatement(staffquery);
			
		 p.executeUpdate();
		 p2.executeUpdate();
		 p3.executeUpdate();
		 
	}
	
	/*
	 * 
	 * After All, remove the users from the database
	 * 
	 */
	@AfterAll
	public void tearDown() throws Exception {
		String q = "DELETE FROM Doctor WHERE ID = 'two'";
		String q2 = "DELETE FROM Patient WHERE ID = 'one'";
		String q3 = "DELETE FROM Staff WHERE ID = 'three'";
		String q4 = "DELETE FROM User WHERE (ID = 'one' OR ID = 'two' OR ID = 'three')";
		
		PreparedStatement p = c.prepareStatement(q);
		PreparedStatement p2 = c.prepareStatement(q2);
		PreparedStatement p3 = c.prepareStatement(q3);
		PreparedStatement p4 = c.prepareStatement(q4);
		
		 p.executeUpdate();
		 p2.executeUpdate();
		 p3.executeUpdate();
		 p4.executeUpdate();
		
	}
	
	/*
	 * 
	 * Before each add in new appointments for testing
	 * 
	 */
	@BeforeEach
	public void clean() throws Exception {
		
		String query = "INSERT INTO Diagnosis (Name, Description) VALUES ('GERD', 'Gastroesophageal reflux disease (GERD) is a long-term condition where acid from the stomach comes up into the esophagus' )";
		PreparedStatement p = c.prepareStatement(query);
		p.executeUpdate();
		
		query = "INSERT INTO Diagnosis (Name, Description) VALUES ('Breast Cancer', 'A cancer effecting the breast' )";
		p = c.prepareStatement(query);
		p.executeUpdate();
		
		
	}
	
	
	/*
	 * 
	 * After each remove all appointments associated with these tests 
	 * 
	 */
	@AfterEach
	public void tearDown1() throws Exception {
		String query = "DELETE FROM Diagnosis";
		PreparedStatement p = c.prepareStatement(query);
		p.executeUpdate();
		
		
	}
	
	@Test 
	public void getDataTest() {
		List<Patient> pats = null;
		String[] fields = {"ID"};
		String[] params = {"pooiqwiewqiqwiqpoqwoq"};
		
		pats = p.getData(fields, params);
		
		assert(pats != null);
		
		for(Patient pat : pats) {
			System.out.println("Patient: " + pat.toString());
		}
	}
	
	
	

}
