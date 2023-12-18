package com.softserve.edu.sprint4.task3;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Task3Test {

	@DisplayName("Checks if MyUtils is public class")
	@Test
	public void isTypePublic() {
		assertTrue(ListMapCompareTools.isTypePublic("com.softserve.edu.sprint4.task3.MyUtils"));
	}

	@DisplayName("Checks if listMapCompare method is public in class MyUtils")
	@Test
	public void isMethodPublic() {
		assertTrue(ListMapCompareTools.isMethodPublic("com.softserve.edu.sprint4.task3.MyUtils", "listMapCompare"));
	}

	@DisplayName("Using identical records in list and values in map")
	@Test
	public void checkUnique() {
		assertTrue(ListMapCompareTools.checkUnique());
	}

	@DisplayName("Using duplicate records in lis")
	@Test
	public void checkDuplicateList() {
		assertTrue(ListMapCompareTools.checkDuplicateList());
	}

	@DisplayName("Using duplicate values in map")
	@Test
	public void checkDuplicateMap() {
		assertTrue(ListMapCompareTools.checkDuplicateMap());
	}

	@DisplayName("Using duplicate records in list and values in map")
	@Test
	public void checkDuplicateAll() {
		assertTrue(ListMapCompareTools.checkDuplicateAll());
	}

	@DisplayName("Using different records in list and values in map")
	@Test
	public void checkNotEqual() {
		assertTrue(ListMapCompareTools.checkNotEqual());
	}

	@DisplayName("Using one record in list and one value in map")
	@Test
	public void checkOne() {
		assertTrue(ListMapCompareTools.checkOne());
	}

	@DisplayName("Using empty list and map")
	@Test
	public void checkEmpty() {
		assertTrue(ListMapCompareTools.checkEmpty());
	}

	@DisplayName("Using null as record in list and null as value in map")
	@Test
	public void checkNull() {
		assertTrue(ListMapCompareTools.checkNull());
	}

}
