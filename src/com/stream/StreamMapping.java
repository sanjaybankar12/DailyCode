package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMapping {

	public static void main(String[] args) {

		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH) );
		
		
		Map map = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.toMap(Dish::getName, p -> {
					if (p.getCalories() > 500) {
						return Dish.CaloricLevel.FAT;
					} else if (p.getCalories() < 300) {
						return Dish.CaloricLevel.DIET;
					} else {
						return Dish.CaloricLevel.NORMAL;
					}
				})));
		
		System.out.println(map);
		
	}

}
