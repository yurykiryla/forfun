package problems.p16;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {
	
	private Solution solution;

	@BeforeEach
	void setUp() throws Exception {
		solution = new Solution();
	}

	@Test
	void testThreeSumClosest() {
		int[] nums = {1,1,1,0};
		int target = -100;
		int expected = 2;
		int actual = solution.threeSumClosest(nums, target);
		assertEquals(expected, actual);
	}

	@Test
	void testThreeSumClosestBigger() {
		int[] nums = {1,2,4,8,16,32,64,128};
		int target = 82;
		int expected = 82;
		int actual = solution.threeSumClosest(nums, target);
		assertEquals(expected, actual);
	}
}
