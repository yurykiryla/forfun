package problems.p005;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LongestPalindromicSubstringTest {
	
	LongestPalindromicSubstring solution;

	@BeforeEach
	void setUp() throws Exception {
		solution = new LongestPalindromicSubstring();
	}

	@Test
	void testLongestPalindrome_babad() {
		String s = "babad";
		Set<String> expected = Set.of("bab", "aba");
		String actual = solution.longestPalindrome(s);
		assertTrue(expected.contains(actual));
	}
	
	@Test
	void testLongestPalindrome_abcfgcbx() {
		String s = "abcfgcbx";
		Set<String> expected = Set.of("a", "b", "c", "f", "g", "x");
		String actual = solution.longestPalindrome(s);
		assertTrue(expected.contains(actual));
	}
	
	@Test
	void testLongestPalindrome_cbbd() {
		String s = "cbbd";
		Set<String> expected = Set.of("bb");
		String actual = solution.longestPalindrome(s);
		assertTrue(expected.contains(actual));
	}
	
	@Test
	void testLongestPalindrome_bbcc() {
		String s = "bbcc";
		Set<String> expected = Set.of("bb", "cc");
		String actual = solution.longestPalindrome(s);
		assertTrue(expected.contains(actual));
	}
	
	@Test
	void testLongestPalindrome_abb() {
		String s = "abb";
		Set<String> expected = Set.of("bb");
		String actual = solution.longestPalindrome(s);
		assertTrue(expected.contains(actual));
	}
}
