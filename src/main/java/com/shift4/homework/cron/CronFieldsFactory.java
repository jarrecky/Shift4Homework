package com.shift4.homework.cron;

import java.util.Arrays;
import java.util.List;

import com.shift4.homework.utils.Assertions;


public class CronFieldsFactory {

	public static List<CronField> generateCronFields(List<String> cronParts) {

		Assertions.assertNotNull(cronParts, "cronParts must not be null");
		Assertions.assertTrue(cronParts.size() == 5, "invalid number of cron expression parts");

		return Arrays.asList(
			new MinutesCronField(cronParts.get(0)),
			new HoursCronField(cronParts.get(1)),
			new DayOfMonthCronField(cronParts.get(2)),
			new MonthCronField(cronParts.get(3)),
			new DayOfWeekCronField(cronParts.get(4))
		);
	}
}
