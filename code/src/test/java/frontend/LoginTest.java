package frontend;

import static org.junit.Assert.*;

import org.junit.Test;

import frontend.patient.PatientRunner;
import frontend.provider.ProviderRunner;
import frontend.staff.Runner;

public class LoginTest {

	@Test
	public void testValidateUser() {
		// Can't really test this until we have validate user working...
		String username = "DoctorJones";
		String password = "passwordDoctor";
		EHRRunner runner = new EHRRunner();
	
		runner.validateUser(username, password);
		GenericRunner r = runner.getGenericRunner();
		
		GenericRunner doctor = new ProviderRunner(runner);
		
		if (r != doctor) {
			//Should the system automatically create a fail scenario?
			fail("Did not create doctor type");
		}
		
		username = "StaffSmith";
		password = "passwordStaff";
		runner.validateUser(username, password);
		r = runner.getGenericRunner();
		
		GenericRunner staff = new Runner(runner);
		
		if(r != staff) {
			fail("Did not create staff type");
		}
		
		username = "PatientNancy";
		password = "passwordPatient";
		runner.validateUser(username, password);
		r = runner.getGenericRunner();
		
		GenericRunner patient = new PatientRunner(runner);
		
		if(r != patient) {
			fail("Did not create patient type");
		}
		
		username = "failDataUser";
		password = "failDataPass";
		runner.validateUser(username, password);
		//Should this fail when we run it??
		r = runner.getGenericRunner();
		
		//fail("Not yet implemented");
	}

}
