package com.shift4.homework.description;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


class AnyValueDescriptionGenerator {

	AnyValueDescriptionGenerator() {}

	static String generateDescription(int minValue, int maxValue) {

		return IntStream.rangeClosed(minValue, maxValue)
			.mapToObj(String::valueOf)
			.collect(Collectors.joining(" "));
	}
}
