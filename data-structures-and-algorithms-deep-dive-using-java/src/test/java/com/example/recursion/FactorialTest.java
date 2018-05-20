package com.example.recursion;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

public class FactorialTest {
	
	private Factorial solution;

	@Before
	public void setUp() throws Exception {
		solution = new Factorial();
	}

	@Test
	public void testIterativeFactorial() {
		int n = 10;
		int expected = IntStream
				.rangeClosed(1, n)
				.reduce(1, (a, b) -> a * b);
		int actual = solution.iterativeFactorial(n);
		assertEquals(expected, actual);
	}

	@Test
	public void testRecursiveFactorial() {
		int n = 10;
		int expected = IntStream
				.rangeClosed(1, n)
				.reduce(1, (a, b) -> a * b);
		int actual = solution.recursiveFactorial(n);
		assertEquals(expected, actual);
	}

}
