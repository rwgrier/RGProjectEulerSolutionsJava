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
