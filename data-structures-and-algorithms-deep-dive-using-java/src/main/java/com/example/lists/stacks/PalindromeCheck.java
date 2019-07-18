package com.example.lists.stacks;

import java.util.Stack;

public class PalindromeCheck {
	public boolean isPalindrome(String phrase) {
		if(phrase == null || phrase.isBlank()) {
			return true;
		}
		String text = preprocess(phrase);
		
		if(text == null || text.isBlank()) {
			return true;
		}
		
		Stack<Character> stack = new Stack<>();
		char[] letters = text.toCharArray();
		for (int i = 0; i < letters.length; i++) {
			stack.push(letters[i]);
		}
		
		for (int i = 0; i < letters.length; i++) {
			if (stack.pop() != letters[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	private String preprocess(String text) {
		String result = text.replaceAll("\\W", "");
		return result.toLowerCase();
	}
}
