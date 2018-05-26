/**
 * 
 */
package problems;

import problems.p002.ListNode;

/**
 * @author Катя
 *
 */
public class TestHelper {
	
	public ListNode getLinkedList(int ... numbers) {
		if (numbers == null || numbers.length == 0) {
			return null;
		}
		ListNode parent = new ListNode(numbers[0]);
		if (numbers.length == 1) {
			return parent;
		}
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
