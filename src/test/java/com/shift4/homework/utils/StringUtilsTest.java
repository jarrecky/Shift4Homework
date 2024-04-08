/*
 * Created on 08-04-2024 01:28 by jjedlins
 *
 * Copyright (c) 2001-2024 Unity S.A.
 * ul. Strzegomska 2-4, 53-611 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Unity S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Unity S.A.
 */

package com.shift4.homework.utils;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class StringUtilsTest {

	@ParameterizedTest
	@MethodSource("parametersForShouldExtractNumbers")
	void shouldExtractNumbers(String text, List<Integer> expectedResult) {

		// when
		List<Integer> integers = StringUtils.extractAllNumbersFromString(text);

		// then
		Assertions.assertEquals(expectedResult, integers);
	}

	private static Stream<Arguments> parametersForShouldExtractNumbers() {

		return Stream.of(
			Arguments.of("", List.of()),
			Arguments.of(" ", List.of()),
			Arguments.of("Ala ma kota", List.of()),
			Arguments.of("1", List.of(1)),
			Arguments.of("Ala ma 3 koty i 2 psy", List.of(3, 2)),
			Arguments.of("Ala ma już 34 koty, ale 0 psów", List.of(34, 0)),
			Arguments.of("123aa456", List.of(123, 456))
		);
	}

	@ParameterizedTest
	@MethodSource("parametersForShouldPrintTextPaddedWithSpaces")
	void shouldPrintTextPaddedWithSpaces(String text, int width, String expectedResult) {

		// when
		String result = StringUtils.padWithSpaces(text, width);

		// then
		Assertions.assertEquals(expectedResult, result);
	}

	private static Stream<Arguments> parametersForShouldPrintTextPaddedWithSpaces() {

		return Stream.of(
			Arguments.of("kot", 10, "kot       "),
			Arguments.of("command", 14, "command       "),
			Arguments.of("test", 4, "test"),
			Arguments.of("za długi tekst", 3, "za długi tekst")
		);
	}
}