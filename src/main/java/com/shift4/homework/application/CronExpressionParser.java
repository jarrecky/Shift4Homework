package com.shift4.homework.application;

import java.util.Arrays;
import java.util.List;

import com.shift4.homework.cron.CronField;
import com.shift4.homework.cron.CronFieldsFactory;
import com.shift4.homework.description.DescriptionGenerator;
import com.shift4.homework.description.DescriptionGenerator.DescriptionParameters;
import com.shift4.homework.utils.Assertions;


public class CronExpressionParser {

	public static String parseCronExpressionToHumanReadableFormat(String input) {

		Assertions.assertNotEmpty(input, "input must not be empty");

		List<String> splitExpression = Arrays.asList(input.split("\\s+"));

		Assertions.assertTrue(splitExpression.size() >= 6, "not valid input - expected at least 6 parts");

		List<String> cronParts = splitExpression.subList(0, 5);

		List<CronField> cronFieldsInOrder = CronFieldsFactory.generateCronFields(cronParts);

		StringBuilder builder = new StringBuilder();

		cronFieldsInOrder.stream()
			.map(CronExpressionParser::createDescriptionParameters)
			.map(DescriptionGenerator::generateExpressionDescription)
			.forEach(description -> {
				builder.append(description);
				builder.append("\n");
			});

		String command = String.join(" ", splitExpression.subList(5, splitExpression.size()));

		builder.append(DescriptionGenerator.generateCommandDescription(command));

		return builder.toString();
	}

	private static DescriptionParameters createDescriptionParameters(CronField cronField) {

		return new DescriptionParameters(
			cronField.getMinValue(),
			cronField.getMaxValue(),
			cronField.getExpression(),
			cronField.getReadableName()
		);
	}
}
