/**
 * 
 */
package com.example.sort;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Yury_Kiryla
 *
 */
public class SelectionSortTest {

	SelectionSort solution;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		solution = new SelectionSort();
	}

	/**
	 * Test method for {@link com.example.sort.SelectionSortTest#sort(int[])}.
	 */
	@Test
	public void testSort() {
		int[] array = { 2, -4, 6, 22, -15, 5, 8 };
		solution.sort(array);
		for (int i = 0; i < array.length - 2; i++) {
			assertTrue(array[i] <= array[i + 1]);
		}
	}

}
