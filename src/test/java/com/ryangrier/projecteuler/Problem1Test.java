package com.ryangrier.projecteuler;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem1Test {

    @Test
    public void testKnownSample() {
        assertEquals(23, Problem1.sumOddNumbersUpTo(10));
    }
    
    @Test
    public void testActualSolution() {
        assertEquals(233168, Problem1.sumOddNumbersUpTo(1000));
    }
}
