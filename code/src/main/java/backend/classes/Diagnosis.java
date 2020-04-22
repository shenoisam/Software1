package backend.classes;

import java.util.List;

import backend.NotImplementedException;

public class Diagnosis {
	private String Name; 
	private String Description; 

	public Diagnosis() {
		// TODO Auto-generated constructor stub
	}

	public Diagnosis(List<String> headerRow, List<Object> list) throws NotImplementedException {
		// TODO Auto-generated constructor stub
		throw new NotImplementedException("Diagnosis Not Implemented"); 
	}

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
