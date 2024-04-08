package com.shift4.homework.description;

class ValuesListDescriptionGenerator {

	private ValuesListDescriptionGenerator() {}

	static String generateDescription(String expression) {

		return expression.replace(",", " ");
	}
}
