package com.example.queues;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
