package problems.p004;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MedianOfTwoSortedArraysTest {
	
	MedianOfTwoSortedArrays solution;

	@BeforeEach
	void setUp() throws Exception {
		solution = new MedianOfTwoSortedArrays();
	}

	@Test
	void testFindMedianSortedArrays1() {
		int[] nums1 = {1, 3};
		int[] nums2 = {2};
		double actual = solution.findMedianSortedArrays(nums1, nums2);
		double expected = 2.0;
		assertEquals(expected, actual);
	}

	@Test
	void testFindMedianSortedArrays2() {
		int[] nums1 = {1, 2};
		int[] nums2 = {3, 4};
		double actual = solution.findMedianSortedArrays(nums1, nums2);
		double expected = 2.5;
		assertEquals(expected, actual);
	}
	
	@Test
	void testFindMedianSortedArrays3() {
		int[] nums1 = {1, 2, 3, 4, 5};
		int[] nums2 = {2, 5, 8, 9, 11};
		double actual = solution.findMedianSortedArrays(nums1, nums2);
		double expected = 4.5;
		assertEquals(expected, actual);
	}
}
