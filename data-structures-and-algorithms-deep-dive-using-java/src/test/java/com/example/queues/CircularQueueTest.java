package com.example.queues;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.utils.Employee;

class CircularQueueTest {
	
	CircularQueue queue;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAdd() {
		queue = new CircularQueue(2);

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

	@Test
	void testRemove() {
		queue = new CircularQueue(10);

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

	@Test
	void testPeek() {
		queue = new CircularQueue(10);

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
