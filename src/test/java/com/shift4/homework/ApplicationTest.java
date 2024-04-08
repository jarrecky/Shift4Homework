/*
 * Created on 08-04-2024 02:20 by jjedlins
 *
 * Copyright (c) 2001-2024 Unity S.A.
 * ul. Strzegomska 2-4, 53-611 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Unity S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Unity S.A.
 */

package com.shift4.homework;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class ApplicationTest {

	private PrintStream originalSystemOut;
	private ByteArrayOutputStream systemOutContent;

	@BeforeEach
	void configureSystemOutStream() {

		originalSystemOut = System.out;

		systemOutContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(systemOutContent));
	}

	@AfterEach
	void restoreSystemOutStreamConfiguration() {
		System.setOut(originalSystemOut);
	}

	@Test
	void shouldPrintValidResult1() {

		// given
		String expectedResult = """
			minute        0 15 30 45
			hour          0
			day of month  1 15
			month         1 2 3 4 5 6 7 8 9 10 11 12
			day of week   1 2 3 4 5
			command       /usr/bin/find
			""";

		// when
		Application.main(new String[]{"*/15 0 1,15 * 1-5 /usr/bin/find"});

		// then
		Assertions.assertEquals(expectedResult, systemOutContent.toString());
	}

	@Test
	void shouldPrintValidResult2() {

		// given
		String expectedResult = """
			minute        0 10 20 30 40 50
			hour          0 1 2 3
			day of month  1 4 7 10 13
			month         1 2 3 4 5 6 7 8 9 10 11 12
			day of week   1 2 3 4 5
			command       /usr/bin/find
			""";

		// when
		Application.main(new String[]{"*/10 0-3 1-15/3 * MON-FRI /usr/bin/find"});

		// then
		Assertions.assertEquals(expectedResult, systemOutContent.toString());
	}

	@Test
	void shouldPrintValidResult3() {

		// given
		String expectedResult = """
			minute        0 10 20 30 40 50
			hour          0 1 2 3
			day of month  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31
			month         1 7
			day of week   1 3 5
			command       /usr/bin/find -d -f
			""";

		// when
		Application.main(new String[]{"*/10 0-3 1-31 */6 MON,WED,FRI /usr/bin/find -d -f"});

		// then
		Assertions.assertEquals(expectedResult, systemOutContent.toString());
	}
}