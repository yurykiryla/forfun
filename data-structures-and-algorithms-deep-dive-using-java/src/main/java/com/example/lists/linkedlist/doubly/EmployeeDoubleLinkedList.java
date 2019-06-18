/**
 * 
 */
package com.example.lists.linkedlist.doubly;

import com.example.lists.Employee;

/**
 * @author Yury_Kiryla
 *
 */
public class EmployeeDoubleLinkedList {

	private EmployeeNode head;
	private EmployeeNode tail;
	private int size;

	public void addToFront(Employee employee) {
		EmployeeNode node = new EmployeeNode(employee);
		node.setNext(head);

		if (head == null) {
			tail = node;
		} else {
			head.setPrevious(node);
		}

		head = node;
		size++;
	}

	public void addToEnd(Employee employee) {
		EmployeeNode node = new EmployeeNode(employee);

		if (tail == null) {
			head = node;
		} else {
			tail.setNext(node);
			node.setPrevious(tail);
		}

		tail = node;
		size++;
	}

	public EmployeeNode removeFromFront() {
		if (isEmpty()) {
			return null;
		}

		EmployeeNode removedNode = head;
		
		if (head.getNext() == null) {
			tail = null;
		} else {
			head.getNext().setPrevious(null);
		}
		head = head.getNext();
		size--;
		removedNode.setNext(null);

		return removedNode;
	}
	
	public EmployeeNode removeFromEnd() {
		if (isEmpty()) {
			return null;
		}
		
		EmployeeNode removedNode = tail;
		if (size == 1) {
			head = null;
		} else {
			tail = tail.getPrevious();
			tail.setNext(null);
		}
		size--;
		removedNode.setPrevious(null);
		
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
			System.out.print(" <=> ");
			current = current.getNext();
		}
		System.out.println("null");
	}
	
	public int addBefore(Employee newEmployee, Employee existingEmployee) {
		if (isEmpty() || newEmployee == null || existingEmployee == null ) {
			throw new IllegalArgumentException();
		}
		
		EmployeeNode current = head;
		
		int result = 0;
		
		do {
			if (current.getEmployee().equals(existingEmployee)) {
				result++;
				size++;
				
				EmployeeNode newEmployeeNode = new EmployeeNode(newEmployee);
				newEmployeeNode.setNext(current);
				
				if (current.getPrevious() == null) {
					head = newEmployeeNode;
				} else {
					current.getPrevious().setNext(newEmployeeNode);
					newEmployeeNode.setPrevious(current.getPrevious());
				}
				
				current.setPrevious(newEmployeeNode);
			}
			current = current.getNext();
		} while (current != null);
		
		return result;
	}
}
