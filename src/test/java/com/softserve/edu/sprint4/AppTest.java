package com.softserve.edu.sprint4;

import org.junit.jupiter.api.*;

public class AppTest {

    @Test
    public void checkOne() {
        System.out.println("@Test checkOne()");
        Assertions.assertEquals(4, 2 + 2);
    }

}
