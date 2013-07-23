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
