package backend.classes;

import frontend.EHRRunner;
import frontend.provider.ProviderRunner;

public class Doctor extends HealthCareProvider {
	private String DoctorID; 
	private String title; 

	public Doctor(String string, String string2) {
		// TODO Auto-generated constructor stub
		DoctorID = string; 
		title = string2; 
	}

	public String getDoctorID() {
		return DoctorID;
	}

	public void setDoctorID(String doctorID) {
		DoctorID = doctorID;
	}
	
	@Override 
	public void accept(EHRRunner r) {
		r.setR(new ProviderRunner(r));
	}
	

}
