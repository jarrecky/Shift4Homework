/*
 * Created on 08-04-2024 01:38 by jjedlins
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


class StepValuesDescriptionGeneratorTest {

	@ParameterizedTest
	@MethodSource("parametersForShouldGenerateStepValuesDescription")
	void shouldGenerateStepValuesDescription(String expression, int minValue, int maxValue, String expectedValue) {

		// when
		String result = StepValuesDescriptionGenerator.generateDescription(expression, minValue, maxValue);

		// then
		Assertions.assertEquals(expectedValue, result);
	}

	private static Stream<Arguments> parametersForShouldGenerateStepValuesDescription() {

		return Stream.of(
			Arguments.of("*/5", 0, 59, "0 5 10 15 20 25 30 35 40 45 50 55"),
			Arguments.of("*/3", 1, 12, "1 4 7 10"),
			Arguments.of("*/5", 0, 6, "0 5")
		);
	}
}