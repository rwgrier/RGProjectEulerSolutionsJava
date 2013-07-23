package com.ryangrier.projecteuler;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem4Test {

    @Test
    public void testKnownSample() {
        // The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 x 99.
        assertEquals(9009, Problem4.largestPalindromeFor(2));
    }
    
    @Test
    public void testActualSolution() {
        // Tried 11481 combinations.
        assertEquals(906609, Problem4.largestPalindromeFor(3));
    }

}
