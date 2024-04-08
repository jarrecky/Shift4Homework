/*
 * Created on 08-04-2024 02:10 by jjedlins
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


class ExpressionTypeTest {

	@ParameterizedTest
	@MethodSource("parametersForShouldDetermineTypeForExpression")
	void shouldDetermineTypeForExpression(String expression, ExpressionType expectedType) {

		// when
		ExpressionType expressionType = ExpressionType.determineForExpression(expression);

		// then
		Assertions.assertEquals(expectedType, expressionType);
	}

	private static Stream<Arguments> parametersForShouldDetermineTypeForExpression() {

		return Stream.of(
			Arguments.of("*", ExpressionType.ANY_VALUE),
			Arguments.of("1,3,5,10", ExpressionType.VALUES_LIST),
			Arguments.of("5", ExpressionType.VALUES_LIST),
			Arguments.of("3-5", ExpressionType.VALUES_RANGE),
			Arguments.of("6-6", ExpressionType.VALUES_RANGE),
			Arguments.of("*/10", ExpressionType.STEP_VALUES),
			Arguments.of("5-10/2", ExpressionType.STEP_VALUES_WITH_RANGE),
			Arguments.of("1-30/7", ExpressionType.STEP_VALUES_WITH_RANGE)
		);
	}
}