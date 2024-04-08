package com.shift4.homework.cron;

import java.util.List;

import com.shift4.homework.utils.Assertions;
import com.shift4.homework.utils.StringUtils;


public abstract class CronField {

	private final int minValue;
	private final int maxValue;
	private final String expression;
	private final String readableName;

	CronField(int minValue, int maxValue, String expression, String readableName) {

		Assertions.assertTrue(minValue >= 0, "minValue must be positive");
		Assertions.assertTrue(maxValue > minValue, "maxValue must be greater than minValue");
		Assertions.assertNotEmpty(readableName, "readableName must not be empty");

		this.minValue = minValue;
		this.maxValue = maxValue;
		this.readableName = readableName;

		validateExpression(expression);
		this.expression = adjustExpression(expression);
	}

	public int getMinValue() {
		return minValue;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public String getExpression() {
		return expression;
	}

	public String getReadableName() {
		return readableName;
	}

	String adjustExpression(String expression) {

		return expression.trim();
	}

	private void validateExpression(String expression) {

		Assertions.assertNotEmpty(expression, "expression must not be empty");
		validateAllNumbersInValidRange(expression);
	}

	private void validateAllNumbersInValidRange(String expression) {

		List<Integer> numbersInExpression = StringUtils.extractAllNumbersFromString(expression);

		numbersInExpression.stream()
			.filter(this::numberNotInValidRange)
			.findAny()
			.ifPresent(invalidNumber -> {
				throw new IllegalArgumentException(invalidNumber + " is not allowed in expression: " + expression);
			});
	}

	private boolean numberNotInValidRange(Integer number) {

		return number < minValue || number > maxValue;
	}
}
