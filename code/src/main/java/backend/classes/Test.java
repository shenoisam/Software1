package backend.classes;

import java.util.List;

/*
 * -Name
-Type -Insurance Code
 */
public class Test {
	private String Name;
	private String Type;
	private String InsuranceCode;
	
	/*
	 * Test constructor
	 * 
	 * Receives a List of strings (the list of column headers)
	 * and a List of Objects (the data in the table)
	 * 
	 * Generates a Test object containing data from the Object list
	 * 
	 * author: matthew morris
	 */
	public Test(List<String> headerList, List<Object> list) {
		if(headerList != null) {
    		final String nm = "Name", type = "Type", ic = "InsuranceCode";
    		
    		for(int i = 0; i < headerList.size(); i++) {
    			String headerVal = headerList.get(i);
    			
    			if(headerVal.contentEquals(nm)) {
    				Name = (String)list.get(i);
    			} else if(headerVal.contentEquals(type)) {
    				Type = (String)list.get(i);
    			} else if(headerVal.contentEquals(ic)) {
    				InsuranceCode = (String)list.get(i);
    			}
    		}
    	} else {
    		System.out.println("Error: initializing from no values");
    	}
	}
	
	public Test() {}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getInsuranceCode() {
		return InsuranceCode;
	}
	public void setInsuranceCode(String insuranceCode) {
		InsuranceCode = insuranceCode;
	}
	@Override
	public String toString() {
		return Name;
	}
	
}
