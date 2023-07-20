package com.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlternateNumerMappingEx {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1,-1,5,-7,-4,-1,2,3,8,-4,-1);
		
		List<Integer> list1 = list.stream().filter(n -> n > 0).toList();
		List<Integer> list2 = list.stream().filter(n -> n < 0).toList();
		
		List<Integer> ls = new ArrayList<>();
		for(int i = 0; i < list1.size(); i++) {
			ls.add(list1.get(i));
			
			if(i < list2.size()) {
				ls.add(list2.get(i));
			}
		}
		
		if(list1.size() < list2.size()) {
			for(int i = list1.size(); i < list2.size(); i++) { 
				ls.add(list2.get(i));
			}
		}
		System.out.println(ls);
	}

}
