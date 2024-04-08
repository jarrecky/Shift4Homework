/*
 * Created on 08-04-2024 01:35 by jjedlins
 *
 * Copyright (c) 2001-2024 Unity S.A.
 * ul. Strzegomska 2-4, 53-611 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Unity S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Unity S.A.
 */

package com.shift4.homework.description;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class AnyValueDescriptionGeneratorTest {

	@ParameterizedTest
	@MethodSource("parametersForShouldPrintAnyValueExpressionDescription")
	void shouldPrintAnyValueExpressionDescription(int minValue, int maxValue) {

		// given
		String expectedResult = IntStream.rangeClosed(minValue, maxValue)
			.mapToObj(String::valueOf)
			.collect(Collectors.joining(" "));

		// when
		String result = AnyValueDescriptionGenerator.generateDescription(minValue, maxValue);

		// then
		Assertions.assertEquals(expectedResult, result);
	}

	private static Stream<Arguments> parametersForShouldPrintAnyValueExpressionDescription() {

		return Stream.of(
			Arguments.of(1, 10),
			Arguments.of(0, 58),
			Arguments.of(1, 12),
			Arguments.of(0, 59)
		);
	}
}