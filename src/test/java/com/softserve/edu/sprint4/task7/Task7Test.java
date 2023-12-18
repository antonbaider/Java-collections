package com.softserve.edu.sprint4.task7;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task7Test {

	@DisplayName("Checks if CAMEL CASE PATTERN constant is present in class CheckCamelCase")
	@Test
	public void isConstantPatternPresent() {
		assertTrue(CheckAndPrintTools.isConstantPatternPresent());
	}

	@DisplayName("Checks if annotation CamelCase created")
	@Test
	public void isPublicInterface() {
		assertTrue(CheckAndPrintTools.isPublicInterface("com.softserve.edu.sprint4.task7.CamelCase"));
	}

	@DisplayName("Checks if annotation @Target is used with CamelCase")
	@Test
	public void isTargetMethod() {
		assertTrue(CheckAndPrintTools.isTargetMethod("com.softserve.edu.sprint4.task7.CamelCase"));
	}

	@DisplayName("Checks if annotation @Retention is used with CamelCase")
	@Test
	public void isRetentionRuntime() {
		assertTrue(CheckAndPrintTools.isRetentionRuntime("com.softserve.edu.sprint4.task7.CamelCase"));
	}

	/* TODO Uncomment

	@DisplayName("Validate methods of ClassForAnnot")
	@Test
	public void checkClassForAnnot() {
		assertFalse(CheckAndPrintTools.checkClassForAnnot());
	}

	@DisplayName("Validate methods of Class1")
	@Test
	public void checkClass1() {
		assertFalse(CheckAndPrintTools.checkClass1());
	}

	@DisplayName("Validate methods of Class2")
	@Test
	public void checkClass2() {
		assertTrue(CheckAndPrintTools.checkClass2());
	}

	*/
}
