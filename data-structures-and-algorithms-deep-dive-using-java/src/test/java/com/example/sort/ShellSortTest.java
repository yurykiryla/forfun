package com.example.sort;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShellSortTest {

	ShellSort solution;

	@BeforeEach
	public void setUp() throws Exception {
		solution = new ShellSort();
	}

	@Test
	public void testSort() {
		int[] array = { 2, -4, 6, 22, -15, 5, 8 };
		solution.sort(array);
		for (int i = 0; i < array.length - 2; i++) {
			assertTrue(array[i] <= array[i + 1]);
		}
	}

}
