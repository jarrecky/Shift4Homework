package com.shift4.homework.cron;

class MinutesCronField extends CronField {

	public MinutesCronField(String expression) {

		super(0, 59, expression, "minute");
	}
}
