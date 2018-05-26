package problems.p002;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import problems.TestHelper;

class AddTwoNumbersTest {
	AddTwoNumbers solution;
	TestHelper helper = new TestHelper();

	@BeforeEach
	void setUp() throws Exception {
		solution = new AddTwoNumbers();
	}

	@Test
	void testAddTwoNumbers() {
		ListNode l1 = helper.getLinkedList(2, 4, 3);
		ListNode l2 = helper.getLinkedList(5, 6, 4);
		ListNode result = solution.addTwoNumbers(l1, l2);
		assertEquals(7, result.val);
	}
}
