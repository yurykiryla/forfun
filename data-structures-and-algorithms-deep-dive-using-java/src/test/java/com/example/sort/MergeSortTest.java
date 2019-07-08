/**
 * 
 */
package com.example.sort;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Yury
 *
 */
public class MergeSortTest {

	MergeSort solution;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		solution = new MergeSort();
	}

	/**
	 * Test method for {@link com.example.sort.MergeSort#sort(int[])}.
	 */
	@Test
	public void testSort() {
		int[] array = new Random().ints(5000000, 1, 1000).toArray();
		solution.sort(array);
		for (int i = 0; i < array.length - 2; i++) {
			assertTrue(array[i] <= array[i + 1]);
		}
	}

	@Test
	public void descendingSortTest() {
		int[] array = new Random().ints(5000000, 1, 1000).toArray();
		solution.descendingSort(array);
		for (int i = 0; i < array.length - 2; i++) {
			assertTrue(array[i] >= array[i + 1]);
		}
	}
}
