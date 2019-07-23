/**
 * 
 */
package com.example.queues;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.utils.Employee;

/**
 * @author Yury_Kiryla
 *
 */
class ArrayQueueTest {

	ArrayQueue queue;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.example.queues.ArrayQueue#add(com.example.utils.Employee)}.
	 */
	@Test
	void testAdd() {
		queue = new ArrayQueue(2);

		assertEquals(0, queue.size());

		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

		queue.add(janeJones);
		queue.add(johnDoe);
		queue.add(marySmith);
		queue.add(mikeWilson);

		assertEquals(4, queue.size());
	}

	/**
	 * Test method for {@link com.example.queues.ArrayQueue#remove()}.
	 */
	@Test
	void testRemove() {
		queue = new ArrayQueue(10);

		assertThrows(NoSuchElementException.class, () -> queue.remove());

		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

		queue.add(janeJones);
		queue.add(johnDoe);
		queue.add(marySmith);
		queue.add(mikeWilson);

		assertSame(janeJones, queue.remove());
		assertSame(johnDoe, queue.remove());
		assertEquals(2, queue.size());
	}

	/**
	 * Test method for {@link com.example.queues.ArrayQueue#peek()}.
	 */
	@Test
	void testPeek() {
		queue = new ArrayQueue(10);

		assertThrows(NoSuchElementException.class, () -> queue.peek());

		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

		queue.add(janeJones);
		queue.add(johnDoe);
		queue.add(marySmith);
		queue.add(mikeWilson);

		assertSame(janeJones, queue.peek());
		assertEquals(4, queue.size());
	}

}
