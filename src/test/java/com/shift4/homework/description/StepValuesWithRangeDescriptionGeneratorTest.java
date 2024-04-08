/*
 * Created on 08-04-2024 01:59 by jjedlins
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

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class StepValuesWithRangeDescriptionGeneratorTest {

	@ParameterizedTest
	@MethodSource("parametersForShouldGenerateDescriptionForStepValueWithRange")
	void shouldGenerateDescriptionForStepValueWithRange(String expression, String expectedResult) {

		// when
		String result = StepValuesWithRangeDescriptionGenerator.generateDescription(expression);

		// then
		Assertions.assertEquals(expectedResult, result);
	}

	private static Stream<Arguments> parametersForShouldGenerateDescriptionForStepValueWithRange() {

		return Stream.of(
			Arguments.of("1-6/2", "1 3 5"),
			Arguments.of("2-10/3", "2 5 8"),
			Arguments.of("10-20/15", "10")
		);
	}
}