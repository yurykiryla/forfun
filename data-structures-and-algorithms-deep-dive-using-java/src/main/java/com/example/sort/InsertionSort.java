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
		for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
			int newElement = array[firstUnsortedIndex];
			
			int i;
			
			for (i = firstUnsortedIndex; i > 0 && array[i - 1] > newElement; i--) {
				array[i] = array[i - 1];
			}
			
			array[i] = newElement;
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
