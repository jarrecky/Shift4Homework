/*
 * Created on 08-04-2024 02:14 by jjedlins
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

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CronFieldsFactoryTest {

	@Test
	void shouldCreateCronFieldInProperOrder() {

		// given
		List<String> cronParts = List.of("*", "*", "*", "*", "*");

		// when
		List<CronField> cronFields = CronFieldsFactory.generateCronFields(cronParts);

		// then
		Assertions.assertInstanceOf(MinutesCronField.class, cronFields.get(0));
		Assertions.assertInstanceOf(HoursCronField.class, cronFields.get(1));
		Assertions.assertInstanceOf(DayOfMonthCronField.class, cronFields.get(2));
		Assertions.assertInstanceOf(MonthCronField.class, cronFields.get(3));
		Assertions.assertInstanceOf(DayOfWeekCronField.class, cronFields.get(4));
	}
}