/*
 * Created on 08-04-2024 02:04 by jjedlins
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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class ValuesListDescriptionGeneratorTest {

	@ParameterizedTest
	@ValueSource(strings = {"1,2,5", "3", "1,2,3,4,5,6,7,8,9,10,11,12"})
	void shouldGenerateDescriptionForValuesList(String expression) {

		// given
		String expectedResult = expression.replace(",", " ");

		// when
		String result = ValuesListDescriptionGenerator.generateDescription(expression);

		// then
		Assertions.assertEquals(expectedResult, result);
	}
}