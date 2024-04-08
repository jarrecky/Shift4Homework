package com.shift4.homework.description;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.shift4.homework.utils.Assertions;


public class StepValuesWithRangeDescriptionGenerator {

	private StepValuesWithRangeDescriptionGenerator(){}

	static String generateDescription(String expression) {

		String[] split = expression.split("/");

		Assertions.assertTrue(split.length == 2, "invalid expression for step values with range: " + expression);

		int step = Integer.parseInt(split[1]);

		String[] range = split[0].split("-");

		Assertions.assertTrue(range.length == 2, "invalid expression for step values with range: " + expression);

		int startRange = Integer.parseInt(range[0]);
		int endRange = Integer.parseInt(range[1]);

		return IntStream.iterate(startRange, n -> n <= endRange, n -> n + step)
			.mapToObj(String::valueOf)
			.collect(Collectors.joining(" "));
	}
}
