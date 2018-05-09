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
    
    public String longestPalindromeSimple(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        
        if (s.length() == 1) {
            return s;
        }
        
        String result = s.substring(0, 1);
        
        for (int i = 1; i < s.length() * 2 - 2; i++){
            if (i % 2 == 1) {
                int range = Math.min((s.length() * 2 - i) / 2, i / 2 + 1);
                int leftIndex = i / 2;
                int rightIndex = i / 2 + 1;
                int leftEnd = leftIndex - range + 1;
                while (leftIndex >= leftEnd) {
                    if (s.charAt(leftIndex) == s.charAt(rightIndex)) {
                        int length = rightIndex - leftIndex + 1;
                        if (length > result.length()) {
                            result = s.substring(leftIndex, rightIndex + 1);
                        }
                        leftIndex--;
                        rightIndex++;
                    } else {
                        break;
                    }
                }
            } else {
                int range = Math.min(i / 2, s.length() - i / 2 - 1);
                int leftIndex = i / 2 - 1;
                int rightIndex = i / 2 + 1;
                int leftEnd = leftIndex - range + 1;
                while (leftIndex >= leftEnd) {
                    if (s.charAt(leftIndex) == s.charAt(rightIndex)) {
                        int length = rightIndex - leftIndex + 1;
                        if (length > result.length()) {
                            result = s.substring(leftIndex, rightIndex + 1);
                        }
                        leftIndex--;
                        rightIndex++;
                    } else {
                        break;
                    }
                }
            }
        }
        
        return result;
    }
}
