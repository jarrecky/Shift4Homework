package com.shift4.homework.utils;

import java.util.Objects;


public class Assertions {

	private Assertions() {}

	public static void assertTrue(boolean logicalValue, String message) {

		if (!logicalValue) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void assertNotNull(Object object, String message) {

		if (Objects.isNull(object)) {
			throw new NullPointerException(message);
		}
	}

	public static void assertNotEmpty(String value, String message) {

		assertTrue(Objects.nonNull(value) && !value.isBlank(), message);
	}
}
