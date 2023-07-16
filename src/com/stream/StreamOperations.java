package com.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamOperations {

	public static void main(String[] args) {
		
		System.out.println(10.0/0);

		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1,"Ram","COMP",18000));
		employees.add(new Employee(2,"Ravi","COMP",20000));
		employees.add(new Employee(3,"Sam","IT",55000));
		employees.add(new Employee(4,"Adi","ETC",10000));
		employees.add(new Employee(5,"Adi1","ETC",60000));
		
		Map<String, IntSummaryStatistics> map = employees.stream().collect(Collectors.groupingBy(Employee::getDept,
				Collectors.summarizingInt(Employee::getSalary)));
		for(Map.Entry<String, IntSummaryStatistics> entryMap : map.entrySet()) {
			System.out.println(entryMap.getKey() + " department max salary => " + entryMap.getValue().getMax());
		}
		
		
		System.out.println("\n--- 2nd Highest Salary---");
		Optional<Integer> secondHighSal = employees.stream().map(Employee::getSalary).sorted((o1, o2) -> o2.compareTo(o1)).skip(1).limit(1).findFirst();
		System.out.println(secondHighSal.get());
		
		System.out.println("\n---Sum of even number from List---");
		List<Integer> numList = new ArrayList<>();
		numList.add(1);
		numList.add(2);
		numList.add(3);
		numList.add(2);
		numList.add(4);
		numList.add(5);			
		System.out.println("Given list = " + numList);
		//int sum = numList.stream().filter(value -> value%2 == 0).collect(Collectors.summingInt(Integer::intValue));
		//int sum = numList.stream().flter(value -> value%2 == 0).reduce(0, (a, b) -> (a + b));
		int sum = numList.stream().filter(value -> value%2 == 0).reduce(0, Integer::sum);
		System.out.println("Sum of even number = " + sum);
		
		System.out.println("---First repeating number from List---");
		Integer firstRptNum = numList.stream().filter(n -> Collections.frequency(numList, n) > 1).findFirst().get();
		System.out.println(firstRptNum);
		HashSet<Integer> hs = new HashSet<>();
		Integer firstRptingNum = numList.stream().filter(n -> !hs.add(n)).findFirst().get();
		System.out.println(firstRptingNum);

		int maxVal = numList.stream().max((o1, o2) -> o1 - o2).get();
		System.out.println("Max value = " + maxVal);
		
		System.out.println("\n---Employee sorted by Name---");
		List<Employee> empls = employees.stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
		System.out.println(empls);
		
		//Using Flat Map
		System.out.println("\n---Flat map Example---");
		List<String> num1 = Arrays.asList("B","D","E","N");
		List<String> num2 = Arrays.asList("E","M","D","G");
		List<List<String>> list = Arrays.asList(num1, num2);
		System.out.println("Input : " + list);
		Set<String> ls = list.stream().flatMap(List::stream).collect(Collectors.toSet());
		System.out.println("Output : " + ls);
		
		System.out.println("--------------------------------");
		String str = "welcome world";
		List<String> listStr = Arrays.asList(str.split(""));
		Map mapStr = listStr.stream().filter(s -> !"".equals(s.trim())).collect(Collectors.groupingBy(String::new, Collectors.counting()));
		System.out.println(mapStr);
		
	}

}
