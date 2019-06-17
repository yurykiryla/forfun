/**
 * 
 */
package com.example.lists.linkedlist.doubly;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.example.lists.Employee;

/**
 * @author Yury_Kiryla
 *
 */
public class EmployeeDoubleLinkedListTest {

	EmployeeDoubleLinkedList list;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new EmployeeDoubleLinkedList();
	}

	/**
	 * Test method for
	 * {@link com.example.lists.linkedlist.singly.EmployeeSingleLinkedList#addToFront(com.example.lists.Employee)}.
	 */
	@Test
	public void testAddToFront() {
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

		list.addToFront(janeJones);
		list.addToFront(johnDoe);
		list.addToFront(marySmith);
		list.addToFront(mikeWilson);

		list.printList();

		assertEquals(4, list.getSize());
	}
	
	@Test
	public void testAddToEnd() {
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
		
		list.addToEnd(janeJones);
		list.addToEnd(johnDoe);
		list.addToEnd(marySmith);
		list.addToEnd(mikeWilson);
		
		list.printList();
		
		assertEquals(4, list.getSize());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(list.isEmpty());

		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

		list.addToFront(janeJones);
		list.addToFront(johnDoe);
		list.addToFront(marySmith);
		list.addToFront(mikeWilson);

		assertFalse(list.isEmpty());
	}

	@Test
	public void testRemoveFromFront() {
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

		list.addToFront(janeJones);
		list.addToFront(johnDoe);
		list.addToFront(marySmith);
		list.addToFront(mikeWilson);

		assertNotNull(list.removeFromFront());
		assertEquals(3, list.getSize());
		assertEquals(marySmith, list.removeFromFront().getEmployee());
	}
	
	@Test
	public void testRemoveFromEnd() {
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

		list.addToFront(janeJones);
		list.addToFront(johnDoe);
		list.addToFront(marySmith);
		list.addToFront(mikeWilson);

		assertNotNull(list.removeFromEnd());
		assertEquals(3, list.getSize());
		assertEquals(johnDoe, list.removeFromEnd().getEmployee());
	}
}
