package com.shift4.homework.cron;

import static com.shift4.homework.utils.CollectionUtils.mapEntry;

import java.util.Map;
import java.util.Map.Entry;


class MonthCronField extends CronField {

	private static final Map<String, String> DESCRIPTIVE_MONTH_TO_NUMBERS_MAP = Map.ofEntries(
		mapEntry("JAN", "1"),
		mapEntry("FEB", "2"),
		mapEntry("MAR", "3"),
		mapEntry("APR", "4"),
		mapEntry("MAY", "5"),
		mapEntry("JUN", "6"),
		mapEntry("JUL", "7"),
		mapEntry("AUG", "8"),
		mapEntry("SEP", "9"),
		mapEntry("OCT", "10"),
		mapEntry("NOV", "11"),
		mapEntry("DEC", "12")
	);

	public MonthCronField(String expression) {

		super(1, 12, expression, "month");
	}

	@Override
	public String adjustExpression(String expression) {

		expression = super.adjustExpression(expression);

		for (Entry<String, String> entry : DESCRIPTIVE_MONTH_TO_NUMBERS_MAP.entrySet()) {
			expression = expression.replace(entry.getKey(), entry.getValue());
		}

		return expression;
	}
}
