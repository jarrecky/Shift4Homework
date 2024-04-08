package com.shift4.homework.cron;

import java.util.Map;


class DayOfWeekCronField extends CronField {

	private static final Map<String, String> DESCRIPTIVE_DAY_OF_WEEK_TO_NUMBERS_MAP = Map.of(
		"SUN", "0",
		"MON", "1",
		"TUE", "2",
		"WED", "3",
		"THU", "4",
		"FRI", "5",
		"SAT", "6"
	);

	public DayOfWeekCronField(String expression) {

		super(0, 6, expression, "day of week");
	}

	@Override
	public String adjustExpression(String expression) {

		expression =  super.adjustExpression(expression);

		for (Map.Entry<String, String> entry : DESCRIPTIVE_DAY_OF_WEEK_TO_NUMBERS_MAP.entrySet()) {
			expression = expression.replace(entry.getKey(), entry.getValue());
		}

		return expression;
	}
}
