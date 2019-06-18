/**
 * 
 */
package com.example.lists.linkedlist.singly;

/**
 * @author Yury_Kiryla
 *
 */
public class IntegerLinkedList {

	private ListNode head;
	private int size;

	public void addToFront(int i) {
		ListNode node = new ListNode(i);
		node.next = head;
		head = node;
		size++;
	}

	public int removeFromFront() {
		if (isEmpty()) {
			throw new UnsupportedOperationException("empty list");
		}

		ListNode removedNode = head;
		head = head.next;
		size--;

		return removedNode.value;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void printList() {
		ListNode current = head;
		System.out.print("HEAD -> ");
		while (current != null) {
			System.out.print(current);
			System.out.print(" -> ");
			current = current.next;
		}
		System.out.println("null");
	}
	
	public void insertSorted(int i) {
		size++;
		ListNode newNode = new ListNode(i);
		
		if (isEmpty()) {
			head = newNode;
		} else if (i <= head.value) {
			newNode.next = head;
			head = newNode;
		} else {
			ListNode current = head;
			while (current.next != null && current.next.value < i) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
		}
	}

	private static class ListNode {
		final int value;
		ListNode next;

		public ListNode(int value) {
			super();
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}
}
