package com.softserve.edu.sprint4.task4;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Task4Test {

	@DisplayName("Checks if setAndReturn method is public and has generic declaration")
	@Test
	public void isMethodParameterized() {
		assertTrue(SetAndReturnTools.isMethodParameterized("com.softserve.edu.sprint4.task4.ArrayUtil", "setAndReturn", new String[]{"T"}));
	}

	@DisplayName("Checks if setAndReturn method has parameters: array of T, value of T and int")
	@Test
	public void hasTypeDeclaredMethod() {
		assertTrue(SetAndReturnTools.hasTypeDeclaredMethod("com.softserve.edu.sprint4.task4.ArrayUtil", "setAndReturn", new String[]{"class [Ljava.lang.Object;", "class java.lang.Object", "int"}));
	}

	@DisplayName("Checks if setAndReturn method is return value of T")
	@Test
	public void hasMethodParameterizedReturnType() {
		assertTrue(SetAndReturnTools.hasMethodParameterizedReturnType("com.softserve.edu.sprint4.task4.ArrayUtil", "setAndReturn", "T"));
	}

	/*  TODO  Uncomment

	@DisplayName("Checks if setAndReturn method is return second element of array as Integer")
	@Test
	public void testNumberFromSecondPosition() {
		assertTrue(SetAndReturnTools.testNumberFromSecondPosition());
	}

	@DisplayName("Checks if setAndReturn method is return second element of array as String")
	@Test
	public void testWordFromSecondPosition() {
		assertTrue(SetAndReturnTools.testWordFromSecondPosition());
	}

	@DisplayName("Checks if setAndReturn method is return second element of array as Date")
	@Test
	public void testDateFromSecondPosition() {
		assertTrue(SetAndReturnTools.testDateFromSecondPosition());
	}

	*/

}
