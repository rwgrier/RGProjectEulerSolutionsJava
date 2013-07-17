package com.ryangrier.projecteuler;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem3Test {

    @Test
    public void testKnownSample() {
        // The prime factors of 13195 are 5, 7, 13 and 29.
        assertEquals(29L, Problem3.largestPrimeFactorFor(13195L));
    }
    
    @Test
    public void testActualSolution() {
        assertEquals(6857L, Problem3.largestPrimeFactorFor(600851475143L));
    }
}
