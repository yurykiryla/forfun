/**
 * 
 */
package problems.p014;

/**
 * 
 * https://leetcode.com/problems/longest-common-prefix/description/
 * 
 * Write a function to find the longest common prefix string amongst an array of
 * strings. If there is no common prefix, return an empty string "".
 * 
 * @author Yury_Kiryla
 *
 */
public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {

		String result = "";
		if (strs == null || strs.length == 0) {
			return result;
		}
		for (int i = 0; i < strs[0].length(); i++) {
			char letter = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (strs[j] == null || strs[j].length() <= i || strs[j].charAt(i) != letter) {
					return result;
				}
			}
			result = result + String.valueOf(letter);
		}
		return result;
	}

}
