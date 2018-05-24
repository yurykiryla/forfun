package problems.p84;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import problems.p084.LargestRectangleInHistogram;

class LargestRectangleInHistogramTest {
	
	LargestRectangleInHistogram solution;

	@BeforeEach
	void setUp() throws Exception {
		solution = new LargestRectangleInHistogram();
	}

	@Test
	void testLargestRectangleArea() {
		int[] heights = {2,1,5,6,2,3000000};
		int expected = 3000000;
		int actual = solution.largestRectangleArea(heights);
		assertEquals(expected, actual);
	}

	@Test
	void testLargestRectangleAreaWithSet() {
		int[] heights = {2,1,5,6,2,3000000};
		int expected = 3000000;
		int actual = solution.largestRectangleAreaWithSet(heights);
		assertEquals(expected, actual);
	}
}
