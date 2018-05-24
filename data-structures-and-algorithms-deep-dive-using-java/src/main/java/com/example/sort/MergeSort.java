package com.example.sort;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class MergeSort {

	public void sort(int[] array) {
		mergeSort(array, 0, array.length);

	}

	private void mergeSort(int[] input, int start, int end) {
		if (end - start > 1) {
			int mid = (start + end) / 2;
			mergeSort(input, start, mid);
			mergeSort(input, mid, end);
			merge(input, start, mid, end);
		}
	}

	private void merge(int[] input, int start, int mid, int end) {
		if (input[mid] < input[mid - 1]) {
			int i = start;
			int j = mid;
			int tempIndex = 0;
			int[] temp = new int[end - start];
			while (i < mid && j < end) {
				temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
			}

			System.arraycopy(input, i, input, start + tempIndex, mid - i);
			System.arraycopy(temp, 0, input, start, tempIndex);
		}
	}
	
	public void descendingSort(int[] array) {
		ForkJoinPool pool = ForkJoinPool.commonPool();
		pool.invoke(new mergeSortAction(array, 0, array.length));
	}
	
	static class mergeSortAction extends RecursiveAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int[] input;
		int start;
		int end;

		public mergeSortAction(int[] input, int start, int end) {
			super();
			this.input = input;
			this.start = start;
			this.end = end;
		}

		@Override
		protected void compute() {
			if (end - start > 1) {
				int mid = (start + end) / 2;
				new mergeSortAction(input, start, mid).compute();
				new mergeSortAction(input, mid, end).compute();
				merge(input, start, mid, end);
			}
		}
		
		private void merge(int[] input, int start, int mid, int end) {
			if (input[mid] > input[mid - 1]) {
				int i = start;
				int j = mid;
				int tempIndex = 0;
				int[] temp = new int[end - start];
				while (i < mid && j < end) {
					temp[tempIndex++] = input[i] >= input[j] ? input[i++] : input[j++];
				}

				System.arraycopy(input, i, input, start + tempIndex, mid - i);
				System.arraycopy(temp, 0, input, start, tempIndex);
			}
		}
	}
}
