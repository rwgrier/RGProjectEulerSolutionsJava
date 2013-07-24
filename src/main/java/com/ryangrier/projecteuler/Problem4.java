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

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 x 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * @author rwgrier
 */
public class Problem4 {
    
    public static final int largestPalindromeFor(int xDigitNumber) {
        double power = Math.pow(10, xDigitNumber);
        double lowerRange = Math.pow(10, xDigitNumber - 1); // Only testing x digit numbers.
        int x = (int) power - 1;
        int y = x;
        
//        System.out.println("Testing numbers between: " + lowerRange + " and " + power);
        
        int largest = 0;
//        int count = 0;
        
        for (int i = x; i >= lowerRange; i--) {
            for (int j = y; j >= lowerRange; j--) {
                int test = i * j;
//                count++;
                
                if (isPalindrome(test) && (test > largest)) {
//                    System.out.println("Palindrome Found: " + test + " (" + i + "," + j + ")");
                    largest = test;  
                    lowerRange = Math.min(i, j); // Adjust the lower range to stop here.
                }
            }
        }
        
//        System.out.println("Number Tested: " + count);
//        System.out.println("Answer: " + largest);
        
        return largest;
    }
    
    public static void main(String[] args) {
        System.out.println("Problem 4 Solution: " + largestPalindromeFor(3));
    }
    
    private static boolean isPalindrome(int testNumber) {
        String testString = String.valueOf(testNumber);
        String backwards = new StringBuilder(testString).reverse().toString();
        
        return backwards.equals(testString);
    }
}
