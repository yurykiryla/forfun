package problems.p003;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be 
 * a substring, "pwke" is a subsequence and not a substring.
 * 
 * @author Катя
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int result = 1;
        
        //"pwwkew"tmmzuxt"abcabcbb"bbbbb"
        Map<Character, Integer> chars = new HashMap<>();
        int last = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            int sequence = 0;
            if (chars.containsKey(current)) {
                int index = chars.put(current, i);
                if (index >= last) {
                    sequence = i - index;
                    last = i;
                } else {
                    sequence = i - last + 1;
                }
            } else {
                chars.put(current, i);
                sequence = i - last + 1;
            }
            result = Math.max(result, sequence);
        }
        return result;
    }
	
	public int lengthOfLongestSubstringDoubleLoop(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int result = 1;
        
        int pointer = 0;
        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            int count = 1;
            for (int j = pointer; j < i; j++) {
                if (s.charAt(j) != current) {
                    count++;
                } else {
                    count = 0;
                    pointer = j + 1;
                }
            }
            if (count > result) {
                result = count;
            }
        }
        
        return result;
    }
}
