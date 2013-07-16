/*
 * Copyright (c) 2013 Ryan Grier (http://www.ryangrier.com)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal 
 * in the Software without restriction, including without limitation the rights 
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.ryangrier.util;

import java.math.BigInteger;
import java.util.ArrayList;

public class FibonacciUtil {
    
    /**
     * Returns an ArrayList of Fibonacci numbers up to a given value. The maxValue will not be included. 
     * 
     * @param maxValue The max value of the Fibonacci number. This will not be included in any results.
     * @return An ArrayList of Fibonacci numbers up to a given value.
     */
    public static final ArrayList<BigInteger> generateFibonacciListUpToValue(BigInteger maxValue) {
        ArrayList<BigInteger> fibonacciNumbers = new ArrayList<BigInteger>();
        int index = 0;
        BigInteger newFibonacci = fastFibonacciDoubling(index++);
        
        while (newFibonacci.compareTo(maxValue) < 0) {
            fibonacciNumbers.add(newFibonacci);
            newFibonacci = fastFibonacciDoubling(index++);
        }
        
        return fibonacciNumbers;
    }
    
    /** 
     * Fast doubling method. Faster than the matrix method.
     * F(2n) = F(n) * (2*F(n+1) - F(n))
     * F(2n+1) = F(n+1)^2 + F(n)^2
     * 
     * Taken from here: http://nayuki.eigenstate.org/res/fast-fibonacci-algorithms/fastfibonacci.java
     */
    private static BigInteger fastFibonacciDoubling(int n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
//        int m = 0;
        for (int i = 31 - Integer.numberOfLeadingZeros(n); i >= 0; i--) {
            // Loop invariant: a = F(m), b = F(m+1)
//            assert a.equals(slowFibonacci(m));
//            assert b.equals(slowFibonacci(m+1));
            
            // Double it
            BigInteger d = multiply(a, b.shiftLeft(1).subtract(a));
            BigInteger e = multiply(a, a).add(multiply(b, b));
            a = d;
            b = e;
//            m *= 2;
//            assert a.equals(slowFibonacci(m));
//            assert b.equals(slowFibonacci(m+1));
            
            // Advance by one conditionally
            if (((n >>> i) & 1) != 0) {
                BigInteger c = a.add(b);
                a = b;
                b = c;
//                m++;
//                assert a.equals(slowFibonacci(m));
//                assert b.equals(slowFibonacci(m+1));
            }
        }
        return a;
    }
    
    /**
     * Taken from here: http://nayuki.eigenstate.org/res/fast-fibonacci-algorithms/fastfibonacci.java
     */
    private static BigInteger multiply(BigInteger x, BigInteger y) {
        return x.multiply(y);  // Replace this line with Karatsuba multiplication, etc. if available
    }
}
