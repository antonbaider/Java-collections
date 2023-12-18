package com.softserve.edu.sprint4.task5;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Task5Test {

	@DisplayName("Checks if averageValue method has parameters: array of Array")
	@Test
	public void hasTypeDeclaredMethod() {
		assertTrue(AverageValueTools.hasTypeDeclaredMethod("com.softserve.edu.sprint4.task5.ArrayUtil", "averageValue", new String[] {"class com.softserve.edu.sprint4.task5.Array"}));
	}

	@DisplayName("Checks if averageValue method is return value of double.class")
	@Test
	public void hasMethodReturnType() {
		assertTrue(AverageValueTools.hasMethodReturnType("com.softserve.edu.sprint4.task5.ArrayUtil", "averageValue", double.class));
	}

	/* TODO Uncomment

	@DisplayName("Checks if 'averageValue' method calculate average of Integer values")
	@Test
	public void averageValueInteger() {
		assertTrue(AverageValueTools.averageValueInteger());
	}

	@DisplayName("Checks if 'averageValue' method calculate average of Double values")
	@Test
	public void averageValueDouble() {
		assertTrue(AverageValueTools.averageValueDouble());
	}

	@DisplayName("Checks if 'averageValue' method calculate average of Float values")
	@Test
	public void averageValueFloat() {
		assertTrue(AverageValueTools.averageValueFloat());
	}

	*/
}
