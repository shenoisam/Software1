package backend.dao;



import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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
import backend.dao.AppointmentDAO;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
		
     
		for (int i =0; i < 10; i ++) {
			LocalDateTime tw = LocalDateTime.now(); 
		    tw = tw.plusHours(i);
			Timestamp z = Timestamp.valueOf(tw); 
		
			usedDates.add(tw);
			String query = "INSERT INTO APPOINTMENT (DateVal, DoctorID, PatientID) VALUES ( ?, 'two','one')";
			PreparedStatement p = c.prepareStatement(query);
		    p.setTimestamp(1, z);
		  
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
		String [] params = {LocalDateTime.now().toString(), "two", "one"};
		try {
			a.insertIntoTable(goodFields, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testInValidInsert() {
		final String [] params = {LocalDateTime.now().toString(), "two", "one"};
		Exception exception = assertThrows(SQLException.class, new Executable() {
			public void execute() throws Throwable {
				 a.insertIntoTable(badFields, params);
			    }
		});
		
	}
	
	@Test
	public void testQueryByPatientID() {
		final String [] params = {"one"};
		final String [] fields = {"PatientID"};
		List<Appointment> q = a.getData(fields, params);
		assertTrue(q.size() == 10);
	}
	
	@Test
	public void testQueryByAppointment() {
		final String [] fields = {"DateVal"};
		final String [] params = {usedDates.get(0).toString()};
		
		List<Appointment> q = a.getData(fields, params);
		//Not super specific but whatever
		assertTrue(q.size() > 0 );
	}
	@Test 
	public void testDelete() {
		final String [] params = {"one"};
		final String [] fields = {"PatientID"};
		try {
			a.deleteFromTable(fields, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(a.getData(fields, params).size() == 0);
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
