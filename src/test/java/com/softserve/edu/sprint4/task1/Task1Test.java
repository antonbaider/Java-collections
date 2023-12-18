package com.softserve.edu.sprint4.task1;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Task1Test {
    private static CreateNotebookTools createNotebookTools;

	@DisplayName("Checks if MyUtils is public class")
	@Test
	public void isTypePublic() {
		assertTrue(CreateNotebookTools.isTypePublic("com.softserve.edu.sprint4.task1.MyUtils"));
	}

    @DisplayName("Checks if createNotebook method is public in class MyUtils")
    @Test
    public void isMethodPublic() {
        assertTrue(CreateNotebookTools.isMethodPublic("com.softserve.edu.sprint4.task1.MyUtils", "createNotebook"));
    }

    @DisplayName("Using unique names and phones in map")
    @Test
    public void checkUnique() {
        assertTrue(CreateNotebookTools.checkUnique());
    }

    @DisplayName("Using identical names and phones in map")
    @Test
    public void checkDuplicate() {
        assertTrue(CreateNotebookTools.checkDuplicate());
    }

    @DisplayName("Using one record in map")
    @Test
    public void checkOne() {
        assertTrue(CreateNotebookTools.checkOne());
    }

    @DisplayName("Using empty name in map")
    @Test
    public void checkEmptyString() {
        assertTrue(CreateNotebookTools.checkEmptyString());
    }

    @DisplayName("Checks if map is empty")
    @Test
    public void checkEmptyMap() {
        assertTrue(CreateNotebookTools.checkEmptyMap());
    }

    @DisplayName("Using empty name as null in map")
    @Test
    public void checkNull() {
        assertTrue(CreateNotebookTools.checkNull());
    }

    @DisplayName("Using name as null in map")
    @Test
    public void checkDoubleNull() {
        assertTrue(CreateNotebookTools.checkDoubleNull());
    }

    @DisplayName("Checks if phone does not duplicate in list")
    @Test
    public void checkNotEqual() {
        assertTrue(CreateNotebookTools.checkNotEqual());
    }

}
