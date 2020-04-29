package backend.classes;

import java.util.List;

import backend.NotImplementedException;

public class Diagnosis {
	private String Name; 
	private String Description; 

	/*
	public Diagnosis() {
		// TODO Auto-generated constructor stub
	}
	*/
	
	public Diagnosis(List<String> headerList, List<Object> dataList) {
		// If the headerList is not null
		if(headerList != null) {
			// Create constant strings to represent the variable names
			final String diagnosisName = "Name";
			final String diagnosisDescription = "Description";
			
			// For every element in the headerList
			for(String h : headerList) {
				// Get the index the string is at
				int index = headerList.indexOf(h);
				
				// If the element represents the diagnosis name
				if(h.contentEquals(diagnosisName)) {
					// Initialize the name variable of the diagnosis
					this.Name = (String) dataList.get(index);
				}
				// Otherwise if it represents the description
				else if(h.contentEquals(diagnosisDescription)) {
					// Initialize the description variable of the diagnosis
					this.Description = (String) dataList.get(index);
				}
				// Otherwise if it represents anything else print an error
				// about initializing an illegal variable
				
			}
		}
		
	}

//	public Diagnosis(List<String> headerRow, List<Object> list) throws NotImplementedException {
//		// TODO Auto-generated constructor stub
//		throw new NotImplementedException("Diagnosis Not Implemented"); 
//	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	

}
