package com.wb.asserttest;

import static org.junit.Assert.*;

import org.junit.Test;

public class AssertTest {

    
    @Test
    public void AssertTest()
    {
        int a = 1;
        assertTrue(a == 1);
        assertTrue(a != 1);
        
        assertFalse(a == 1);
        assertFalse(a != 1);
    }
}
