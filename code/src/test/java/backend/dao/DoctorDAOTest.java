package backend.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.function.Executable;

import backend.SQLConnection.SQLConnectionPoolFactory;
import backend.classes.Diagnosis;
import backend.classes.Doctor;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DoctorDAOTest {

	private Connection c;
	private DoctorDAO d;

	public DoctorDAOTest(){
		d = new DoctorDAO();
		
		c = SQLConnectionPoolFactory.getPool().getConnection();
	}
	
	/*
	 * 
	 * Before all add in three types of users to the database
	 * 
	 */
	@BeforeAll
	public void setUp() throws Exception {
	   String u  = "INSERT INTO USER (Firstname, Lastname,email,ID,  password)  VALUES ('t','z','tz@tz.com','four', MD5('Test')";
	   PreparedStatement p3 = c.prepareStatement(u);
	   p3.executeUpdate();
		 
	}
	
	
	/*
	 * 
	 * Before each add in new appointments for testing
	 * 
	 */
	@BeforeEach
	public void clean() throws Exception {
		String docquery = "INSERT INTO USER  (Firstname, Lastname, Email, ID, Password) VALUES('Doc','Test','Doctest@test.com','two',  MD5('Test'))";
		PreparedStatement p2 = c.prepareStatement(docquery);
		p2.executeUpdate();
		docquery = "INSERT INTO Doctor (ID) VALUES('two')";
		p2 = c.prepareStatement(docquery);
		p2.executeUpdate();
	}
	
	
	/*
	 * 
	 * After each remove all appointments associated with these tests 
	 * 
	 */
	@AfterEach
	public void tearDown1() throws Exception {
		//Only dealing with doctors with ids one and four
		String query = "DELETE FROM Doctor WHERE (ID = 'two' OR ID = 'four')";
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
		 String del = "DELETE FROM USER WHERE ID = 'four'"; 		
	}

	
	@Test
	public void testValidInsert() {
		
	    String [] fields  = {"ID", "Title"};
		String [] params = {"four", "ER Doctor"};
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
	public void testFailQueryByDoctorID() {
		final String [] params = {"ID"};
		final String [] fields = {"four"};
		List<Doctor> q = d.getData(fields, params);
		assertTrue(q.size() == 0);
		
	}
	@Test
	public void testPassQueryByDoctorID() {
		final String [] params = {"ID"};
		final String [] fields = {"two"};
		List<Doctor> q = d.getData(fields, params);
		assertTrue(q.size() == 1);
		
	
		//Doctors should be able to get user fields as well
		assertTrue(q.get(0).getFirstName().contentEquals("Doc"));
		
	}
	@Test 
	public void testDelete() {
		final String [] params = {"two"};
		final String [] fields = {"ID"};
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

	}*/
}
