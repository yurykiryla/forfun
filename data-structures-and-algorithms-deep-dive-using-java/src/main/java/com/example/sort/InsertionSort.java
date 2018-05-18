/**
 * 
 */
package com.example.sort;

/**
 * @author Yury_Kiryla
 *
 */
public class InsertionSort {
	
	public void sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int j = i - 1;
			int value = array[i];
			while (j >= 0 && array[j] > value) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = value;
		}
	}

}
