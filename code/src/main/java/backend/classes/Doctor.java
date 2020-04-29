package backend.classes;

import java.util.List;

import frontend.EHRRunner;
import frontend.GenericRunner;
import frontend.provider.ProviderRunner;

public class Doctor extends HealthCareProvider {
	private String DoctorID; 
	private String title; 

	
	public Doctor(String string, String string2) {
		// TODO Auto-generated constructor stub
		DoctorID = string; 
		title = string2; 
	}
	
	
	/*
	 * Constructor for doctor assuming two passed lists:
	 * 		- headerList:	
	 * 				contains the names for the variables passed
	 * 				in the data list.
	 * 					ex: "DoctorID" and "title"
	 * 		- dataList:
	 * 				contains the variables stored by the Doctor object
	 */
	public Doctor(List<String> headerList, List<Object> dataList) {
		// If the headerList isn't null
		super(headerList, dataList);
		if(headerList != null) {
			// Create constants to represent the Doctor variables' names
			final String identification = "ID";
			final String doctorTitle = "Title";
			
			
			// For every member of the headerList
			for(int i = 0; i < headerList.size(); i++) {
				// If the ID is read in at the corresponding index of the dataList
				if(headerList.get(i).contentEquals(identification)) {
					// Initialize the ID for the doctor object
					this.DoctorID = dataList.get(i).toString();
				}
				// Otherwise if the title is being read in
				else if(headerList.get(i).contentEquals(doctorTitle)) {
					// Initialize the doctor object's title
					try {
					this.title = dataList.get(i).toString();
					}catch(NullPointerException e) {
						this.title = "";
					
					}
				}
				
			}
		}
		// Otherwise print an error about initializing without values
		else {
			System.out.println("Error: Initializing from no values");
		}
	}
	
	
	public String getDoctorID() {
		return DoctorID;
	}

	public void setDoctorID(String doctorID) {
		DoctorID = doctorID;
	}
	
	@Override 
	public GenericRunner accept(EHRRunner r) {
		return new ProviderRunner(r);
	}


	@Override
	public String toString() {
		return "Doctor [name= Dr. " + this.getFullName() + " title=" + title + "]";
	}
	

}
