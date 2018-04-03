package grokaem.algoritmy.ch1;

import java.util.Optional;

public class BinarySearch {
	
	public Optional<Integer> search(int[] array, int value) {
		int first = 0;
		int last = array.length - 1;

		while (first <= last) {
			int i = (first + last) / 2;
			int guess = array[i];
			if (guess == value) {
				return Optional.of(guess);
			}
			
			if (guess > value) {
				last = i - 1;
			} else {
				first = i + 1;
			}
		}
		
		return Optional.empty();
	}

}
