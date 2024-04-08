package com.shift4.homework.description;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.shift4.homework.utils.Assertions;


class ValuesRangeDescriptionGenerator {

	private ValuesRangeDescriptionGenerator(){}

	static String generateDescription(String expression) {

		String[] split = expression.split("-");

		Assertions.assertTrue(split.length == 2, "invalid value for values range description: " + expression);

		int minValue = Integer.parseInt(split[0]);
		int maxValue = Integer.parseInt(split[1]);

		return IntStream.rangeClosed(minValue, maxValue)
			.mapToObj(String::valueOf)
			.collect(Collectors.joining(" "));
	}
}
