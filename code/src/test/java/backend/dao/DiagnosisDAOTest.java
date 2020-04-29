package backend.dao;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.function.Executable;

import backend.SQLConnection.SQLConnectionPoolFactory;
import backend.classes.Appointment;
import backend.classes.Diagnosis;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DiagnosisDAOTest {

	private Connection c;
	private DiagnosisDAO d;

	public DiagnosisDAOTest(){
		d = new DiagnosisDAO();
		
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

	
	@Test
	public void testValidInsert() {
		
	    String [] fields  = {"Name", "Description"};
		String [] params = {"Behcet's disease", "A rare disorder causing inflammation in blood vessels."};
		try {
			d.insertIntoTable(fields, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testInValidInsert() {
		String [] fields  = {"Name12312", "Description"};
		String [] params = {"Behcet's disease", "A rare disorder causing inflammation in blood vessels."};
		Exception exception = assertThrows(SQLException.class, new Executable() {
			public void execute() throws Throwable {
				 d.insertIntoTable(fields, params);
			    }
		});
		
		
	}
	
	@Test
	public void testQueryByDiagnosisName() {
		final String [] params = {"GERD"};
		final String [] fields = {"Name"};
		List<Diagnosis> q = d.getData(fields, params);
		assertTrue(q.size() == 1);
		assertTrue(q.get(0).getDescription().contentEquals("Gastroesophageal reflux disease (GERD) is a long-term condition where acid from the stomach comes up into the esophagus"));
	}
	
	@Test 
	public void testDelete() {
		final String [] params = {"GERD"};
		final String [] fields = {"Name"};
		try {
			d.deleteFromTable(fields, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(d.getData(fields, params).size() == 0);
	}

	/*@Test 
	public void testUpdate() {

		final String [] fields = {"PatientID", "DateVal"};
		
		LocalDateTime aptTime = usedDates.get(0);
		final String [] params = {"one", aptTime.toString()};
		aptTime.minusHours(1);
		final String [] params2= {"one", aptTime.toString()};
		try {
			a.updateTable(fields, params2, fields, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		
		//assertTrue(a.getData(fields, params).size() == 0);
	}*/

}
