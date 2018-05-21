/**
 * 
 */
package com.example.sort;

import java.util.Arrays;

/**
 * @author Yury_Kiryla
 *
 */
public class CountingSort {

	public void sort(int[] array) {
		int min = Arrays.stream(array).min().getAsInt();
		int max = Arrays.stream(array).max().getAsInt();
		countingSort(array, min, max);
	}
	
	private void countingSort(int[] input, int min, int max) {
		int[] countArray = new int[(max - min) + 1];
		for (int i = 0; i < input.length; i++) {
			countArray[input[i] - min]++;
		}
		
		int j = 0;
		for (int i = min; i <= max; i++) {
			while (countArray[i - min] > 0) {
				input[j++] = i;
				countArray[i - min]--;
			}
		}
	}
}
