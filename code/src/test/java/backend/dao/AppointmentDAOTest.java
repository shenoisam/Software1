package backend.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import backend.classes.Appointment;
import backend.dao.AppointmentDAO;


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
		AppointmentDAO a = new AppointmentDAO();
		List<Appointment> q  = a.getAllAppointmentsByDate(usedDate);
		assertTrue(q.size() == 1);
		System.out.println(q.get(0));
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
