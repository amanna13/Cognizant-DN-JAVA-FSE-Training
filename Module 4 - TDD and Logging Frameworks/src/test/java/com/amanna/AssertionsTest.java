package com.amanna;

import org.junit.Test;

import static org.junit.Assert.*;
public class AssertionsTest {

    @Test
    public void assertTest() {

        assertEquals(5, 3+2);
        assertTrue(4 < 5 );
        assertFalse(5 > 10);
        assertNull(null);

        assertNotNull(new Object());
    }
  
}