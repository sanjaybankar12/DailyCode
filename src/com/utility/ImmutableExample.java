package com.utility;

/**
 * Once you created object of immutable class then object value can not be changed.
 *
 */
final class Employee {
	private final String name;
	
	public Employee(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}

public class ImmutableExample {

	public static void main(String[] args) {
		//
		Employee e = new Employee("hello");
		
	}

}
