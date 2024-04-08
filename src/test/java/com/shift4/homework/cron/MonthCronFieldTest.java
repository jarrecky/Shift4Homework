/*
 * Created on 08-04-2024 01:23 by jjedlins
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


class MonthCronFieldTest {

	@ParameterizedTest
	@MethodSource("parametersForShouldChangeDescriptiveMonthNamesToNumbers")
	void shouldChangeDescriptiveMonthNamesToNumbers(String expression, String adjustedExpression) {

		// when
		MonthCronField monthCronField = new MonthCronField(expression);

		// then
		Assertions.assertEquals(adjustedExpression, monthCronField.getExpression());
	}

	private static Stream<Arguments> parametersForShouldChangeDescriptiveMonthNamesToNumbers() {

		return Stream.of(
			Arguments.of("JAN", "1"),
			Arguments.of("FEB-AUG", "2-8"),
			Arguments.of("JAN-DEC", "1-12"),
			Arguments.of("JAN,FEB,MAR,APR,MAY,JUN,JUL,AUG,SEP,OCT,NOV,DEC", "1,2,3,4,5,6,7,8,9,10,11,12")
		);
	}
}