/**
 * 
 */
package com.example.lists.linkedlist.singly;

import com.example.utils.Employee;

/**
 * @author Yury_Kiryla
 *
 */
public class EmployeeSingleLinkedList {
	
	private EmployeeNode head;
	private int size;

	public void addToFront(Employee employee) {
		EmployeeNode node = new EmployeeNode(employee);
		node.setNext(head);
		head = node;
		size++;
	}
	
	public EmployeeNode removeFromFront() {
		if (isEmpty()) {
			return null;
		}
		
		EmployeeNode removedNode = head;
		head = head.getNext();
		size--;
		removedNode.setNext(null);
		
		return removedNode;
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
		EmployeeNode current = head;
		System.out.print("HEAD -> ");
		while (current != null) {
			System.out.print(current);
			System.out.print(" -> ");
			current = current.getNext();
		}
		System.out.println("null");
	}
}
