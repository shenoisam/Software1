package backend.dao;

import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppointmentDAOTest {
	private Date usedDate; 

	@Before
	public void setUp() throws Exception {
		usedDate = new Date(); 
	}

	@After
	public void tearDown() throws Exception {
		//Remove all created stuff. TODO: need to implement this. Not sure exactly how to. 
		// If one of the test cases fail, the entire thing might not work again...
	}


	/*
	 * this test case runs first. It should test insertion into the database
	 * 
	 */
	@Test
	public void test1() {
		AppointmentDAO a = new AppointmentDAO();
		
		String [] arr = {usedDate.toString(),"adbacubasdibcuasdc", "pooiqwiewqiqwiqpoqwoq"};
		String [] fields = {"Date", "DoctorID", "PatientID"};
		try {
			a.insertIntoTable(fields, arr);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(); 
		}
	}
	
	/* 
	 * this test case tests to make sure that an appointment can be found 
	 * 
	 * 
	 */
	@Test
	public void test2() {
		
	}
	
	
	/*
	 * this method tests to make sure that the created appointments can be deleted. 
	 * 
	 */
	@Test 
	public void test3() {
		//Delete the previously created Appointment; 
		AppointmentDAO a = new AppointmentDAO();
   
		
		String [] arr = {usedDate.toString(),"adbacubasdibcuasdc", "pooiqwiewqiqwiqpoqwoq"};
		String [] fields = {"Date", "DoctorID", "PatientID"};
		try {
			a.deleteFromTable(fields, arr);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(); 
		}
	}
}
