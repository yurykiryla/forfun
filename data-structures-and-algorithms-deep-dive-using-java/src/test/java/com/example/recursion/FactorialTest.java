package com.example.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FactorialTest {

	private Factorial solution;

	@BeforeEach
	public void setUp() throws Exception {
		solution = new Factorial();
	}

	@Test
	public void testIterativeFactorial() {
		int n = 10;
		int expected = IntStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b);
		int actual = solution.iterativeFactorial(n);
		assertEquals(expected, actual);
	}

	@Test
	public void testRecursiveFactorial() {
		int n = 10;
		int expected = IntStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b);
		int actual = solution.recursiveFactorial(n);
		assertEquals(expected, actual);
	}

}
