package problems.p003;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LongestSubstringWithoutRepeatingCharactersTest {
	
	LongestSubstringWithoutRepeatingCharacters solution;

	@BeforeEach
	void setUp() throws Exception {
		solution = new LongestSubstringWithoutRepeatingCharacters();
	}

	@Test
	void testLengthOfLongestSubstring_abcabcbb() {
		String s = "abcabcbb";
		int expected = 3;
		int actual = solution.lengthOfLongestSubstring(s);
		assertEquals(expected, actual);
	}
	
	@Test
	void testLengthOfLongestSubstring_bbbbb() {
		String s = "bbbbb";
		int expected = 1;
		int actual = solution.lengthOfLongestSubstring(s);
		assertEquals(expected, actual);
	}
	
	@Test
	void testLengthOfLongestSubstring_pwwkew() {
		String s = "pwwkew";
		int expected = 3;
		int actual = solution.lengthOfLongestSubstring(s);
		assertEquals(expected, actual);
	}
	
	@Test
	void testLengthOfLongestSubstring_tmmzuxt() {
		String s = "tmmzuxt";
		int expected = 5;
		int actual = solution.lengthOfLongestSubstring(s);
		assertEquals(expected, actual);
	}
	
	@Test
	void testLengthOfLongestSubstring_dvdf() {
		String s = "dvdf";
		int expected = 5;
		int actual = solution.lengthOfLongestSubstring(s);
		assertEquals(expected, actual);
	}

	@Test
	void testLengthOfLongestSubstringDoubleLoop_abcabcbb() {
		String s = "abcabcbb";
		int expected = 3;
		int actual = solution.lengthOfLongestSubstringDoubleLoop(s);
		assertEquals(expected, actual);
	}
	
	@Test
	void testLengthOfLongestSubstringDoubleLoop_bbbbb() {
		String s = "bbbbb";
		int expected = 1;
		int actual = solution.lengthOfLongestSubstringDoubleLoop(s);
		assertEquals(expected, actual);
	}
	
	@Test
	void testLengthOfLongestSubstringDoubleLoop_pwwkew() {
		String s = "pwwkew";
		int expected = 3;
		int actual = solution.lengthOfLongestSubstringDoubleLoop(s);
		assertEquals(expected, actual);
	}
	
	@Test
	void testLengthOfLongestSubstringDoubleLoop_tmmzuxt() {
		String s = "tmmzuxt";
		int expected = 5;
		int actual = solution.lengthOfLongestSubstringDoubleLoop(s);
		assertEquals(expected, actual);
	}

	@Test
	void testLengthOfLongestSubstringDoubleLoop_dvdf() {
		String s = "dvdf";
		int expected = 5;
		int actual = solution.lengthOfLongestSubstringDoubleLoop(s);
		assertEquals(expected, actual);
	}
}
