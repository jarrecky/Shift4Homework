/*
 * Created on 08-04-2024 02:06 by jjedlins
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

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class ValuesRangeDescriptionGeneratorTest {

	@ParameterizedTest
	@MethodSource("parametersForShouldGenerateDescriptionForValuesRange")
	void shouldGenerateDescriptionForValuesRange(String expression, String expectedResult) {

		// when
		String result = ValuesRangeDescriptionGenerator.generateDescription(expression);

		// then
		Assertions.assertEquals(expectedResult, result);
	}

	private static Stream<Arguments> parametersForShouldGenerateDescriptionForValuesRange() {

		return Stream.of(
			Arguments.of("1-10", "1 2 3 4 5 6 7 8 9 10"),
			Arguments.of("3-4", "3 4"),
			Arguments.of("5-5", "5")
		);
	}
}