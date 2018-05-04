package problems.p002;

import java.util.Stack;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 * 
 * You are given two non-empty linked lists representing two non-negative integers. The digits 
 * are stored in reverse order and each of their nodes contain a single digit. Add the two numbers 
 * and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * @author Yury_Kiryla
 *
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<ListNode> stack1 = convertToStack(l1);
		Stack<ListNode> stack2 = convertToStack(l2);

		ListNode result = null;

		while (!stack1.empty() && !stack2.empty()) {
			ListNode current1 = stack1.empty() ? null : stack1.pop();
			ListNode current2 = stack2.empty() ? null : stack2.pop();

			int amount = 0;
			if (current1 != null) {
				amount += current1.val;
			}
			if (current2 != null) {
				amount += current2.val;
			}

			ListNode upper = new ListNode(0);
			if (amount >= 10) {
				upper.val = 1;
				amount -= 10;
			}
			result = new ListNode(amount);
			upper.next = result;
			result = upper;
		}

		return result;
	}

	private Stack<ListNode> convertToStack(ListNode listNode) {
		Stack<ListNode> result = new Stack<>();
		ListNode current = listNode;

		while (current != null) {
			result.push(current);
			current = current.next;
		}

		return result;
	}
}
