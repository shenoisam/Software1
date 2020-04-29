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
	
	public Test(List<String> headerRow, List<Object> list) {
		// TODO Auto-generated constructor stub
	}
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
		return "Test [Name=" + Name + ", Type=" + Type + "]";
	}
	
}
