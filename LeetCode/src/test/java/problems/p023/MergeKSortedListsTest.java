/**
 * 
 */
package problems.p023;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import problems.TestHelper;
import problems.p002.ListNode;

/**
 * @author Катя
 *
 */
class MergeKSortedListsTest {
	MergeKSortedLists solution;
	TestHelper helper;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		solution = new MergeKSortedLists();
		helper = new TestHelper();
	}

	/**
	 * Test method for
	 * {@link problems.p023.MergeKSortedLists#mergeKLists(problems.p002.ListNode[])}.
	 */
	@Test
	void testMergeKLists() {
		int[][] array = { { 1, 4, 5 }, { 1, 3, 4 }, { 2, 6 } };
		ListNode[] lists = convert(array);
		ListNode result = solution.mergeKLists(lists);
		while (result.next != null) {
			assertTrue(result.val <= result.next.val);
			result = result.next;
		}
	}

	/**
	 * Test method for
	 * {@link problems.p023.MergeKSortedLists#mergeKLists(problems.p002.ListNode[])}.
	 */
	@Test
	void testMergeKLists_empty() {
		int[][] array = { { 1, 4, 5 }, {}, { 2, 6 } };
		ListNode[] lists = convert(array);
		ListNode result = solution.mergeKLists(lists);
		while (result.next != null) {
			assertTrue(result.val <= result.next.val);
			result = result.next;
		}
	}

	/**
	 * Test method for
	 * {@link problems.p023.MergeKSortedLists#mergeKLists(problems.p002.ListNode[])}.
	 */
	@Test
	void testMergeKLists_big() {
		int[][] array = { { -10, -9, -9, -9, -7, -2, -1, 2, 4 }, { -9, -7, -6, -6, -3, 0, 1, 3 },
				{ -10, -9, -2, -1, 1, 3 } };
		ListNode[] lists = convert(array);
		ListNode result = solution.mergeKLists(lists);
		while (result.next != null) {
			assertTrue(result.val <= result.next.val);
			result = result.next;
		}
	}
	
	/**
	 * Test method for
	 * {@link problems.p023.MergeKSortedLists#mergeKLists(problems.p002.ListNode[])}.
	 */
	@Test
	void testMergeKLists_single() {
		int[][] array = { 
				{-6,-3,-1,1,2,2,2},
				{-10,-8,-6,-2,4},
				{-2},
				{-8,-4,-3,-3,-2,-1,1,2,3},
				{-8,-6,-5,-4,-2,-2,2,4}
		};
		ListNode[] lists = convert(array);
		ListNode result = solution.mergeKLists(lists);
		while (result.next != null) {
			assertTrue(result.val <= result.next.val);
			result = result.next;
		}
	}

	private ListNode[] convert(int[][] array) {
		ListNode[] result = new ListNode[array.length];
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				result[i] = helper.getLinkedList(array[i]);
			}
		}
		return result;
	}
}
