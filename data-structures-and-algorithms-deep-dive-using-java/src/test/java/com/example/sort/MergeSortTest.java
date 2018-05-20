/**
 * 
 */
package com.example.sort;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Катя
 *
 */
public class MergeSortTest {
	
	MergeSort solution;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		solution = new MergeSort();
	}

	/**
	 * Test method for {@link com.example.sort.MergeSort#sort(int[])}.
	 */
	@Test
	public void testSort() {
		int[] array = {2, -4, 6, 22, -15, 5, 8};
		solution.sort(array);
		for (int i = 0; i < array.length - 2; i ++) {
			assertTrue(array[i] <= array[i + 1]);
		}
	}

}
