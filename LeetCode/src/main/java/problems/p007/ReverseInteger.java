package problems.p007;

/**
 * https://leetcode.com/problems/reverse-integer/description/
 * 
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 
 * 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume 
 * that your function returns 0 when the reversed integer overflows.
 * 
 * @author Катя
 *
 */
public class ReverseInteger {
	public int reverse(int x) {
		if (x > -10 && x < 10) {
			return x;
		}

		long result = 0;
		while (x != 0) {
			result = result * 10 + x % 10;
			x = x / 10;
		}
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			result = 0;
		}
		return (int) result;
	}
}
