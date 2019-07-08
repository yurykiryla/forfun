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
public class CountingSortTest {

	CountingSort solution;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		solution = new CountingSort();
	}

	/**
	 * Test method for {@link com.example.sort.CountingSort#sort(int[])}.
	 */
	@Test
	public void testSort() {
		int[] array = { 2, 5, 3, 6, 3, 6, 7, 3, 2, 7, 10, 3, 5, 7, 4, 3, 2, 6, 3 };
		solution.sort(array);
		for (int i = 0; i < array.length - 2; i++) {
			assertTrue(array[i] <= array[i + 1]);
		}
	}

}
