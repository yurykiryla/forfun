package problems.p002;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddTwoNumbersTest {
	AddTwoNumbers solution;

	@BeforeEach
	void setUp() throws Exception {
		solution = new AddTwoNumbers();
	}

	@Test
	void testAddTwoNumbers() {
		ListNode l1 = getList(2, 4, 3);
		ListNode l2 = getList(5, 6, 4);
		ListNode result = solution.addTwoNumbers(l1, l2);
		assertEquals(7, result.val);
	}

	private ListNode getList(int ... numbers) {
		ListNode parent = new ListNode(numbers[0]);
		ListNode next = new ListNode(numbers[1]);
		parent.next = next;
		for (int i = 2; i < numbers.length; i++) {
			ListNode current = new ListNode(numbers[i]);
			next.next = current;
			next = current;
		}
		return parent;
	}
}
