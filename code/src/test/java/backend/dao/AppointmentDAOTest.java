package backend.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runners.MethodSorters;

import backend.SQLConnection.SQLConnectionPoolFactory;
import backend.classes.Appointment;
import backend.dao.AppointmentDAO;


public class AppointmentDAOTest {
	private List<LocalDateTime> usedDates; 
	private String [] goodFields;
	private String [] badFields ;
	private Connection c;
	private AppointmentDAO a;

	public AppointmentDAOTest(){
		goodFields = new String []{ "DateVal", "DoctorID", "PatientID"};
		badFields = new String [] {"Date", "DoctorID", "PatientID"};
		a = new AppointmentDAO(); 
		usedDates = new ArrayList<LocalDateTime>();  
		c = SQLConnectionPoolFactory.getPool().getConnection();
	}
	
	/*
	 * 
	 * Before all add in three types of users to the database
	 * 
	 */
	@BeforeAll
	public void setUp() throws Exception {
		System.out.println("Working");
		String patquery = "INSERT INTO USER VALUES('Pat','Test','Pattest@test.com', 'one',  MD5('Test'))";
		String docquery = "INSERT INTO USER VALUES('Doc','Test','Doctest@test.com','two',  MD5('Test'))";
		String staffquery = "INSERT INTO USER VALUES('Staff','Test','Stafftest@test.com','three', MD5('Test'))";
		PreparedStatement p = c.prepareStatement(patquery);
		PreparedStatement p2 = c.prepareStatement(docquery);
		PreparedStatement p3 = c.prepareStatement(staffquery);
		
		 p.executeUpdate();
		 p2.executeUpdate();
		 p3.executeUpdate();
		 
		 patquery = "INSERT INTO Patient VALUES('one')";
		 docquery = "INSERT INTO Doctor VALUES('two')";
		 staffquery = "INSERT INTO USER VALUES('three')";
		 
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
		
     
		for (int i =0; i < 10; i ++) {
			LocalDateTime a = LocalDateTime.now(); 
			usedDates.add(a);
			String query = "INSERT INTO APPOINTMENT (DateVal, DoctorID, PatientID) VALUES (Date(?),'two','one'";
			PreparedStatement p = c.prepareStatement(query);
			p.setString(1,a.toString());
			p.executeUpdate();
		}
		
		
		
	}
	
	/*
	 * 
	 * After each remove all appointments associated with these tests 
	 * 
	 */
	@AfterEach
	public void tearDown1() throws Exception {
		String query = "DELETE FROM  APPOINTMENT WHERE PatientID ='one'";
		PreparedStatement p = c.prepareStatement(query);
		p.setString(1,a.toString());
		p.executeUpdate();
		
		
	}

	/*
	 * 
	 * After All, remove the users from the database
	 * 
	 */
	@AfterAll
	public void tearDown() throws Exception {
		/*String q = "DELETE FROM Doctor WHERE ID = 'one'";
		String q2 = "DELETE FROM Patient WHERE ID = 'two'";
		String q3 = "DELETE FROM Staff WHERE ID = 'three'";
		String q4 = "DELETE FROM User WHERE (ID = 'one' OR ID = 'two' OR ID = 'three'";
		
		PreparedStatement p = c.prepareStatement(q);
		PreparedStatement p2 = c.prepareStatement(q2);
		PreparedStatement p3 = c.prepareStatement(q3);
		PreparedStatement p4 = c.prepareStatement(q4);
		
		 p.executeUpdate();
		 p2.executeUpdate();
		 p3.executeUpdate();
		 p4.executeUpdate();*/
		
	}

	@Test
	public void testValidInsert() {
		String [] params = {LocalDateTime.now().toString(), "two", "one"};
		try {
			System.out.println(goodFields[0]);
			a.insertIntoTable(goodFields, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testInValidInsert() {
		String [] params = {LocalDateTime.now().toString(), "two", "one"};
		Exception exception = assertThrows(SQLException.class, () -> {
			 a.insertIntoTable(badFields, params);
		    });
		 
		 
	
		
	}

	
}
