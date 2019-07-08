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
public class BubbleSortTest {

	private BubbleSort solution;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		solution = new BubbleSort();
	}

	/**
	 * Test method for {@link com.example.sort.BubbleSort#sort(int[])}.
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
