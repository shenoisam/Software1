package backend.classes;

import java.util.List;

/**
 * 
 * Test class that contains information about a Test sent to
 * a Lab
 * 
 * @author mmorr
 *
 */
public class Test {
	private String Name;
	private String Type;
	private String InsuranceCode;
	
	/**
	 * Test constructor
	 * 
	 * @param list of header names 
	 * @param list of objects that contains all data fields for Test object
	 * (eg. Name, Type, etc.)
	 * @return Test object
	 * 
	 * Constructor iterates through the object list, matching each element
	 * with the corresponding header in the headerList, and fills the 
	 * Test object with the correct data
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
