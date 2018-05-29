/**
 * 
 */
package problems.p043;

/**
 * https://leetcode.com/problems/multiply-strings/description/
 * 
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, 
 * also represented as a string.
 * 
 * Example 1:
 * 
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * 
 * 
 * Example 2:
 * 
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * 
 * Note:
 *    The length of both num1 and num2 is < 110.
 *    Both num1 and num2 contain only digits 0-9.
 *    Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 *    You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * 
 * @author Yury_Kiryla
 *
 */
public class MultiplyStrings {
	
	public String multiply(String num1, String num2) {
        if (num1 == null || num1.isEmpty() || num1.equals("0") || num2 == null || num2.isEmpty() || num2.equals("0")) {
            return "0";
        }
        if (num1.equals("1")) {
            return num2;
        }
        if (num2.equals("1")) {
            return num1;
        }
        
        int[] ints1 = convert(num1);
        int[] ints2 = convert(num2);
        int[] result = new int[num1.length() + num2.length()];
        
        for (int i = ints1.length - 1; i >= 0; i--) {
            int next = 0;
            for (int j = ints2.length - 1; j >= 0; j--) {
                int current = ints1[i] * ints2[j] + next;
                result[i + j + 1] += current % 10;
                next = current / 10;
                if (result[i + j + 1] >= 10) {
                    next++;
                    result[i + j + 1] -= 10;
                }
            }
            result[i] += next;
        }
        
        int i = result[0] == 0 ? 1 : 0;
        String resultStr = "";
        for (;i < result.length; i++) {
            resultStr = resultStr + result[i];
        }
        return resultStr;
    }
    
    int[] convert(String str) {
        int[] result = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(i) - '0';
        }
        return result;
    }

}
