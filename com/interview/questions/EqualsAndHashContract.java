package com.interview.questions;

import java.util.HashMap;
import java.util.Map;


//when you don't provide hashcode implementation , Hash based collections (map, set) uses system generated hashcode to 
// store and retrieve, when happens to be different even the two objects have the same attributes.

//Also duplicates are created in HashSet if we do not override hashcode method
public class EqualsAndHashContract {
	
	
	/*private String name;
	private int age;
	
	public EqualsAndHashContract(String name , int age) {
		this.name = name;
		this.age  = age;
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		EqualsAndHashContract e1 = new EqualsAndHashContract("Gaurav", 24);
		
		EqualsAndHashContract e2 = (EqualsAndHashContract)e1.clone();
		
		System.out.println(e1.name + "  " + e1.age);
		System.out.println(e2.name + "  " + e2.age);
		
		e2.name = "Rahul";
		e2.age = 23;
		
		System.out.println(e1.name + "  " + e1.age);
		System.out.println(e2.name + "  " + e2.age);
	}*/
	
	
	static Map<EmployeeKey, String> loadEmployeeCache(){
		EmployeeKey e1 = new EmployeeKey("100", "10101984");
		EmployeeKey e2 = new EmployeeKey("101", "12101984");
		EmployeeKey e3 = new EmployeeKey("102", "11101984");
		
		Map<EmployeeKey, String> cache  = new HashMap<>();
		
		cache.put(e1, "bob");
		cache.put(e2, "steve");
		cache.put(e3, "robert");
		
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		System.out.println(e3.hashCode());
		System.out.println(cache.get(e1));
		
		return cache;
		
	}
	
	public static void main(String[] args) {
		
		Map<EmployeeKey, String> cache = loadEmployeeCache();
		
		EmployeeKey lookUpKey = new EmployeeKey("101", "12101984");
		
		EmployeeKey lookUpKey1 = new EmployeeKey("101", "12101984");
		
		System.out.println(lookUpKey.hashCode());
		
		String empName = cache.get(lookUpKey);
		
		System.out.println(empName);
		
		System.out.println(lookUpKey.equals(lookUpKey1));
		
	}

}


class EmployeeKey{
	
	String employeeId;
	String dob;
	
	public EmployeeKey(String employeeId, String dob) {
		this.employeeId = employeeId;
		this.dob = dob;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeKey other = (EmployeeKey) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		return true;
	}
	
	
	
}