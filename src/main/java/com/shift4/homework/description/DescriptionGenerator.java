package com.shift4.homework.description;

import static com.shift4.homework.utils.StringUtils.padWithSpaces;

import com.shift4.homework.utils.Assertions;


public class DescriptionGenerator {

	protected static final int FIRST_COLUMN_DESIRED_WIDTH = 14;

	public static String generateExpressionDescription(DescriptionParameters parameters) {

		Assertions.assertNotNull(parameters, "parameters must not be null");

		String expressionDescription = dispatchExpressionDescriptionGeneration(parameters);

		String readableName = parameters.readableName();

		return padWithSpaces(readableName, FIRST_COLUMN_DESIRED_WIDTH) + expressionDescription;
	}

	public static String generateCommandDescription(String command) {

		return padWithSpaces("command", FIRST_COLUMN_DESIRED_WIDTH) + command;
	}

	private static String dispatchExpressionDescriptionGeneration(DescriptionParameters parameters) {

		int minValue = parameters.minValue();
		int maxValue = parameters.maxValue();
		String expression = parameters.expression();

		ExpressionType type = ExpressionType.determineForExpression(expression);

		return switch (type) {
			case ANY_VALUE -> AnyValueDescriptionGenerator.generateDescription(minValue, maxValue);
			case VALUES_LIST -> ValuesListDescriptionGenerator.generateDescription(expression);
			case VALUES_RANGE -> ValuesRangeDescriptionGenerator.generateDescription(expression);
			case STEP_VALUES -> StepValuesDescriptionGenerator.generateDescription(expression, minValue, maxValue);
			case STEP_VALUES_WITH_RANGE -> StepValuesWithRangeDescriptionGenerator.generateDescription(expression);
		};
	}

	public record DescriptionParameters(
		int minValue,
		int maxValue,
		String expression,
		String readableName
	){}
}
