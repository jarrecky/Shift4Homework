package com.shift4.homework.cron;

class DayOfMonthCronField extends CronField {

	public DayOfMonthCronField(String expression) {

		super(1, 31, expression, "day of month");
	}
}
