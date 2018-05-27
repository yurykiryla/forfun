/**
 * 
 */
package problems.p023;

import problems.p002.ListNode;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe 
 * its complexity.
 * 
 * Example:
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * 
 * @author Катя
 *
 */
public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        ListNode result = lists[0];
        
        for (int i = 1; i < lists.length; i++) {
            if (result == null) {
                result = lists[i];
                continue;
            }
            ListNode current = lists[i];
            ListNode pointer = result;
            
            while (current != null) {
                ListNode temp = current;
                current = current.next;
                if (temp.val <= result.val) {
                    temp.next = result;
                    result = temp;
                    pointer = result;
                } else if (pointer.next == null) {
                    pointer.next = temp;
                    break;
                } else {
                    while (pointer.next != null) {
                        if (pointer.val <= temp.val && pointer.next.val >= temp.val) {
                            temp.next = pointer.next;
                            pointer.next = temp;
                            pointer = temp;
                            break;
                        } else {
                            pointer = pointer.next;
                        }
                    }
                    if (pointer.next == null) {
                        pointer.next = temp;
                        break;
                    }
                }
                
            }
        }
        
        return result;
    }
	
	public ListNode recursiveMergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        if (lists.length == 1) {
            return lists[0];
        }

        int mid = lists.length / 2;
        ListNode[] leftArray = new ListNode[mid];
        ListNode[] rightArray = new ListNode[lists.length - mid];
        System.arraycopy(lists, 0, leftArray, 0, mid);
        System.arraycopy(lists, mid, rightArray, 0, rightArray.length);
        return merge(recursiveMergeKLists(leftArray), recursiveMergeKLists(rightArray));
    }
        
    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        ListNode result = null;
        if (left.val <= right.val) {
            result = left;
            left = left.next;
        } else {
            result = right;
            right = right.next;
        }
        
        ListNode current = result;
        
        while (left != null && right != null) {
            if (left.val <= right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        if (left != null) {
            current.next = left;
        } else {
            current.next = right;
        }
        
        return result;
    }
}
