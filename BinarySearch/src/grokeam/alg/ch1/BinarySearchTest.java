package grokeam.alg.ch1;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

class BinarySearchTest {

	@Test
	void test() {
		int[] array = {1,3,5,6,7,8,9,11,23};
		assertEquals(1, (int)(new BinarySearch().search(array, 1)));
	}

}
