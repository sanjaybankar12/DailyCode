package com.stream;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeesMaxSalaryByDeparment {

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
	}

}
