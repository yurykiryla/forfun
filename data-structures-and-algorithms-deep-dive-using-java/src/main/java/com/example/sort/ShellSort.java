/**
 * 
 */
package com.example.sort;

/**
 * @author Yury_Kiryla
 *
 */
public class ShellSort {
	
	public void sort(int[] array) {
		for (int gap = array.length / 2; gap > 0; gap /= 2) {
			for (int i = 1; i < array.length; i++) {
				int newElement = array[i];
				int j = i;
				
				while (j >= gap && array[j - gap] > newElement) {
					array[j] = array[j - gap];
					j -= gap;
				}
				array[j] = newElement;
			}
		}
	}

}
