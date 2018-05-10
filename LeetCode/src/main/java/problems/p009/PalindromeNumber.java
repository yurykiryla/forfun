package problems.p009;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-number/description/
 * 
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * 
 * @author Yury_Kiryla
 *
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        List<Integer> digits = new ArrayList<>();
        while( x >= 10) {
            int digit = x % 10;
            digits.add(digit);
            x = x / 10;
        }
        digits.add(x);
        
        int start = 0;
        int end = digits.size() - 1;
        while (start < end) {
            if (digits.get(start) != digits.get(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
