package com.softserve.edu.sprint4.task6;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Task6Test {

	@DisplayName("Checks if class PersonComparator present")
	@Test
	public void isTypeClassPersonComparator() {
		assertTrue(SortPeopleTools.isTypeClass("com.softserve.edu.sprint4.task6.PersonComparator"));
	}

	@DisplayName("Checks if class EmployeeComparator present")
	@Test
	public void isTypeClassEmployeeComparator() {
		assertTrue(SortPeopleTools.isTypeClass("com.softserve.edu.sprint4.task6.EmployeeComparator"));
	}

	@DisplayName("Checks if class DeveloperComparator present")
	@Test
	public void isTypeClassDeveloperComparator() {
		assertTrue(SortPeopleTools.isTypeClass("com.softserve.edu.sprint4.task6.DeveloperComparator"));
	}

	@DisplayName("Checks if the PersonComparator class implements generic Comparator interface")
	@Test
	public void implementsGenericInterfacePersonComparator() {
		assertTrue(SortPeopleTools.implementsGenericInterface("java.util.Comparator", "com.softserve.edu.sprint4.task6.PersonComparator", new String[] {"T"}));
	}

	@DisplayName("Checks if the EmployeeComparator class implements generic Comparator interface")
	@Test
	public void implementsGenericInterfaceEmployeeComparator() {
		assertTrue(SortPeopleTools.implementsGenericInterface("java.util.Comparator", "com.softserve.edu.sprint4.task6.EmployeeComparator", new String[] {"T"}));
	}

	@DisplayName("Checks if the DeveloperComparator class implements generic Comparator interface")
	@Test
	public void implementsGenericInterfaceDeveloperComparator() {
		assertTrue(SortPeopleTools.implementsGenericInterface("java.util.Comparator", "com.softserve.edu.sprint4.task6.DeveloperComparator", new String[] {"T"}));
	}

	@DisplayName("Checks if sortPeople method is present in class Utility")
	@Test
	public void hasTypeDeclaredMethod() {
		assertTrue(SortPeopleTools.hasTypeDeclaredMethod("com.softserve.edu.sprint4.task6.Utility", "sortPeople", new String[]{"class [Lcom.softserve.edu.sprint4.task6.Person;", "interface java.util.Comparator"}));
	}

	@DisplayName("Checks if sortPeople method has generic declaration")
	@Test
	public void hasParameterizedMethodTypeParameterBound() {
		assertTrue(SortPeopleTools.hasParameterizedMethodTypeParameterBound("com.softserve.edu.sprint4.task6.Utility", "sortPeople", "T", "com.softserve.edu.sprint4.task6.Person"));
	}



	@DisplayName("testSortPersonArray")
	@Test
	public void testSortPersonArray() {
		assertTrue(SortPeopleTools.testSortPersonArray());
	}

	@DisplayName("testSortEmployeeArray")
	@Test
	public void testSortEmployeeArray() {
		assertTrue(SortPeopleTools.testSortEmployeeArray());
	}

	@DisplayName("testSortDeveloperArray")
	@Test
	public void testSortDeveloperArray() {
		assertTrue(SortPeopleTools.testSortDeveloperArray());
	}

	@DisplayName("testSortDeveloperArrayUsingObjectComparator")
	@Test
	public void testSortDeveloperArrayUsingObjectComparator() {
		assertTrue(SortPeopleTools.testSortDeveloperArrayUsingObjectComparator());
	}

	@DisplayName("testSortStringArrayUsingStringComparator")
	@Test
	public void testSortStringArrayUsingStringComparator() {
		assertTrue(SortPeopleTools.testSortStringArrayUsingStringComparator());
	}


}
