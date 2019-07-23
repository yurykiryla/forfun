package com.example.queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeCheck {
	public boolean isPalindrome(String phrase) {
		if (phrase == null || phrase.isBlank()) {
			return true;
		}
		String text = preprocess(phrase);

		if (text == null || text.isBlank()) {
			return true;
		}

		Stack<Character> stack = new Stack<>();
		Queue<Character> queue = new LinkedList<Character>();

		for (int i = 0; i < text.length(); i++) {
			char letter = text.charAt(i);
			stack.push(letter);
			queue.add(letter);
		}

		while (!stack.isEmpty()) {
			if (stack.pop() != queue.remove()) {
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
