package problems.p668;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {
	Solution solution;

	@BeforeEach
	void setUp() throws Exception {
		solution = new Solution();
	}

	@Test
	void testFindKthNumber() {
		int actual = solution.findKthNumber(300, 400, 900);
		assertEquals(170, actual);
	}

	@Test
	void testFindKthNumberBinary() {
		int actual = solution.findKthNumberBinary(300, 400, 900);
		assertEquals(170, actual);
	}
}
