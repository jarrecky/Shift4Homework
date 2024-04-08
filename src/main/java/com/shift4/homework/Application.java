package com.shift4.homework;

import com.shift4.homework.application.CronExpressionParser;


public class Application {

	public static void main(String[] args) {

		String result = CronExpressionParser.parseCronExpressionToHumanReadableFormat(args[0]);

		System.out.println(result);
	}
}
