package grokeam.alg.ch1;

public class BinarySearch {
	
	public Integer search(int[] array, int value) {
		int first = 0;
		int last = array.length - 1;
		
		while (first <= last) {
			int i = (first + last) / 2;
			int guess = array[i];
			if (guess == value) {
				return guess;
			}
			
			if (guess > value) {
				last = i - 1;
			} else {
				first = i + 1;
			}
		}
		
		return null;
	}

}
