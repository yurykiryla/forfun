package problems.p264;

/**
 * https://leetcode.com/problems/ugly-number-ii/description/ Write a program to
 * find the n-th ugly number. Ugly numbers are positive numbers whose prime
 * factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is
 * the sequence of the first 10 ugly numbers. Note that 1 is typically treated
 * as an ugly number, and n does not exceed 1690.
 * 
 * @author Катя
 *
 */
public class UglyNumberII {
	public int nthUglyNumber(int n) {
		int[] numbers = new int[n];
		numbers[0] = 1;
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		int next2 = 2;
		int next3 = 3;
		int next5 = 5;
		for (int i = 1; i < n; i++) {
			int next = Math.min(Math.min(next2, next3), next5);
			numbers[i] = next;

			if (next == next2) {
				i2++;
				next2 = numbers[i2] * 2;
			} else if (next == next3) {
				i3++;
				next3 = numbers[i3] * 3;
			} else {
				i5++;
				next5 = numbers[i5] * 5;
			}
		}
		return numbers[n - 1];

	}
}
