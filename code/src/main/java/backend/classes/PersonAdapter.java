package backend.classes;

/*
 * This class serves as an adapter between doctors and staff
 */
public class PersonAdapter {
	private String ID, title;

	
	PersonAdapter(HealthCareProvider provider){
		if(provider != null) {
			// If the provider is a doctor, set the ID to the doctor ID
			// and the title to the doctor's title.
			if(provider.getClass() == Doctor.class) {
				this.ID = ((Doctor) provider).getDoctorID();
				this.title = ((Doctor) provider).getDoctorTitle();
			}
			// Otherwise if it is a staff member set the ID to its ID
			// and the title to its title
			else{
				this.ID = ((Staff) provider).getStaffID();
				this.title = ((Staff) provider).getStaffTitle();
			}
		}
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}
}
