/**
 * 
 */
package com.example.sort;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Yury_Kiryla
 *
 */
public class InsertionSortTest {

	private InsertionSort solution;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		solution = new InsertionSort();
	}

	/**
	 * Test method for {@link com.example.sort.InsertionSort#sort(int[])}.
	 */
	@Test
	public void testSort() {
		int[] array = { 2, -4, 6, 22, -15, 5, 8 };
		solution.sort(array);
		for (int i = 0; i < array.length - 2; i++) {
			assertTrue(array[i] <= array[i + 1]);
		}
	}

	@Test
	public void recursiveSortTest() {
		int[] array = { 2, -4, 6, 22, -15, 5, 8 };
		solution.recursiveSort(array);
		for (int i = 0; i < array.length - 2; i++) {
			assertTrue(array[i] <= array[i + 1]);
		}
	}
}
