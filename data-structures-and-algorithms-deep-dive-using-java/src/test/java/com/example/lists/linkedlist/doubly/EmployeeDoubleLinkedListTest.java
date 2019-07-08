/**
 * 
 */
package com.example.lists.linkedlist.doubly;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.utils.Employee;

/**
 * @author Yury_Kiryla
 *
 */
public class EmployeeDoubleLinkedListTest {

	EmployeeDoubleLinkedList list;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		list = new EmployeeDoubleLinkedList();
	}

	/**
	 * Test method for
	 * {@link com.example.lists.linkedlist.singly.EmployeeSingleLinkedList#addToFront(com.example.utils.Employee)}.
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

//		list.printList();

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

//		list.printList();

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

	@Test
	public void testAddBefore_beforeFirstElement() {
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

		Employee jamesBond = new Employee("James", "Bond", 122);

		list.addToFront(janeJones);
		list.addToFront(johnDoe);
		list.addToFront(marySmith);
		list.addToFront(mikeWilson);

		assertEquals(1, list.addBefore(jamesBond, mikeWilson));
		assertEquals(5, list.getSize());
//		list.printList();
		assertEquals(jamesBond, list.removeFromFront().getEmployee());
	}

	@Test
	public void testAddBefore_inMiddle() {
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

		Employee jamesBond = new Employee("James", "Bond", 122);

		list.addToFront(janeJones);
		list.addToFront(johnDoe);
		list.addToFront(marySmith);
		list.addToFront(mikeWilson);

		assertEquals(1, list.addBefore(jamesBond, marySmith));
		assertEquals(5, list.getSize());
//		list.printList();
		list.removeFromFront();
		assertEquals(jamesBond, list.removeFromFront().getEmployee());
	}
}
