/**
 * 
 */
package com.example.sort;

import com.example.utils.Utilities;

/**
 * @author Yury_Kiryla
 *
 */
public class BubbleSort {
	
	private Utilities utilities = new Utilities();
	
	public void sort(int[] array) {
		for (int i = array.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					utilities.swap(array, j, j + 1);
				}
			}
		}
	}

}