package com.prabhash.java.interview.recursion;

/**
 * Given infinite number of Quarters (25), Dimes (10), Nickels (5) and Pennies (1), write a program to find the number of ways in which
 * given number of cents can be represented.
 * 
 * @author Prabhash Rathore
 *
 */
public class WaysToRepresentCents {
	
	/**
	 * Method 1:
	 * Keep subtracting each cent until you find the desired sum. If sum < 0, invalid pattern, return. If n == 0, found the right pattern,
	 * return 1. Final sum is to add total count which is formed from 25, 10, 5 and 1 cents combination. 
	 * 
	 * Time Complexity: O(4 ^ n) 
	 * 
	 * @param n
	 * @return int
	 */
	public static int getNumberOfWaysToRepresentCents(int n) {
		if(n < 0) {
			throw new IllegalArgumentException();
		}
		
		if(n == 0) {
			return 0;
		}
		
		int count = numberOfWaysToRepresentCentsHelper(n);
		return count;
	}
	
	private static int numberOfWaysToRepresentCentsHelper(int n) {
		if(n < 0) {
			return 0;
		}
		
		if(n == 0) {
			return 1;
		}
		
		int count = 0;
		if(n >= 25) {
			count += numberOfWaysToRepresentCentsHelper(n - 25);
		}
		
		if(n >= 10) {
			count += numberOfWaysToRepresentCentsHelper(n - 10);
		}
		
		if(n >= 5) {
			count += numberOfWaysToRepresentCentsHelper(n - 5);
		}
		
		if(n >= 1) {
			count += numberOfWaysToRepresentCentsHelper(n - 1);
		}
		
		return count;
	}
	
	/**
	 * Method 2:
	 * Using Dynamic Programming, find number of ways to represent given number of cents using combination of quarters, dimes, nickels and
	 * pennies.
	 * 
	 * @param n
	 * @return int
	 */
	public static int findTotalCombinationsOfCentsOptimized(int n) {
		if(n < 0) {
			throw new IllegalArgumentException("Negative cents is invalid!");
		}
		
		int[] cache = new int[n + 1];
		return findTotalCombinationsOfCentsOptimizedHelper(n, cache);
	}
	
	private static int findTotalCombinationsOfCentsOptimizedHelper(int n, int[] cache) {
		if(n < 0) {
			return 0;
		}
		
		if(n == 0) {
			return 1;
		}
		
		if(cache[n] > 0) {
			return cache[n];
		}
		
		int count = 0;
		if(n >= 25) {
			count += findTotalCombinationsOfCentsOptimizedHelper(n - 25, cache);
		}
		
		if(n >= 10) {
			count += findTotalCombinationsOfCentsOptimizedHelper(n - 10, cache);
		}
		
		if(n >= 5) {
			count += findTotalCombinationsOfCentsOptimizedHelper(n - 5, cache);
		}
		
		if(n >= 1) {
			count += findTotalCombinationsOfCentsOptimizedHelper(n - 1, cache);
		}
		
		cache[n] = count;
		return count;
	}
	
	public static void main(String[] args) {
		int n = 10;
		int numberOfWays = getNumberOfWaysToRepresentCents(n);
		System.out.println("Number of ways to represent " + n + " cents = " + numberOfWays);
		
		int x = 100;
		int numberOfWays2 = findTotalCombinationsOfCentsOptimized(x);
		System.out.println("Number of ways to represent " + x + " cents = " + numberOfWays2);
	}
}
