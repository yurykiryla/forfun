package grokeam.alg.ch1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchTest {

	@Test
	void test() {
		int[] array = {1,3,5,6,7,8,9,11,23};
		assertEquals(1, (int)(new BinarySearch().search(array, 1)));
	}

}
