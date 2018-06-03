/**
 * 
 */
package com.example.sort;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Yury_Kiryla
 *
 */
public class RadixSortTest {
	
	RadixSort solution;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		solution = new RadixSort();
	}

	/**
	 * Test method for {@link com.example.sort.RadixSort#sort(int[])}.
	 */
	@Test
	public void testSort() {
		int[] array = new Random().ints(1000, 1000, 10000).toArray();
		solution.sort(array);
		for (int i = 0; i < array.length - 2; i++) {
			assertTrue(array[i] <= array[i + 1]);
		}
	}

	@Test
	public void testSortString() {
		String[] array = {"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};
		solution.sort(array);
		for (int i = 0; i < array.length - 2; i++) {
			assertTrue(array[i].compareTo(array[i + 1]) <= 0);
		}
	}
}
