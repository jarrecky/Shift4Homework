package com.shift4.homework.description;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


enum ExpressionType {

	ANY_VALUE("^\\*$"),
	VALUES_LIST("^\\d{1,2}(,\\d{1,2})*$"),
	VALUES_RANGE("^\\d{1,2}-\\d{1,2}$"),
	STEP_VALUES("^\\*/\\d{1,2}$"),
	STEP_VALUES_WITH_RANGE("^\\d{1,2}-\\d{1,2}/\\d{1,2}$");

	private final String regex;

	ExpressionType(String regex) {

		this.regex = regex;
	}

	static ExpressionType determineForExpression(String expression) {

		Objects.requireNonNull(expression);

		List<ExpressionType> matchingTypes = Arrays.stream(values())
			.filter(value -> value.matchesExpression(expression))
			.toList();

		if (matchingTypes.size() != 1) {
			throw new IllegalStateException("could not determine type for expression: " + expression);
		}

		return matchingTypes.get(0);
	}

	private boolean matchesExpression(String expression) {

		return expression.matches(regex);
	}
}
