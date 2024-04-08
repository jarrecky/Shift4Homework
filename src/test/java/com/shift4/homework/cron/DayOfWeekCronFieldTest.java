/*
 * Created on 08-04-2024 01:19 by jjedlins
 *
 * Copyright (c) 2001-2024 Unity S.A.
 * ul. Strzegomska 2-4, 53-611 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Unity S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Unity S.A.
 */

package com.shift4.homework.cron;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class DayOfWeekCronFieldTest {

	@ParameterizedTest
	@MethodSource("parametersForShouldChangeDescriptiveWeekDayNamesToNumbers")
	void shouldChangeDescriptiveWeekDayNamesToNumbers(String expression, String adjustedExpression) {

		// when
		DayOfWeekCronField dayOfWeekCronField = new DayOfWeekCronField(expression);

		// then
		Assertions.assertEquals(adjustedExpression, dayOfWeekCronField.getExpression());
	}

	private static Stream<Arguments> parametersForShouldChangeDescriptiveWeekDayNamesToNumbers() {

		return Stream.of(
			Arguments.of("SUN-TUE", "0-2"),
			Arguments.of("TUE,WED,SAT", "2,3,6"),
			Arguments.of("SUN", "0"),
			Arguments.of("MON-FRI", "1-5"),
			Arguments.of("MON,TUE,WED,THU,FRI", "1,2,3,4,5")
		);
	}
}