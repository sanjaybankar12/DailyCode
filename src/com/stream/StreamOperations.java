package com.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamOperations {

	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1,"Ram","COMP",18000));
		employees.add(new Employee(2,"Ravi","COMP",20000));
		employees.add(new Employee(3,"Sam","IT",15000));
		employees.add(new Employee(4,"Adi","ETC",10000));
		employees.add(new Employee(5,"Adi1","ETC",60000));
		
		Map<String, IntSummaryStatistics> map = employees.stream().collect(Collectors.groupingBy(Employee::getDept,
				Collectors.summarizingInt(Employee::getSalary)));
		for(Map.Entry<String, IntSummaryStatistics> entryMap : map.entrySet()) {
			System.out.println(entryMap.getKey() + " department max salary => " + entryMap.getValue().getMax());
		}		
		
		System.out.println("\n---Sum of even number from List---");
		List<Integer> numList = new ArrayList<>();
		numList.add(1);
		numList.add(2);
		numList.add(3);
		numList.add(4);
		numList.add(5);
		
		int sum = numList.stream().filter(value -> value%2 == 0).collect(Collectors.summingInt(Integer::intValue));
		//int sum = numList.stream().filter(value -> value%2 == 0).reduce(0, (a, b) -> (a + b));
		//int sum = numList.stream().filter(value -> value%2 == 0).reduce(0, Integer::sum);
		System.out.println("Sum of even number = " + sum);
		
		System.out.println("\n---Employee sorted by Name---");
		List<Employee> empls = employees.stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
		System.out.println(empls);
		
		
	}

}
