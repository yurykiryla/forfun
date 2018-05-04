package problems.p001;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoSumTest {
	
	TwoSum solution;

	@BeforeEach
	void setUp() throws Exception {
		solution = new TwoSum();
	}

	@Test
	void testTwoSum() {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] expected = {0, 1};
		int[] actual = solution.twoSum(nums, target);
		assertArrayEquals(expected, actual);
	}

	@Test
	void testTwoSumHM() {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] expected = {0, 1};
		int[] actual = solution.twoSumHM(nums, target);
		assertArrayEquals(expected, actual);
	}
}
