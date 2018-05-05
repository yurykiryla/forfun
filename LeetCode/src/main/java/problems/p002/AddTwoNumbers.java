package problems.p002;

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
        if (l1 == null && l2 == null) {
            return null;
        }
        
        ListNode root = null;
        ListNode parent = null;
        ListNode current = null;
        
        do {
            int amount = 0;
            
            if (l1 != null) {
                amount += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                amount += l2.val;
                l2 = l2.next;
            }
            if (current != null) {
                amount += current.val;
            } else {
                current = new ListNode(0);
            }
            if (root == null) {
                root = current;
                parent = current;
            } else if (root.next == null) {
                root.next = current;
            } else {
                parent.next = current;
            }
            ListNode next = null;
            if (amount >= 10) {
                next = new ListNode(1);
                amount -= 10;
            }
            
            current.val = amount;
            parent = current;
            parent.next = next;
            current = next;
            
        } while (l1 != null || l2 != null);
        
        return root;
	}
}
