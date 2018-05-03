package problems.p17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 * 
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * 
 * @author Yury_Kiryla
 *
 */
class Solution {
	private Map<String, List<String>> mapping = new HashMap<>();

	Solution() {
		mapping.put("2", Arrays.asList("a", "b", "c"));
		mapping.put("3", Arrays.asList("d", "e", "f"));
		mapping.put("4", Arrays.asList("g", "h", "i"));
		mapping.put("5", Arrays.asList("j", "k", "l"));
		mapping.put("6", Arrays.asList("m", "n", "o"));
		mapping.put("7", Arrays.asList("p", "q", "r", "s"));
		mapping.put("8", Arrays.asList("t", "u", "v"));
		mapping.put("9", Arrays.asList("w", "x", "y", "z"));
	}

	public List<String> letterCombinations(String digits) {
		if (digits == null || digits.isEmpty()) {
			return Collections.emptyList();
		}
		if (digits.length() == 1) {
			return mapping.get(digits);
		} else {
			List<String> downLevelCombinations = letterCombinations(digits.substring(1, digits.length()));
			List<String> result = new ArrayList<>();
			for (String letter : mapping.get(digits.substring(0, 1))) {
				for (String combination : downLevelCombinations) {
					result.add(letter + combination);
				}
			}
			return result;
		}
	}
}