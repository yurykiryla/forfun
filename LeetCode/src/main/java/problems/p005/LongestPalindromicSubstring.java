package problems.p005;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000
 * 
 * @author Yury_Kiryla
 *
 */
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        
        char[] original = s.toCharArray();
        String reversedString = reverse(s);
        char[] reversed = reversedString.toCharArray();
        int[][] table = new int[original.length][original.length];
        
        String result = String.valueOf(original[0]);
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < reversed.length; j++) {
                if (i == 0 || j == 0) {
                    if(original[i] == reversed[j]) {
                        table[i][j] = 1;
                    } else {
                        table[i][j] = 0;
                    }
                } else if (original[i] == reversed[j]) {
                    int value = 1 + table[i-1][j-1];
                    table[i][j] = value;
                    if (value > result.length()) {
                        String first = s.substring(i - value + 1, i + 1);
                        String second = reversedString.substring(s.length() - i - 1, s.length() - i - 1 + value);
                        if (first.equals(second)) {
                            result = first;
                        }
                    }
                } else {
                    table[i][j] = 0;
                }
            }
        }
        
        return result;
    }
    
    private String reverse(String s) {
        char[] chars = new char[s.length()];
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            chars[start] = s.charAt(end);
            chars[end] = s.charAt(start);
            start++;
            end--;
        }
        return new String(chars);
    }
}
