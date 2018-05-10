package problems.p008;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 * 
 * Implement atoi which converts a string to an integer.
 * 
 * The function first discards as many whitespace characters as necessary until the first non-whitespace 
 * character is found. Then, starting from this character, takes an optional initial plus or minus sign 
 * followed by as many numerical digits as possible, and interprets them as a numerical value.
 * 
 * The string can contain additional characters after those that form the integral number, which are ignored 
 * and have no effect on the behavior of this function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such 
 * sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned.
 * 
 * Note:
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: 
 * [−2^31,  2^31 − 1]. If the numerical value is out of the range of representable values, INT_MAX (2^31 − 1) or 
 * INT_MIN (−2^31) is returned.

 * @author Yury_Kiryla
 *
 */
public class StringToInteger_atoi {
	
	public int myAtoi(String str) {
        int result = 0;
        boolean started = false;
        boolean negative = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (!started && c == ' ') {
                continue;
            }
            if (!started && c == '-') {
                negative = true;
                started = true;
            } else if (!started && c == '+') {
                started = true;
            } else if (!started && Character.isDigit(c)) {
                started = true;
                int value = Character.getNumericValue(c);
                if (value != 0) {
                    result = negative ? -value : value;
                }
            } else if (Character.isDigit(c)) {
                int value = Character.getNumericValue(c);
                if (result == 0 && value != 0) {
                    result = negative ? -value : value;
                } else if (negative) {
                    int newResult = result * 10 - value % 10;
                    if ((newResult + value % 10) / 10 != result) {
                        result = Integer.MIN_VALUE;
                        break;
                    }
                    result = newResult;
                } else {
                    int newResult = result * 10 + value % 10;
                    if ((newResult - value % 10) / 10 != result || newResult < 0) {
                        result = Integer.MAX_VALUE;
                        break;
                    }
                    result = newResult;
                }
            } else {
                break;
            }
        }
        
        return result;
    }

}
