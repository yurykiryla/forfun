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
		for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
			int largest = 0;
			for (int i = 1; i <= lastUnsortedIndex; i++) {
				if (array[i] > array[largest]) {
					largest = i;
				}
			}
			utilities.swap(array, lastUnsortedIndex, largest);
		}
	}

}
