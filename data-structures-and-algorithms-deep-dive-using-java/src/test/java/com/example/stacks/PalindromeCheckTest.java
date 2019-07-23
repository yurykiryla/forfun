package com.example.stacks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.stacks.PalindromeCheck;

class PalindromeCheckTest {
	
	PalindromeCheck classUnderTest;

	@BeforeEach
	void setUp() throws Exception {
		classUnderTest = new PalindromeCheck();
	}

	@Test
	void testIsPalindromeFewWords() {
		assertTrue(classUnderTest.isPalindrome("I did, did I?"));
	}

	@Test
	void testIsPalindromeSingleWord() {
		assertTrue(classUnderTest.isPalindrome("Racecar"));
	}
	
	@Test
	void testIsPalindromeFail() {
		assertFalse(classUnderTest.isPalindrome("hello"));
	}
}
