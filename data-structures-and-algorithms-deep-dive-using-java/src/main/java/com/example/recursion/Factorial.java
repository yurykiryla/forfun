/**
 * 
 */
package com.example.recursion;

/**
 * @author yuryk
 *
 */
public class Factorial {
	
	public int iterativeFactorial(int n) {
		if (n < 0) {
			throw new UnsupportedOperationException();
		}

		int result = 1;
		for (int i = 2; i <= n; i++) {
			result *= i;
		}
		return result;
	}

	public int recursiveFactorial(int n) {
		if (n < 0) {
			throw new UnsupportedOperationException();
		}
		if (n == 0) {
			return 1;
		}
		return n * recursiveFactorial(n - 1);
	}
}
