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

	public void recursiveSort(int[] array) {
		insertionSort(array, array.length);
	}
	
	private void insertionSort(int[] input, int numItems) {
		if (numItems > 1) {
			insertionSort(input, numItems - 1);
			
			int newElement = input[numItems - 1];
			
			int i;
			
			for (i = numItems - 1; i > 0 && input[i - 1] > newElement; i--) {
				input[i] = input[i - 1];
			}
			
			input[i] = newElement;
		}
	}
}
