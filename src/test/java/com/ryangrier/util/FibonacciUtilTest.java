package com.ryangrier.util;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class FibonacciUtilTest {

    @Test
    public void testFibonacciAt0() {
        BigInteger expected = BigInteger.ZERO;
        
        performFibonacciTest(expected, 0);
    }
    
    @Test
    public void testFibonacciAt1() {
        BigInteger expected = BigInteger.ONE;
        
        performFibonacciTest(expected, 1);
    }
    
    @Test
    public void testFibonacciAt2() {
        BigInteger expected = BigInteger.ONE;
        
        performFibonacciTest(expected, 2);
    }
    
    @Test
    public void testFibonacciAt10() {
        BigInteger expected = BigInteger.valueOf(55);
        
        performFibonacciTest(expected, 10);
    }
    
    @Test
    public void testFibonacciAt20() {
        BigInteger expected = BigInteger.valueOf(6765);
        
        performFibonacciTest(expected, 20);
    }
    
    @Test
    public void testFibonacciAt40() {
        BigInteger expected = BigInteger.valueOf(102334155L);
        
        performFibonacciTest(expected, 40);
    }
    
    private void performFibonacciTest(BigInteger expected, int index) {
        assertEquals(expected, FibonacciUtil.fastFibonacciDoubling(index));
//        assertEquals(expected, FibonacciUtil.goldenRuleFibonacci(index));
    }

}
