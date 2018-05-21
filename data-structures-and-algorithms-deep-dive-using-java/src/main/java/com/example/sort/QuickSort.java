/**
 * 
 */
package com.example.sort;

/**
 * @author Yury_Kiryla
 *
 */
public class QuickSort {

	public void sort(int[] array) {
		quickSort(array, 0, array.length);

	}

	private void quickSort(int[] input, int start, int end) {
		if (end - start < 2) {
			return;
		}
		int pivotIndex = partition(input, start, end);
		quickSort(input, start, pivotIndex);
		quickSort(input, pivotIndex + 1, end);
	}

	private int partition(int[] input, int start, int end) {
		// this is using the first element as a pivot
		int pivot = input[start];

		int i = start;
		int j = end;

		while (i < j) {

			// Empty loop - just decrement j
			while (i < j && input[--j] >= pivot)
				;

			if (i < j) {
				input[i] = input[j];
			}

			// Empty loop - just increment i
			while (i < j && input[++i] <= pivot)
				;
			if (i < j) {
				input[j] = input[i];
			}
		}
		input[j] = pivot;
		return j;
	}
}
