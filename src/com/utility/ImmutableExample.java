package com.utility;

/**
 * Once you created object of immutable class then object value can not be changed.
 *
 */
final class Employee implements Cloneable {
	private final String name;
	
	private final Address adr;
	
	public Employee(String name, Address address) {
		this.name = name;
		Address tempAdr = new Address();
		tempAdr.setCity(address.getCity());
		tempAdr.setState(address.getState());
		this.adr = tempAdr;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Address getAddress() {
		Address ad = null;
		try {
			ad = (Address) this.adr.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return ad;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", adr=" + adr + "]";
	}
		
}

public class ImmutableExample {

	public static void main(String[] args) {
		Address adr = new Address("Pune","MH");
		Employee e = new Employee("hello", adr);		
		System.out.println(e);
		
		e.getAddress().setCity("Mumbai");
		System.out.println(e);
		
		
	}

}
