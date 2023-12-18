package com.softserve.edu.sprint4.task2;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Task2Test {

	@DisplayName("Checks if MyUtils is public class")
	@Test
	public void isTypePublic() {
		assertTrue(CommonStudentsTools.isTypePublic("com.softserve.edu.sprint4.task2.MyUtils"));
	}

	@DisplayName("Checks if commonStudents method is public in class MyUtils")
	@Test
	public void isMethodPublic() {
		assertTrue(CommonStudentsTools.isMethodPublic("com.softserve.edu.sprint4.task2.MyUtils", "commonStudents"));
	}

	@DisplayName("Using parameters without duplicate objects of Student")
	@Test
	public void checkUnique() {
		assertTrue(CommonStudentsTools.checkUnique());
	}

	@DisplayName("Using duplicate id in lists of Student")
	@Test
	public void checkDuplicateId() {
		assertTrue(CommonStudentsTools.checkDuplicateId());
	}

	@DisplayName("Using duplicate names in lists of Student")
	@Test
	public void checkDuplicateNames() {
		assertTrue(CommonStudentsTools.checkDuplicateNames());
	}

	@DisplayName("Using identical objects of the Student class in lists")
	@Test
	public void checkExistCommon() {
		assertTrue(CommonStudentsTools.checkExistCommon());
	}

	@DisplayName("Using identical lists of Student class")
	@Test
	public void checkEqualLists() {
		assertTrue(CommonStudentsTools.checkEqualLists());
	}

	@DisplayName("Using identical lists of Student class")
	@Test
	public void checkEmptySecondList() {
		assertTrue(CommonStudentsTools.checkEmptySecondList());
	}

	@DisplayName("Check if second list is empty")
	@Test
	public void checkEmptyLists() {
		assertTrue(CommonStudentsTools.checkEmptyLists());
	}

	@DisplayName(" Check if name is null in objects of Student")
	@Test
	public void checkNullString() {
		assertTrue(CommonStudentsTools.checkNullString());
	}
}
