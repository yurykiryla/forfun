/**
 * 
 */
package com.example.sort;

import com.example.utils.Utilities;

/**
 * @author Yury_Kiryla
 *
 */
public class SelectionSort {

	private Utilities utilities = new Utilities();

	public void sort(int[] array) {
		for (int i = array.length - 1; i > 0; i--) {
			int max = 0;
			for (int j = 1; j <= i; j++) {
				if (array[j] > array[max]) {
					max = j;
				}
			}
			utilities.swap(array, i, max);
		}
	}

}
