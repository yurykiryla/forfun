package com.example.lists.linkedlist.singly;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntegerLinkedListTest {

	IntegerLinkedList list;

	@BeforeEach
	public void setUp() throws Exception {
		list = new IntegerLinkedList();
	}

	@Test
	public void testAddToFront() {
		list.addToFront(5);
		list.addToFront(3);
		list.addToFront(10);

		assertEquals(3, list.getSize());
		assertEquals(10, list.removeFromFront());
	}

	@Test
	public void testRemoveFromFront() {
		list.addToFront(3);
		list.addToFront(1);

		assertEquals(1, list.removeFromFront());
		assertEquals(1, list.getSize());
	}

	@Test
	public void testInsertSorted() {
		list.insertSorted(4);
		list.insertSorted(2);
		list.insertSorted(1);
		list.insertSorted(3);
		list.insertSorted(5);
		list.insertSorted(2);

		list.printList();

		assertEquals(1, list.removeFromFront());
		assertEquals(2, list.removeFromFront());
		assertEquals(2, list.removeFromFront());
		assertEquals(3, list.removeFromFront());
		assertEquals(4, list.removeFromFront());
		assertEquals(5, list.removeFromFront());

	}

}
