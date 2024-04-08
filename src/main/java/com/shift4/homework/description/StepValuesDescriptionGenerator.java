package com.shift4.homework.description;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


class StepValuesDescriptionGenerator {

	private StepValuesDescriptionGenerator(){}

	static String generateDescription(String expression, int minValue, int maxValue) {

		String[] split = expression.split("/");

		int step = Integer.parseInt(split[1]);

		return IntStream.iterate(minValue, n -> n <= maxValue, n -> n + step)
			.mapToObj(String::valueOf)
			.collect(Collectors.joining(" "));
	}
}
