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
package com.ryangrier.projecteuler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * @author rwgrier
 */
public class Problem3 {
    
    public static final long largestPrimeFactorFor(long largeNumber) {
        List<Long> primeFactors = primeFactors(largeNumber);
        
        if (primeFactors == null || primeFactors.size() == 0) {
            return -1L;
        } 
        
        Collections.sort(primeFactors);
        return primeFactors.get(primeFactors.size() - 1);
    }
    
    public static void main(String[] args) {
        System.out.println("Problem 3 Solution: " + largestPrimeFactorFor(600851475143L));
    }
    
    private static final List<Long> primeFactors(long number) {
        ArrayList<Long> primeFactors= new ArrayList<Long>();
        long n = number;
        
        for (long i = 2; i <= n; i++) {
            while ((n % i) == 0) {
                primeFactors.add(i);
                n /= i;
            }
        }
        
        return primeFactors;
    }
}
