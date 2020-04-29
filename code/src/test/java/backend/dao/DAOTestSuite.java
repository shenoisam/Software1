package backend.dao;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;


@RunWith(Suite.class)

@Suite.SuiteClasses({
   AppointmentDAOTest.class,
   DiagnosisDAOTest.class,
   DoctorDAOTest.class, 
   NotesDAOTest.class,
   PatientDAOTest.class,
   PatientDiagnosisDAOTest.class,
   PrescriptionDAOTest.class, 
   StaffDAOTest.class,
   TestDAOTest.class, 
   TestOrderDAOTest.class, 
   TestResultDAOTest.class,
   UserDAOTest.class
})

public class DAOTestSuite {


}

