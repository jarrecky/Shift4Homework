package com.shift4.homework.cron;

class HoursCronField extends CronField {

	public HoursCronField(String expression) {

		super(0, 23, expression, "hour");
	}
}
