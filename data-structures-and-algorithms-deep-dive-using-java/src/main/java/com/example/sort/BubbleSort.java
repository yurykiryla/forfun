/**
 * 
 */
package com.example.sort;

import com.example.utils.Utilities;

/**
 * https://www.udemy.com/data-structures-and-algorithms-deep-dive-using-java/learn/v4/t/lecture/8435762?start=0
 * 
 * @author Yury_Kiryla
 *
 */
public class BubbleSort {
	
	private Utilities utilities = new Utilities();
	
	public void sort(int[] array) {
		for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
			for (int i = 0; i < lastUnsortedIndex; i++) {
				if (array[i] > array[i + 1]) {
					utilities.swap(array, i, i + 1);
				}
			}
		}
	}

}
