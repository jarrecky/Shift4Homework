package com.shift4.homework.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtils {

	private StringUtils(){}

	public static List<Integer> extractAllNumbersFromString(String text) {

		if (Objects.isNull(text)) {
			return Collections.emptyList();
		}

		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(text);

		List<Integer> result = new ArrayList<>();
		while (matcher.find()) {

			String group = matcher.group();
			int intValue = Integer.parseInt(group);

			result.add(intValue);
		}

		return List.copyOf(result);
	}

	public static String padWithSpaces(String value, int desiredLength) {

		return String.format("%-" + desiredLength + "s", value);
	}
}
