package com.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashSet;

public class StreamOperations2 {

	public static void main(String[] args) {
		Integer num1 = 127;
		Integer num2 = 127;
		Integer num3 = 128;
		Integer num4 = 128;

		System.out.println(num1 == num2); //true
		System.out.println(num3 == num4); // false till 127 if we create object by using Integer then it will not create new object
		//instead they refer existing object from array or cache.
		
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1,"Ram","COMP",18000));
		employees.add(new Employee(4,"Ravi","COMP",20000));
		employees.add(new Employee(2,"Ram","IT",55000));
		employees.add(new Employee(3,"Adi","ETC",10000));
		employees.add(new Employee(1,"Adi","ETC",60000));
		
		HashSet<Integer> idhs = new HashSet<>();
		HashSet<String> namehs = new HashSet<>();
		Map map = employees.stream().filter(e -> idhs.add(e.getId()) && namehs.add(e.getName())).collect(Collectors.groupingBy(Employee::getDept));
		System.out.println(map);
	}

}
