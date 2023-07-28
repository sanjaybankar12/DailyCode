package com.utility;

import java.util.HashSet;

import com.stream.Employee;

/**
 *  Object content should be unique.
 *  We need to override equals method to check equality of objects based on it's parameters.
 *  
 *  HashSet steps:
 *  1) we add element into HashSet
 *  2) Element is stored as a key in HashMap and value will be the Object class instance.
 *  3) Element hashCode is generated and check for hashing collision 
 *  4) If no hashing collision then element will be add as new Node in LinkedList.
 *  5) If hashing collision happen then it elements will be check for equality by using equals method.
 *  6) If equals method return true means objects are equal and new object will not be added.
 *  7) If equals method return false then object will be add as new node in LinkedList
 *
 */
public class UniqueObjectInSet {

	public static void main(String[] args) {

		Employee e1 = new Employee(1, "ravi", "IT", 10000);
		Employee e2 = new Employee(1, "sam", "COMP", 10000);
		Employee e3 = new Employee(1, "ravi", "IT", 10000); //Duplicate so it will not be added

		//If we want to add only unique object with it's content inside HashSet then first we have to override hashCode method
		// and return any integer value. so that hashing collision will occur and then object will be check for equality 
		// by using equals method
		//Override equals method to check object equality based on it's parameter
		HashSet<Employee> list = new HashSet<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		System.out.println("Total objects in Set = " + list.size());
		for(Employee e : list) {
			System.out.println(e);
		}
	}

}
